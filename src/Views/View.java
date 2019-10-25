package Views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Database.ClienteDB;
import Database.ProdutosDB;
import Models.Cliente;
import Models.Pedido;
import Models.Produto;

public class View {
	private static View uniqueInstance;
	private ClienteDB listaClientes = ClienteDB.getInstance();
	private ProdutosDB listaProdutos = ProdutosDB.getInstance();
	private Scanner sc;
	private View(){
	}
	
	public static synchronized View getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new View();
		}
		return uniqueInstance;
	}

	
	public Cliente cadastrarCliente() {
		sc = new Scanner(System.in);
		System.out.print("Informe o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.print("Informe o cpf do cliente: ");
		String cpf = sc.nextLine();
		System.out.print("Informe a data de nascimento do cliente: ");
		String dataNasc = sc.nextLine();
		System.out.print("Informe o telefone do cliente: ");
		String telefone = sc.nextLine();

		System.out.print("Informe o email do cliente: ");
		String email = sc.nextLine();
		if (!(nome.isEmpty()) && !(cpf.isEmpty()) && !(dataNasc.isEmpty()) && !(telefone.isEmpty())){
			return new Cliente(nome, cpf, dataNasc, telefone, email);
		}
		return null;
	}
	
	public Produto cadastrarProduto() {
		sc = new Scanner(System.in);
		try {
			System.out.print("Informe o nome do Produto: ");
			String nome = sc.nextLine();
			System.out.print("Informe o valor do Produto: ");
			Integer valor  = sc.nextInt();
			System.out.print("Informe a quantidade no estoque : ");
			Integer qtdEstoque = sc.nextInt();
			if (!(nome.isEmpty())){
				return new Produto(nome, valor, qtdEstoque);
			}
		}
		catch (Exception e) {
			System.out.println("Informações invalidas!!");
			sc.next();
		}
		return null;
	}
	public Pedido efetuarPedido() {
		sc = new Scanner(System.in);
		ArrayList<Produto> produtosEscolhidos = new ArrayList<Produto>();
		Cliente cliente = null;
		int opcao = 0;
		boolean encontrado = false;
		do {
			try {
				System.out.println("Informe o id do cliente");
				int idCliente = sc.nextInt();
				cliente = listaClientes.getById(idCliente);
				if (cliente != null) {
					encontrado = true;
				}
			}catch (InputMismatchException e) {
				System.out.println("Id invalido.");
				sc.next();
			}
		}while ((!encontrado));
		this.exibirProdutos();
		do {
			try {
				System.out.println("Escolha um produto [digite -1 para finalizar]:");
				opcao = sc.nextInt();
				if (opcao != -1) {
					Produto produto = listaProdutos.getById(opcao);
					if (produto != null) {
						produtosEscolhidos.add(produto);
					}					
				}
			}catch(InputMismatchException e){
				System.out.println("Opção invalida.");
				sc.next();
			}
			
		}while (opcao != -1);
		return new Pedido(cliente, produtosEscolhidos, false);
	}
	private void exibirProdutos() {
		System.out.printf("%-4s%-1s%-10s%-1s%-5s%-1s%s", "Id"," ", "Nome", " " ,"Valor", " " ,"Qtd Estoque" );
		System.out.println();
		for (Produto p : this.listaProdutos.getLista()) {
			System.out.printf("%-4s%-1s%-10s%-1s%-5s%-1s%s", p.getId(), " ",p.getNome(), " ",p.getValor(), " ",p.getQtdEstoque());
			System.out.println();
		}
	}
}
