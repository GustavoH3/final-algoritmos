package finalAlgoritmo;

public class Main {

	public static void main(String[] args) {
		 Motorista joão = new Motorista(123, "joao", "chapeco", "135.548.965-89");
		 joão.salvar();
	        
	        System.out.println("ID da pessoa: " + joão.getId());
	        
	        Cliente maria = new Cliente(1234568789, "maria", "chapeco", "935.748.965-59");
	        
	        System.out.println("ID da pessoa: " + maria.getId());
	        
	        Produto produto1 = new Produto("Câmera Fotográfica", 5);
	        Produto produto2 = new Produto("Carregador Solar", 3);
	        Produto produto3 = new Produto("Maleta de Viagem", 9);

	        // Criando uma viagem
	        Viagem viagem = new Viagem("descricao", "cidadeOrigem", "cidadeDestino", joão, maria);

	        // Adicionando os produtos (objetos completos) à viagem
	        viagem.adicionarProduto(produto1);
	        viagem.adicionarProduto(produto2);
	        viagem.adicionarProduto(produto3);

	        // Exibindo apenas os nomes dos produtos na viagem
	        viagem.exibirProdutos();
	        viagem.getCliente();
	        viagem.getMotorista();
	}
}