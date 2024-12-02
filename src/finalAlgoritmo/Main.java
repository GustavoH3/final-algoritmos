package finalAlgoritmo;

import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		Motorista fernando = new Motorista(123654789, "Chapeco", "Fernando", "123-123-123-12");
		Cliente luiz = new Cliente("Luiz", "321-321-321-32", "Xaxim");
		 Produto bicicleta = new Produto("bike", 1);
		 
		 Viagem viagem = new Viagem("Batata e banana", "Chapeco", "Xaxim", fernando, luiz);
		 
		 viagem.adicionarProduto(bicicleta);
		 
		 viagem.salvar();
		 
		 
		 for(Produto bike : bicicleta.listarProdutos()) {
			 System.out.println(bike);
		 }
		 
		 bicicleta.deletarProdutoPorNome("Bicicleta");
		 
		 for(Produto bike : bicicleta.listarProdutos()) {
			 System.out.println(bike);
		 }
		 
		// bicicleta.listarProdutos();
		// System.out.println(bicicleta);
		 
	}
}