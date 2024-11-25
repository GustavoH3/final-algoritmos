package finalAlgoritmo;

import java.util.UUID;

public class Cliente extends Pessoa {
	
	public Cliente(Integer CNH, String nome, String cidade, String CPF) {
		super(nome, CPF, cidade);
	}
	
	public UUID getId(){
		return super.getId();
	}
}
