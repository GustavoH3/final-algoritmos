package finalAlgoritmo;

import java.util.UUID;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
				//Variáveis para controle dos Menus
				Integer menuPrincipal = 0, subMenu = 0, opcaoSubMenu = 0;
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
											System.out.println("cadastrar Clientes");
											break;
										case 3:
											System.out.println("editar Clientes");
											break;
										case 4: 
											System.out.println("remover Clientes");
											break;
										case 5:
											System.out.println("está voltando pra o menu anterior");
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
											System.out.println("cadastrar Motoristas");
											break;
										case 3:
											System.out.println("editar Motoristas");
											break;
										case 4: 
											System.out.println("remover Motoristas");
											break;
										case 5:
											System.out.println("está voltando pra o menu anterior");
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
											System.out.println("Listar Motoristas");
											break;
										case 2:
											System.out.println("cadastrar Motoristas");
											break;
										case 3:
											System.out.println("editar Motoristas");
											break;
										case 4: 
											System.out.println("remover Motoristas");
											break;
										case 5:
											System.out.println("está voltando pra o menu anterior");
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