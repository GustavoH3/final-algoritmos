package finalAlgoritmo;

import java.util.UUID;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
				//Variáveis para controle dos Menus
				Integer menuPrincipal = 0, subMenu = 0, opcaoSubMenu = 0;
				Boolean sairOperacao = false;
				
				//Ativação do modo Debug
				Boolean iniciarDebug = false;
				
				if(iniciarDebug == false){
					do{
						Menus.exibirMenuPrincipal();
						menuPrincipal = Menus.inputUsuarioNumero();
						
						switch(menuPrincipal) {
							case 1:
								//Abre o Menu para gerenciar os clientes
								do{
									Menus.exibirSubMenuClientes();
									subMenu = Menus.inputUsuarioNumero();
									//Seleção das opções do SubMenu
									switch(subMenu){
										case 1:
											System.out.println("Listar Clientes");
											break;
										case 2:
											System.out.println("\nCadastrar Clientes");
											do{
												sairOperacao = false;
												System.out.print("Insira o Nome do Cliente:");
												String nomeCliente = Menus.inputUsuarioString();
												System.out.print("Insira o CPF do Cliente:");
												String cpfCliente = Menus.inputUsuarioString();
												System.out.print("Insira a Cidade do Cliente:");
												String cidadeCliente = Menus.inputUsuarioString();
												Cliente clienteMenu = new Cliente(nomeCliente, cpfCliente, cidadeCliente);
												System.out.println("\nDados do Cliente:");
												System.out.println(clienteMenu.toString());
												System.out.println("\nDeseja salvar esse Cliente?");
												System.out.println("1 - Salvar \n2 - Não Salvar");
												if(Menus.inputUsuarioNumero() == 1){
													System.out.println("Cliente Salvo no Banco de Dados");
													//clienteMenu.salvarCliente();
													sairOperacao = true;
												}else{
													System.out.println("Cliente descartado");
													sairOperacao = true;
												}
											}while(sairOperacao == false);
											break;
										case 3:
											System.out.println("Editar Clientes");
											
											break;
										case 4: 
											System.out.println("remover Clientes");
											
											break;
										case 5:
											System.out.println("Você está voltando pra o menu anterior");
											break;		
									}
								}while(subMenu != 5);
								subMenu = 0;
								break;
								
								
							case 2:
								//Abre o Menu para gerenciar os Motoristas
								do{
									Menus.exibirSubMenuMotoristas();
									subMenu = Menus.inputUsuarioNumero();
									//Seleção das opções do SubMenu
									switch(subMenu){
										case 1:
											System.out.println("Listar Motoristas");
											break;
										case 2:
											System.out.println("Cadastrar Motoristas");
											do{
												sairOperacao = false;
												System.out.print("Insira a CNH do Motorista:");
												Integer cnhMotorista = Menus.inputUsuarioNumero();
												System.out.print("Insira o Nome do Motorista:");
												String nomeMotorista = Menus.inputUsuarioString();
												System.out.print("Insira o CPF do Motorista:");
												String cpfMotorista = Menus.inputUsuarioString();
												System.out.print("Insira a Cidade do Motorista:");
												String cidadeMotorista = Menus.inputUsuarioString();
												Motorista motoristaMenu = new Motorista(cnhMotorista, nomeMotorista, cidadeMotorista, cpfMotorista);
												System.out.println("\nDados do Motorista:");
												System.out.println(motoristaMenu.toString());
												System.out.println("\nDeseja salvar esse Motorista?");
												System.out.println("1 - Salvar \n2 - Não Salvar");
												if(Menus.inputUsuarioNumero() == 1){
													System.out.println("Motorista Salvo no Banco de Dados");
													//motoristaMenu.salvar();
													sairOperacao = true;
												}else{
													System.out.println("Motorista descartado");
													sairOperacao = true;
												}
											}while(sairOperacao == false);
											break;
										case 3:
											System.out.println("editar Motoristas");
											break;
										case 4: 
											System.out.println("remover Motoristas");
											break;
										case 5:
											System.out.println("Você está voltando pra o menu anterior");
											break;		
									}
								}while(subMenu != 5);
								subMenu = 0;
								break;
								
								
							case 3:
								//Abre o Menu para gerenciar os Produtos
								do{
									Menus.exibirSubMenuProdutos();
									subMenu = Menus.inputUsuarioNumero();
									//Seleção das opções do SubMenu
									switch(subMenu){
										case 1:
											System.out.println("Listar Produtos");
											break;
										case 2:
											System.out.println("Cadastrar Produtos");
											do{
												sairOperacao = false;
												System.out.print("Insira o Nome do Produto:");
												String nomeProduto = Menus.inputUsuarioString();
												System.out.print("Insira a quantidade do Produto:");
												Integer qtdProduto = Menus.inputUsuarioNumero();
												Produto produtoMenu = new Produto(nomeProduto, qtdProduto);
												System.out.println("\nDados do Produto:");
												System.out.println(produtoMenu.toString());
												System.out.println("\nDeseja salvar esse Produto?");
												System.out.println("1 - Salvar \n2 - Não Salvar");
												if(Menus.inputUsuarioNumero() == 1){
													System.out.println("Produto Salvo no Banco de Dados");
													//produtoMenu.salvar();
													sairOperacao = true;
												}else{
													System.out.println("Produto descartado");
													sairOperacao = true;
												}
											}while(sairOperacao == false);
											break;
										case 3:
											System.out.println("Editar Produtos");
											break;
										case 4: 
											System.out.println("Remover Produtos");
											break;
										case 5:
											System.out.println("Você está voltando pra o menu anterior");
											break;		
									}
								}while(subMenu != 5);
								subMenu = 0;
								

							case 4:
								//Abre o Menu para gerenciar as Viagens
								Menus.exibirSubMenuViagens();
								break;
							case 5:
								//Sai do Programa
								break;
							default:
								//Mensagem de erro
								System.out.println("Opção Inválida");
						}
					}while(menuPrincipal != 5);
				}else{
					
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
}
