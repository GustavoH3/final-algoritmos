package finalAlgoritmo;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Viagem {
	private UUID id;
	private String descricao;
	private String cidadeOrigem;
	private String cidadeDestino;
	private List<Produto> listaProdutos;
	private String motorista;
	private String cliente;
	private String status;
	
	public Viagem(String descricao, String cidadeOrigem, String cidadeDestino, Motorista motorista, Cliente cliente) {
		this.id = UUID.randomUUID();
		this.descricao = descricao;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.listaProdutos = new ArrayList<>();
		this.motorista = motorista.getNome();
		this.cliente = cliente.getNome();
		this.status = "Iniciada";
		motorista.iniciarViagem();
	}
	
	public void adicionarProduto(Produto produto) {
        if (produto != null) {
            listaProdutos.add(produto);
        }
    }

    public void exibirProdutos() {
        for (Produto produto : listaProdutos) {
            System.out.println(produto.getNome());
        }
}
	
	public void getMotorista() {
		System.out.println(this.motorista);
	}
	
	public void getCliente() {
		System.out.println(this.cliente);
	}
	
	public void finalizarViagem(Motorista motorista) {
		this.status = "Finalizada";
		motorista.finalizarViagem();
		
	}
	public String getStatus() {
		return this.status;
	}
	
    public void salvar() {
        String sql = "INSERT INTO viagem(id, descricao, cidadeOrigem, cidadeDestino, motorista, cliente, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, this.id);
            stmt.setString(2, this.descricao);
            stmt.setString(3, this.cidadeOrigem);
            stmt.setString(4, this.cidadeDestino);
            stmt.setString(5, this.motorista);
            stmt.setString(6, this.cliente);
            stmt.setString(7, this.status);

            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                System.out.println("Viagem inserida com sucesso.");
            } else {
                System.out.println("Erro ao inserir viagem.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Viagem> listarViagens() {
        String sql = "SELECT * FROM viagem";
        List<Viagem> viagens = new ArrayList<>();

        try (Connection conn = conexaoBanco.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery(sql)) {

            while (resultado.next()) {
                UUID id = UUID.fromString(resultado.getString("id"));
                String descricao = resultado.getString("descricao");
                String cidadeOrigem = resultado.getString("cidadeOrigem");
                String cidadeDestino = resultado.getString("cidadeDestino");
                String motorista = resultado.getString("motorista");
                String cliente = resultado.getString("cliente");
                String status = resultado.getString("status");

                Viagem viagem = new Viagem(descricao, cidadeOrigem, cidadeDestino, new Motorista(motorista), new Cliente(cliente));
                viagem.id = id;
                viagem.status = status;
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar viagens: " + e.getMessage());
        }
        return viagens;
    }

    public boolean atualizarStatus(UUID id, String novoStatus) {
        String sql = "UPDATE viagem SET status = ? WHERE id = ?";
        boolean atualizado = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setObject(2, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                atualizado = true;
                System.out.println("Status da viagem atualizado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar status da viagem: " + e.getMessage());
        }

        return atualizado;
    }

    public boolean deletarViagem(UUID id) {
        String sql = "DELETE FROM viagem WHERE id = ?";
        boolean isDeleted = false;

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                isDeleted = true;
                System.out.println("Viagem deletada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar viagem: " + e.getMessage());
        }

        return isDeleted;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", cidadeOrigem='" + cidadeOrigem + '\'' +
                ", cidadeDestino='" + cidadeDestino + '\'' +
                ", motorista='" + motorista + '\'' +
                ", cliente='" + cliente + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
