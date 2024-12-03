package finalAlgoritmo;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

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
											System.out.println("Listando Clientes...");
											Cliente clienteAux = new Cliente("varAuxMenu");
											List<Cliente> clientesListarMenu = clienteAux.listarClientes();
											System.out.println("Imprimindo Clientes");
											for (Cliente clientesExibir : clientesListarMenu) {
												System.out.println(clientesExibir.toString());
											}
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
											System.out.println("Editar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Atualizar por UUID
													System.out.print("Digite o ID do Cliente:");
													UUID clienteIdAntigo_1 = UUID.fromString(Menus.inputUsuarioString());
													System.out.print("Digite o novo Nome do Cliente:");
													String clienteNovoNome_1 = Menus.inputUsuarioString();
													System.out.print("Digite a nova Cidade do Cliente:");
													String clienteNovaCidade_1 = Menus.inputUsuarioString();
													System.out.print("Digite o novo CPF do Cliente:");
													String clienteNovoCPF_1 = Menus.inputUsuarioString();
													Boolean deletouObjeto_1 = Cliente.atualizarClienteID(clienteIdAntigo_1, clienteNovoNome_1, clienteNovaCidade_1, clienteNovoCPF_1);
													if(deletouObjeto_1 == true){
														System.out.println("Cliente Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Cliente");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Cliente:");
													String clienteNomeAntigo_2 = Menus.inputUsuarioString();
													System.out.print("Digite o novo Nome do Cliente:");
													String clienteNovoNome_2 = Menus.inputUsuarioString();
													System.out.print("Digite a nova Cidade do Cliente:");
													String clienteNovaCidade_2 = Menus.inputUsuarioString();
													System.out.print("Digite o novo CPF do Cliente:");
													String clienteNovoCPF_2 = Menus.inputUsuarioString();
													Boolean deletouObjeto_2 = Cliente.atualizarClienteNome(clienteNomeAntigo_2, clienteNovoNome_2, clienteNovaCidade_2, clienteNovoCPF_2);
													if(deletouObjeto_2 == true){
														System.out.println("Cliente Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Cliente");
													}
													break;
											}
											
											break;
										case 4: 
											System.out.println("Remover Cliente");
											System.out.println("Deletar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Deletar por UUID
													System.out.print("Digite o ID do Cliente:");
													Cliente clienteMenu_1 = new Cliente("varAux");
													Boolean deletouObjeto_1 = clienteMenu_1.DeletarClienteID(UUID.fromString(Menus.inputUsuarioString()));
													if(deletouObjeto_1 == true){
														System.out.println("Cliente Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Cliente");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Cliente:");
													Cliente clienteMenu_2 = new Cliente("varAux");
													Boolean deletouObjeto_2 = clienteMenu_2.DeletarClienteNome(Menus.inputUsuarioString());
													if(deletouObjeto_2 == true){
														System.out.println("Cliente Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Cliente");
													}
													break;
											}
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
											System.out.println("Listando Motoristas...");
											Motorista motoristaAux = new Motorista("varAuxMenu");
											List<Motorista> motoristasListarMenu = motoristaAux.listarMotoristas();
											System.out.println("Imprimindo Motoristas");
											for (Motorista motoristasExibir : motoristasListarMenu) {
												System.out.println(motoristasExibir.toString());
											}
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
											System.out.println("Editar Motoristas");
											System.out.println("Editar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Atualizar por UUID
													System.out.print("Digite o ID do Motorista:");
													UUID motoristaIdAntigo_1 = UUID.fromString(Menus.inputUsuarioString());
													System.out.print("Digite o novo Nome do Motorista:");
													String motoristaNovoNome_1 = Menus.inputUsuarioString();
													System.out.print("Digite a nova Cidade do Motorista:");
													String motoristaNovaCidade_1 = Menus.inputUsuarioString();
													System.out.print("Digite a nova CNH do Motorista:");
													Integer motoristaNovaCNH_1 = Menus.inputUsuarioNumero();
													System.out.print("Digite o novo CPF do Motorista:");
													String motoristaNovoCPF_1 = Menus.inputUsuarioString();
													Boolean deletouObjeto_1 = Motorista.atualizarMotoristaID(motoristaIdAntigo_1, motoristaNovoNome_1, motoristaNovaCidade_1, motoristaNovaCNH_1, motoristaNovoCPF_1);
													if(deletouObjeto_1 == true){
														System.out.println("Cliente Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Cliente");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Motorista:");
													String motoristaNomeAntigo_2 = Menus.inputUsuarioString();
													System.out.print("Digite o novo Nome do Motorista:");
													String motoristaNovoNome_2 = Menus.inputUsuarioString();
													System.out.print("Digite a nova Cidade do Motorista:");
													String motoristaNovaCidade_2 = Menus.inputUsuarioString();
													System.out.print("Digite a nova CNH do Motorista:");
													Integer motoristaNovaCNH_2 = Menus.inputUsuarioNumero();
													System.out.print("Digite o novo CPF do Motorista:");
													String motoristaNovoCPF_2 = Menus.inputUsuarioString();
													Boolean deletouObjeto_2 = Motorista.atualizarMotoristaNome(motoristaNomeAntigo_2, motoristaNovoNome_2, motoristaNovaCidade_2, motoristaNovaCNH_2, motoristaNovoCPF_2);
													if(deletouObjeto_2 == true){
														System.out.println("Cliente Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Cliente");
													}
													break;
											}
											
											break;
										case 4: 
											System.out.println("Remover Motorista");
											System.out.println("Deletar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Deletar por UUID
													System.out.print("Digite o ID do Motorista:");
													Motorista motoristaMenu_1 = new Motorista("varAux");
													Boolean deletouObjeto_1 = motoristaMenu_1.DeletarMotoristaID(UUID.fromString(Menus.inputUsuarioString()));
													if(deletouObjeto_1 == true){
														System.out.println("Motorista Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Motorista");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Motorista:");
													Motorista motoristaMenu_2 = new Motorista("varAux");
													Boolean deletouObjeto_2 = motoristaMenu_2.DeletarMotoristaNome(Menus.inputUsuarioString());
													if(deletouObjeto_2 == true){
														System.out.println("Motorista Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Motorista");
													}
													break;
											}
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
											System.out.println("Listando Produtos...");
											List<Produto> produtosListarMenu = Produto.listarProdutos();
											System.out.println("Imprimindo Motoristas");
											for (Produto produtosExibir : produtosListarMenu) {
												System.out.println(produtosExibir.toString());
											}
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
											System.out.println("Editar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Atualizar por UUID
													System.out.print("Digite o ID do Produto:");
													UUID produtoIdAntigo_1 = UUID.fromString(Menus.inputUsuarioString());
													System.out.print("Digite o novo Nome do Produto:");
													String produtoNovoNome_1 = Menus.inputUsuarioString();
													System.out.print("Digite a nova quantidade do Produto:");
													Integer produtoNovaQTD_1 = Menus.inputUsuarioNumero();
													Boolean deletouObjeto_1 = Produto.atualizarProdutoID(produtoIdAntigo_1, produtoNovoNome_1, produtoNovaQTD_1);
													if(deletouObjeto_1 == true){
														System.out.println("Produto Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Produto");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Produto:");
													String produtoNomeAntigo_2 = Menus.inputUsuarioString();
													System.out.print("Digite o novo Nome do Produto:");
													String produtoNovoNome_2 = Menus.inputUsuarioString();
													System.out.print("Digite a nova Quantidade do Produto:");
													Integer produtoNovaQTD_2 = Menus.inputUsuarioNumero();
													Boolean deletouObjeto_2 = Produto.atualizarProdutoNome(produtoNomeAntigo_2, produtoNovoNome_2, produtoNovaQTD_2);
													if(deletouObjeto_2 == true){
														System.out.println("Cliente Alterado Com sucesso!");
													}else {
														System.out.println("Erro ao Atualizar o Cliente");
													}
													break;
											}
											
											break;
										case 4: 
											System.out.println("Remover Produto");
											System.out.println("Deletar por: \n1 - ID \n2 - Nome");
											opcaoSubMenu = Menus.inputUsuarioNumero();
											switch(opcaoSubMenu){
												case 1:
													//Deletar por UUID
													System.out.print("Digite o ID do Produto:");
													Produto produtoMenu_1 = new Produto("varAux", 1234);
													Boolean deletouObjeto_1 = produtoMenu_1.deletarProduto(UUID.fromString(Menus.inputUsuarioString()));
													if(deletouObjeto_1 == true){
														System.out.println("Produto Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Produto");
													}
													break;
												case 2:
													System.out.print("Digite o Nome do Produto:");
													Produto produtoMenu_2 = new Produto("varAux", 1234);
													Boolean deletouObjeto_2 = produtoMenu_2.deletarProdutoNome(Menus.inputUsuarioString());
													if(deletouObjeto_2 == true){
														System.out.println("Produto Deletado Com sucesso!");
													}else {
														System.out.println("Erro ao Deletar o Produto");
													}
													break;
											}
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
