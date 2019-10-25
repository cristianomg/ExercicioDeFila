package Models;

import java.util.ArrayList;

public class Pedido {
	private static int incremento;
	private int id;
	private Cliente cliente;
	private ArrayList<Produto> listaProdutos;
	private boolean statusDespachado;
	
	
	public Pedido(Cliente cliente, ArrayList<Produto> listaProdutos, boolean statusDespachado) {
		super();
		this.id = incremento;
		this.cliente = cliente;
		this.listaProdutos = listaProdutos;
		this.statusDespachado = statusDespachado;
		Pedido.incremento++;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public boolean isStatusDespachado() {
		return statusDespachado;
	}
	public void setStatusDespachado(boolean statusDespachado) {
		this.statusDespachado = statusDespachado;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, Cliente: %s,   Status: #b ", this.id, this.cliente, this.statusDespachado);
	}

	
}
