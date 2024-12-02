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
					
					 Motorista joão = new Motorista(123, "joao", "chapeco", "135.548.965-89");
					 Motorista motorista = null;
					 joão.listarMotoristas();
					 joão.atualizarMotoristaNome("joao", "Roger", "Acapuco", 456987456, "135-569-25-89");
					 joão.listarMotoristas();		 
					 for (Motorista motorista1 : joão.listarMotoristas()) {
				            System.out.println(motorista1);
				            motorista = new Motorista(1234, "cesar", "chate", "123;456");
				            motorista.setID(motorista1.getId());
				        }
				        
				        System.out.println("ID da pessoa: " + joão.getId());
				        
				       // Cliente maria = new Cliente(1234568789, "maria", "chapeco", "935.748.965-59");
				        
				       // System.out.println("ID da pessoa: " + maria.getId());
				        
				       // joão.atualizarMotoristaID(motorista.getId(), "Rogerio", "Xaxim", 12365489, "123.698.874-78");
				       // motorista.atualizarMotoristaNome("Rogerio", "Fernando", "Xanxere", 45874123, "123.456.789-12");
				        
				        Produto produto1 = new Produto("Câmera Fotográfica", 5);
				        Produto produto2 = new Produto("Carregador Solar", 3);
				        Produto produto3 = new Produto("Maleta de Viagem", 9);
			   
				        //Viagem viagem = new Viagem("descricao", "cidadeOrigem", "cidadeDestino", joão, maria);

				        /*viagem.adicionarProduto(produto1);
				        viagem.adicionarProduto(produto2);
				        viagem.adicionarProduto(produto3);

				        viagem.exibirProdutos();
				        viagem.getCliente();
				        viagem.getMotorista();*/
				        
				}
	}
}