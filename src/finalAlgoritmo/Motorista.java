package finalAlgoritmo;

import java.util.UUID;

public class Motorista extends Pessoa {
	private Integer CNH;
	private Boolean status;
	
	public Motorista(Integer CNH, String nome, String cidade, String CPF) {
		super(nome, CPF, cidade);
		this.CNH = CNH;
		this.status = false;
	}
	
	public UUID getId(){
		return super.getID();
	}
	
	public void iniciarViagem() {
		this.status = true;
	}
	
	public void finalizarViagem() {
		this.status = false;
	}
}
