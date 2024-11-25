package finalAlgoritmo;

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
}
