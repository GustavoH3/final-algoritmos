package finalAlgoritmo;

import java.util.UUID;

public abstract class Pessoa {
	private String nome;
	private String CPF;
	private UUID id;
	private String cidade;
	
	public Pessoa(String nome, String CPF, String cidade) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.CPF = CPF;
		this.cidade = cidade;
	}
	
	public UUID getID(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
}

