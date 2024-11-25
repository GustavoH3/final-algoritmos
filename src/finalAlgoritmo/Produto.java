package finalAlgoritmo;

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
	
	public String getNome(){
		return this.nome;
	}
}
