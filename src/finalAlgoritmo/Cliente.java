package finalAlgoritmo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente extends Pessoa {
	
	 public Cliente(String nome) { 
		 	super(nome, null, null); 
	 }
	
	 public Cliente(String nome, String CPF, String cidade) {
	        super(nome, CPF, cidade); 
	 }
	 
	 public Cliente(String nome, String CPF, String cidade, UUID id) {
	        super(nome, CPF, cidade); 
	        setID(id);
	 }
	 
	 public void salvarCliente() {
	        String sql = "INSERT INTO cliente(nome, cidade, cpf, id) VALUES (?, ?, ?, ?)";

	        try (Connection conn = conexaoBanco.getConexao();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, super.getNome());
	            stmt.setString(2, super.getCidade());
	            stmt.setString(3, super.getCPF());
	            stmt.setObject(4, super.getId());
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
		
		public List<Cliente> listarClientes() {
	        String sql = "SELECT * FROM pessoa";
	        List<Cliente> clientes = new ArrayList<>();

	        try (Connection conn = conexaoBanco.getConexao(); 
	             Statement stmt = conn.createStatement(); 
	             ResultSet resultado = stmt.executeQuery(sql)) {

	            while (resultado.next()) {
	            	UUID id = UUID.fromString(resultado.getString("id"));
	                String nome = resultado.getString("nome");
	                String cidade = resultado.getString("cidade");
	                String CPF = resultado.getString("cpf");
	                clientes.add(new Cliente(nome, CPF, cidade, id));
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao listar clientes: " + e.getMessage());
	        }
	        return clientes;
	    }
		
		public boolean atualizarClienteNome(String nome, String novoNome, String novaCidade, String novoCPF) {
	        String sql = "UPDATE cliente SET nome = ?, cidade = ?, cpf = ? WHERE nome = ?";
	        boolean atualizado = false; 

	        try (Connection conn = conexaoBanco.getConexao(); 
	             PreparedStatement stmt = conn.prepareStatement(sql)) { 

	            stmt.setString(1, novoNome);  
	            stmt.setString(2, novaCidade);
	            stmt.setString(3, novoCPF);
	            stmt.setString(4, nome); 

	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                atualizado = true; 
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
	        }

	        return atualizado;
	    }
		
		public boolean atualizarClienteID(UUID id, String novoNome, String novaCidade, String novoCPF) {
	        String sql = "UPDATE cliente SET nome = ?, cidade = ?, cpf = ? WHERE id = ?";  
	        boolean atualizado = false; 

	        try (Connection conn = conexaoBanco.getConexao(); 
	             PreparedStatement stmt = conn.prepareStatement(sql)) { 

	            stmt.setString(1, novoNome);  
	            stmt.setString(2, novaCidade);
	            stmt.setString(3, novoCPF);
	            stmt.setObject(4, id); 

	            int linhasAfetadas = stmt.executeUpdate();

	            if (linhasAfetadas > 0) {
	                atualizado = true; 
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
	        }

	        return atualizado;
	    }
		
		public boolean DeletarClienteID(UUID id) {
			String sql = "DELETE FROM cliente WHERE id = ?";
			PreparedStatement stmt = null;
			Connection conn = null;
			boolean isDeleted = false;

			try {conn = conexaoBanco.getConexao();

			    stmt = conn.prepareStatement(sql);
	            stmt.setObject(1, id);  

	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0) {
	                isDeleted = true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isDeleted;
	    }
		
		public boolean DeletarClienteNome(String nome) {
			String sql = "DELETE FROM cliente WHERE id = ?";
			PreparedStatement stmt = null;
			Connection conn = null;
			boolean isDeleted = false;

			try {conn = conexaoBanco.getConexao();

			    stmt = conn.prepareStatement(sql);
	            stmt.setString(1, nome);  

	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0) {
	                isDeleted = true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isDeleted;
	    }
	 
	    @Override
	    public String toString() {
	        return "Cliente {" +
	                "ID= " + getId() +
	                ", Nome= " + getNome() +
	                ", CPF= " + getCPF() + 
	                ", Cidade= " + getCidade() +
	                '}';
	    }
	}