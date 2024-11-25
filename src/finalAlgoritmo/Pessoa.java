package finalAlgoritmo;

import java.util.UUID;

public class Pessoa {
	private String nome;
	private String CPF;
	private UUID id;
	
	public Pessoa() {
		this.id = UUID.randomUUID();
	}
	
	 public void setId(UUID id) {
	        this.id = id;
	    }
	
	public UUID getId() {
	    return id;
	}
}

