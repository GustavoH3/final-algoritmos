package finalAlgoritmo;

import java.util.Scanner;

public class Menus {
	
	//Scanner 
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void exibirMenuPrincipal(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Gerenciar Clientes");
		System.out.println("2 - Gerenciar Motorista");
		System.out.println("3 - Gerenciar Produtos");
		System.out.println("4 - Gerenciar Viagens");
		System.out.println("5 - Sair do Programa");
	}
	
	public static void exibirSubMenuClientes(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Listar Clientes");
		System.out.println("2 - Cadastrar Clientes");
		System.out.println("3 - Editar Clientes");
		System.out.println("4 - Remover Clientes");
		System.out.println("5 - Voltar");
	}
	
	public static void exibirSubMenuMotoristas(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Listar Motoristas");
		System.out.println("2 - Cadastrar Motoristas");
		System.out.println("3 - Editar Motoristas");
		System.out.println("4 - Remover Motoristas");
		System.out.println("5 - Voltar");
	}
	
	public static void exibirSubMenuProdutos(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Listar Produtos");
		System.out.println("2 - Cadastrar Produtos");
		System.out.println("3 - Editar Produtos");
		System.out.println("4 - Remover Produtos");
		System.out.println("5 - Voltar");
	}
	
	public static void exibirSubMenuViagens(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Iniciar Viagem");
		System.out.println("2 - Finalizar Viagem");
		System.out.println("3 - Voltar");
	}
	
	public static void exibirOpcoesClientes(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Buscar Cliente por ID");
		System.out.println("2 - Buscar Cliente por Nome");
		System.out.println("3 - Voltar");
	}
	
	public static void exibirOpcoesMotorista(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Buscar Motorista por ID");
		System.out.println("2 - Buscar Motorista por Nome");
		System.out.println("3 - Voltar");
	}
	
	public static void exibirOpcoesProduto(){
		System.out.println("------ Selecione uma das Opções Abaixo: ------");
		System.out.println("1 - Buscar Produto por ID");
		System.out.println("2 - Buscar produto por Nome");
		System.out.println("3 - Voltar");
	}
	
	public static int inputUsuarioNumero(){
		int numero;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine().trim());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
	}
	
	public static String inputUsuarioString() {
        String texto;
        while (true) {
            texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            } else {
                System.out.println("Entrada inválida. O texto não pode estar vazio.");
            }
        }
    }
	
	
	
	
}
