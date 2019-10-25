package FilaComVetor;

import IntefacesEstruturas.Fila;
import Vetor.Vetor;

public class FilaComVetor<T> implements Fila<T> {

	private Vetor<T> elementos;
	private int tamanhoMaximo;
	private int inicio = 0;
	private int fim = 0;
	private int elementosEnfilerados = 0;

	public FilaComVetor() {
		this.tamanhoMaximo = (int) Float.POSITIVE_INFINITY;
		this.elementos = new Vetor<T>();
	}

	public FilaComVetor(int tamanho) {
		this();
		this.tamanhoMaximo = tamanho;
	}

	@Override
	public boolean enfileirar(T valor) {
		if(elementosEnfilerados < tamanhoMaximo) {
			elementos.adicionar(valor);
			fim++;			
		}
		return true;
	}

	@Override
	public T desenfileirar() {
		T info = elementos.remover(inicio);
		if (info != null) {
			this.elementosEnfilerados--;			
		}
		if (inicio == tamanhoMaximo) {
			inicio = 0;
		} else {
			inicio++;
		}
		return info;
	}

	@Override
	public int tamanho() {
		return this.elementosEnfilerados;
	}

	@Override
	public boolean vazia() {
		return elementosEnfilerados == 0;
	}

	@Override
	public T primeiro() {
		return elementos.buscar(inicio);
	}

	@Override
	public T ultimo() {
		return elementos.buscar(fim-1);
	}

	@Override
	public void exibirFila() {
		// TODO Auto-generated method stub
		
	}

}
