package finalAlgoritmo;

import java.util.UUID;

public class Cliente extends Pessoa {
	
	 public Cliente(String nome, String CPF, String cidade) {
	        super(nome, CPF, cidade); 
	 }
	 
	    @Override
	    public String toString() {
	        return "Cliente{" +
	                "ID='" + getId() +
	                ", Nome='" + getNome() +
	                ", CPF='" + getCPF() + 
	                ", Cidade='" + getCidade() +
	                '}';
	    }
	}