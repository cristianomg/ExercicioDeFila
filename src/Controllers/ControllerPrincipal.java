package Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Database.ClienteDB;
import Database.ProdutosDB;
import FilaComListaDuplamenteEncadeada.FilaComLista;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;
import Models.Cliente;
import Models.Pedido;
import Models.Produto;
import Views.View;

public class ControllerPrincipal {
	View view = View.getInstance();
	private ClienteDB listaClientes = ClienteDB.getInstance();
	private ProdutosDB listaProdutos = ProdutosDB.getInstance();
	private FilaComLista<Pedido> listaPedidos = new FilaComLista<Pedido>();
	Scanner sc;

	public void Menu() {
		sc = new Scanner(System.in);
		int menu = 0;
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Produto");
		System.out.println("3 - Efetuar Pedido");
		System.out.println("4 - Despachar Pedido");
		System.out.println("5 - Exibir Fila de Pedidos");
		do {
			System.out.print("Infome a opção: ");
			try {
				menu = sc.nextInt();				
			}catch (InputMismatchException e) {
				System.out.println("Opção invalida, tente novamente");
				sc.next();
			}
		}while (menu< 1 && menu > 5);
		Object pedidos;
		switch(menu) {
		case 1:
			Cliente cliente = view.cadastrarCliente();
			boolean response = this.cadastrarCliente(cliente);
			if (response) {
				System.out.println("Cadastro realizado com sucesso!!");
			}
			else {
				System.out.println("Erro: Cadastro não realizado!!");
			}
			break;
		case 2:
			Produto produto = view.cadastrarProduto();
			boolean response1 = this.cadastrarProduto(produto);
			if (response1) {
				System.out.println("Cadastro realizado com sucesso!!");
			}
			else {
				System.out.println("Erro: Cadastro não realizado!!");
			}
			break;
		case 3:
			Pedido pedido = view.efetuarPedido();
			boolean response3 = this.efetuarPedido(pedido);
			if (response3) {
				System.out.println("Pedido realizado com sucesso!!");
			}
			else {
				System.out.println("Erro: Pedido não realizado!!");
			}
			break;
		case 4:
			Pedido pedidoDespachado = this.listaPedidos.desenfileirar();
			pedidoDespachado.setStatusDespachado(true);
			System.out.println("Pedido despachado");
			System.out.println("ID do Pedido: " + pedidoDespachado.getId());
			System.out.println("Nome do Cliente: " + pedidoDespachado.getCliente().getNome());
			System.out.printf("%-4s%-1s%-10s%-1s%s", "Id"," ", "Nome", " ","Valor");
			for (Produto p : pedidoDespachado.getListaProdutos()) {
				System.out.printf("%-4s%-1s%-10s%-1s%s", p.getId() , " ", p.getNome(), " ",p.getValor());
			}
			break;
		case 5:
			ListaDuplamenteEncadeada<Pedido> pedidosAdiconados = this.listaPedidos.getElementos();
			for (Pedido p : pedidosAdiconados) {
				System.out.println("Id: " + p.getId());
				System.out.println("Nome do cliente: " + p.getCliente().getNome());
				System.out.printf("%-4s%-1s%-10s%-1s%-5s", "Id"," ", "Nome", " " ,"Valor");
				System.out.println();
				for (Produto produto1 : p.getListaProdutos()) {
					System.out.printf("%-4s%-1s%-10s%-1s%-5s", produto1.getId(), " ",produto1.getNome(), " ",produto1.getValor());
					System.out.println();
				}
			}
			break;
		default: 
			System.out.println("opção invalida");
	}
		this.Menu();
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		if (cliente != null) {
			System.out.println("Id do cliente: " + cliente.getId());
			return listaClientes.inserir(cliente);			
		}
		return false;
	}
	
	public boolean cadastrarProduto(Produto produto) {
		if (produto != null) {
			return listaProdutos.inserir(produto);			
		}
		return false;
	}
	
	public boolean efetuarPedido(Pedido pedido) {
		if (pedido != null) {
			return listaPedidos.enfileirar(pedido);
		}
		return false;
		
	}
}
