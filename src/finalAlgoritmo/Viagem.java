package finalAlgoritmo;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Viagem {
	private UUID id;
	private String descricao;
	private String cidadeOrigem;
	private String cidadeDestino;
	private List<Produto> listaProdutos;
	private String motorista;
	private String cliente;
	private String status;
	
	public Viagem(String descricao, String cidadeOrigem, String cidadeDestino, Motorista motorista, Cliente cliente) {
		this.id = UUID.randomUUID();
		this.descricao = descricao;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.listaProdutos = new ArrayList<>();
		this.motorista = motorista.getNome();
		this.cliente = cliente.getNome();
		this.status = "Iniciada";
		motorista.iniciarViagem();
	}
	
	public void adicionarProduto(Produto produto) {
        if (produto != null) {
            listaProdutos.add(produto);
        }
    }
	
	public void exibirProdutos() {
        for (Produto produto : listaProdutos) {
            System.out.println(produto.getNome());
        }
	}
	
	public void getMotorista() {
		System.out.println(this.motorista);
	}
	
	public void getCliente() {
		System.out.println(this.cliente);
	}
	
	public void finalizarViagem(Motorista motorista) {
		this.status = "Finalizada";
		motorista.finalizarViagem();
		
	}
	public String getStatus() {
		return this.status;
	}
	
}
