package FilaComListaDuplamenteEncadeada;

import IntefacesEstruturas.Fila;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class FilaComLista<T> implements Fila<T> {

	private int tamanhoMaximo;
	private ListaDuplamenteEncadeada<T> elementos;

	public FilaComLista() {
		this.elementos = new ListaDuplamenteEncadeada<T>();
		this.tamanhoMaximo = (int) Float.POSITIVE_INFINITY;
	}

	public FilaComLista(int tamanhoMaximo) {
		this();
		this.tamanhoMaximo = tamanhoMaximo;
	}

	@Override
	public boolean enfileirar(T valor) {
		if (elementos.tamanho() < tamanhoMaximo) {
			elementos.adicionar(valor);
			return true;
		}else {
			return false;			
		}
	}

	@Override
	public T desenfileirar() {
		T item = elementos.removerNoInicio();
		return item;
	}

	@Override
	public int tamanho() {
		return elementos.tamanho();
	}

	@Override
	public boolean vazia() {
		return elementos.tamanho() == 0;
	}

	@Override
	public T primeiro() {
		return elementos.buscar(0);
	}

	@Override
	public T ultimo() {
		int ultimo = elementos.tamanho()-1;
		return  elementos.buscar(ultimo);
	}

	public ListaDuplamenteEncadeada<T> getElementos() {
		return elementos;
	}

}
