package Models;

import Lista.classes.Lista;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class Cliente {
	private static int incremento;
	private int id;
	private String nome;
	private String cpf;
	private String dataNasc;
	private String telefone;
	private String email;
	private Lista<Pedido> listaPedidos = new ListaDuplamenteEncadeada<Pedido>();
	
	
	
	public Cliente(String nome, String cpf, String dataNasc, String telefone, String email) {
		super();
		this.id = incremento;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		Cliente.incremento++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getListaPedidos() {
		String pedidos = "";
		for (Pedido pedido : this.listaPedidos) {
			String str = pedido.getId() + "\n";
			pedidos.concat(str);
		}
		return pedidos;
		
	}
	public void addPedidos(Pedido pedido) {
		this.listaPedidos.adicionar(pedido);;
	}
	public int getId() {
		return id;
	} 
	
	
}
