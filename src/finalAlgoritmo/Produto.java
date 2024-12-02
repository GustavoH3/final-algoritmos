package finalAlgoritmo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Produto {
	private UUID id;
	private String nome;
	private Integer quantidade;
	
	public Produto(String nome, Integer quantidade){
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public Produto(String nome, Integer quantidade, UUID id){
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public static List<Produto> asList(String[] produtosStringArray){
		List<Produto> produtos = new ArrayList<>();
		for(String nomeDoProduto : produtosStringArray) {
			produtos.add(new Produto(nomeDoProduto, null));
		}
		return produtos;
	}
	
	public void salvar() {
        String sql = "INSERT INTO produto(id, nome, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setObject(1, this.id);
            stmt.setString(2, this.nome);
            stmt.setInt(3, this.quantidade);
           int teste = stmt.executeUpdate();
           if (teste > 0) {
               System.out.println("Produto inserido com sucesso.");
           }else {
        	   System.out.println("erro");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM Produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = conexaoBanco.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery(sql)) {

            while (resultado.next()) {
                UUID id = UUID.fromString(resultado.getString("id"));
                String nome = resultado.getString("nome");
                int quantidade = resultado.getInt("quantidade");
                produtos.add(new Produto(nome, quantidade, id));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }
	
    public boolean atualizarProdutoId(UUID id, String novoNome, Integer novaQuantidade) {
        String sql = "UPDATE Produto SET nome = ?, quantidade = ? WHERE id = ?";
        boolean atualizado = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, novaQuantidade);
            stmt.setObject(3, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                atualizado = true;
                System.out.println("Produto atualizado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }

        return atualizado;
    }
    
    public boolean atualizarProdutoNome(String nome, String novoNome, Integer novaQuantidade) {
        String sql = "UPDATE Produto SET nome = ?, quantidade = ? WHERE nome = ?";
        boolean atualizado = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, novaQuantidade);
            stmt.setObject(3, nome);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                atualizado = true;
                System.out.println("Produto atualizado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }

        return atualizado;
    }

    public boolean deletarProdutoId(UUID id) {
        String sql = "DELETE FROM Produto WHERE id = ?";
        boolean isDeleted = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                isDeleted = true;
                System.out.println("Produto deletado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }

        return isDeleted;
    }

    public boolean deletarProdutoPorNome(String nome) {
        String sql = "DELETE FROM Produto WHERE nome = ?";
        boolean isDeleted = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                isDeleted = true;
                System.out.println("Produto deletado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto por nome: " + e.getMessage());
        }

        return isDeleted;
    }
    
    @Override
    public String toString() {
        return "Produto \n" +
               "id= " + id +
               ", nome= " + nome +
               ", quantidade= " + quantidade + "\n"
             ;
    }
}
