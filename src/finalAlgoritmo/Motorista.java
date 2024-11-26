package finalAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.*;

public class Motorista extends Pessoa {
	private Integer CNH;
	private Boolean status;
	
	public Motorista(Integer CNH, String nome, String cidade, String CPF) {
		super(nome, CPF, cidade);
		this.CNH = CNH;
		this.status = false;
	}
	
	public Motorista(Integer CNH, String nome, String cidade, String CPF, UUID ID, Boolean status) {
		super(nome, CPF, cidade);
		this.CNH = CNH;
		this.status = status;
		setID(ID);
	}
	
	public UUID getId(){
		return super.getId();
	}
	
	public void iniciarViagem() {
		this.status = true;
	}
	
	public void finalizarViagem() {
		this.status = false;
	}
	
	public void salvar() {
        String sql = "INSERT INTO Pessoa(nome, cidade, cpf, status, cnh, id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, super.getNome());
            stmt.setString(2, super.getCidade());
            stmt.setString(3, super.getCPF());
            stmt.setBoolean(4, this.status);
            stmt.setInt(5, this.CNH);
            stmt.setObject(6, super.getId());
           int teste = stmt.executeUpdate();
           if (teste > 0) {
               System.out.println("Usuário inserido com sucesso.");
           }else {
        	   System.out.println("erro");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Motorista> listarMotoristas() {
        String sql = "SELECT * FROM pessoa";
        List<Motorista> clientes = new ArrayList<>();

        try (Connection conn = conexaoBanco.getConexao(); 
             Statement stmt = conn.createStatement(); 
             ResultSet resultado = stmt.executeQuery(sql)) {

            while (resultado.next()) {
            	UUID id = UUID.fromString(resultado.getString("id"));
                String nome = resultado.getString("nome");
                String cidade = resultado.getString("cidade");
                String CPF = resultado.getString("cpf");
                Boolean status = resultado.getBoolean("status");
                Integer CNH = resultado.getInt("cnh");
                clientes.add(new Motorista(CNH, nome, cidade, CPF, id, status));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }
	
	@Override
    public String toString() {
        return "Motorista{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", cpf='" + getCPF() + '\'' +
                ", status='" + this.status + '\'' +
                ", CNH'" + this.CNH + '\'' +
                '}';
    }
}
