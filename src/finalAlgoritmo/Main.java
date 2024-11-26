package finalAlgoritmo;

import java.util.UUID;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		 Motorista joão = new Motorista(123, "joao", "chapeco", "135.548.965-89");
		 Motorista motorista = null;
		 
		 for (Motorista motorista1 : joão.listarMotoristas()) {
	            System.out.println(motorista1);
	            motorista = new Motorista(1234, "cesar", "chate", "123;456");
	            motorista.setID(motorista1.getId());
	        }
	        
		 System.out.println(motorista.getId().toString());
	        System.out.println("ID da pessoa: " + joão.getId());
	        
	        Cliente maria = new Cliente(1234568789, "maria", "chapeco", "935.748.965-59");
	        
	        System.out.println("ID da pessoa: " + maria.getId());
	        
	        joão.atualizarMotoristaID(motorista.getId(), "Rogerio", "Xaxim", 12365489, "123.698.874-78");
	        motorista.atualizarMotoristaNome("Rogerio", "Fernando", "Xanxere", 45874123, "123.456.789-12");
	        
	        Produto produto1 = new Produto("Câmera Fotográfica", 5);
	        Produto produto2 = new Produto("Carregador Solar", 3);
	        Produto produto3 = new Produto("Maleta de Viagem", 9);
   
	        Viagem viagem = new Viagem("descricao", "cidadeOrigem", "cidadeDestino", joão, maria);

	        viagem.adicionarProduto(produto1);
	        viagem.adicionarProduto(produto2);
	        viagem.adicionarProduto(produto3);

	        viagem.exibirProdutos();
	        viagem.getCliente();
	        viagem.getMotorista();
	        joão.DeletarMotorista(motorista.getId());
	}
}