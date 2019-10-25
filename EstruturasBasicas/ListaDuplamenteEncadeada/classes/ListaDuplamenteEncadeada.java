/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada.classes;

import java.util.Iterator;

import Lista.classes.Lista;


/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class ListaDuplamenteEncadeada<T> implements Lista<T>{
    private int tamanho;
    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;
    private final NoDuplo<T> inicioCabeca = new NoDuplo<T>();
    private final NoDuplo<T> fimCabeca = new NoDuplo<T>();
    

    public ListaDuplamenteEncadeada() {
    	this.tamanho= 0;
    	this.inicio = null;
    	this.fim = null;
        this.inicioCabeca.setProximo(fimCabeca);
        this.fimCabeca.setAnterior(inicioCabeca);


    }

    @Override
    public void adicionar(T elemento) {
    	NoDuplo<T> novoNo = new NoDuplo<>(elemento);
    	NoDuplo<T> anterior = fimCabeca.getAnterior();
    	novoNo.setProximo(fimCabeca);
    	fimCabeca.setAnterior(novoNo);
    	anterior.setProximo(novoNo);
    	novoNo.setAnterior(anterior);
    	fim = novoNo;
    	inicio = inicioCabeca.getProximo();
    	tamanho++;
    }
    
    @Override
    public void adicionarNoInicio(T elemento) {
    	NoDuplo<T> novoNo = new NoDuplo<>(elemento);
    	NoDuplo<T> proximo = inicioCabeca.getProximo();
    	inicioCabeca.setProximo(novoNo);
    	novoNo.setProximo(proximo);
    	novoNo.setAnterior(inicioCabeca);
    	proximo.setAnterior(novoNo);
    	inicio = novoNo;
    	tamanho++;
    }
    @Override
    public void adicionarNoFim(T elemento) {
    	NoDuplo<T> novoNo = new NoDuplo<>(elemento);
    	NoDuplo<T> anterior = fimCabeca.getAnterior();
    	anterior.setProximo(novoNo);
    	novoNo.setAnterior(anterior);
    	novoNo.setProximo(fimCabeca);
    	fimCabeca.setAnterior(novoNo);
        fim = novoNo;
    	tamanho++;
    	}

    @Override
    public void adicionar(T elemento, int posicao) throws NullPointerException{
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        if (posicao==0){
            this.adicionarNoInicio(elemento);
        }
        else if (posicao == tamanho) {
        	this.adicionarNoFim(elemento);	
        }
        else if (posicao < tamanho) {
        	int meio = tamanho / 2;
        	if	(posicao < meio) {
            	NoDuplo<T> atual = inicio;
            	for(int i= 0; i < posicao; i++) {
            		atual = atual.getProximo();
            	}
            	NoDuplo<T> anterior = atual.getAnterior();
            	anterior.setProximo(novoNo);
            	novoNo.setAnterior(anterior);
            	novoNo.setProximo(atual);
            	atual.setAnterior(novoNo);	
        	}
        	else {
        		NoDuplo<T> atual = fim;
        		for(int i= tamanho-1; i> posicao; i--) {
        			atual = atual.getAnterior();
        		}
        		NoDuplo<T> anterior = atual.getAnterior();
        		novoNo.setAnterior(anterior);
        		novoNo.setProximo(atual);
        		atual.setAnterior(novoNo);
        		anterior.setProximo(novoNo);
        	}
        	tamanho ++;
        }
        else{
            throw new NullPointerException();
        }
    }
    

    @Override
    public T remover(int posicao) throws NullPointerException {
        T result = null;
        if (posicao==0){
            result = this.removerNoInicio();
        }
        else if (posicao == tamanho-1) {
            result = this.removerNoFim();
        }
        else if (posicao < tamanho-1) {
  
        	int meio = tamanho-1 / 2;
        	if(posicao < meio) {
                    NoDuplo<T> atual = inicio;
                    for(int i= 0; i < posicao; i++) {
                            atual = atual.getProximo();
                    }
                    result = atual.getElemento();
                    NoDuplo<T> anterior = atual.getAnterior();
                    NoDuplo<T> proximo = atual.getProximo();
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
        	}
        	else {
                    NoDuplo<T> atual = fim;
                    for(int i= tamanho-1; i> posicao; i--) {
                            atual = atual.getAnterior();
                    }
                    result = atual.getElemento();
                       NoDuplo<T> anterior = atual.getAnterior();
                    NoDuplo<T> proximo = atual.getProximo();
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
        	}
        	tamanho --;
        }
        else{
            throw new NullPointerException();
        }
        return result;
    }

    @Override
    public T removerNoInicio() {
        NoDuplo<T> result = inicio;
        NoDuplo<T> proximo = inicio.getProximo();
        inicioCabeca.setProximo(proximo);
        proximo.setAnterior(inicioCabeca);
        inicio = proximo;
        tamanho --;
        return result.getElemento();
    }

    @Override
    public T removerNoFim() {
        NoDuplo<T> result = fim;
        NoDuplo<T> anterior = fim.getAnterior();
        fimCabeca.setAnterior(anterior);
        anterior.setProximo(fimCabeca);
        fim = anterior;
        tamanho --;
        return result.getElemento();

    }

    @Override
    public T buscar(int posicao) throws NullPointerException{
        int meio = tamanho/2;
        if (posicao < meio){
            NoDuplo<T> atual = inicio;        
            for (int i=0; i<posicao; i++){
                atual = atual.getProximo();
            }
            return atual.getElemento();
        }
        else if (posicao < tamanho){
            NoDuplo<T> atual = fim;
            for (int i= tamanho-1; i> posicao; i--){
                atual = atual.getAnterior();
            }
            return atual.getElemento();
        }
        else{
            throw new NullPointerException();
        }

    }

    @Override
    public int existe(T elemento) {
        NoDuplo<T> atual = inicio;
        for (int i=0; i<tamanho; i++){
            if (atual.getElemento() == elemento){
                return i;
            }
            atual = atual.getProximo();
        }
        return -1;
    }
    
    public boolean contemRecursivo(T elemento, int indice) {
    	try {
        	if(this.buscar(indice).equals(elemento)) {
        		return true;
        	}
        	else {
        		return contemRecursivo(elemento, indice+1);
        		}
    	}
    	catch(NullPointerException e){
    		return false;	
    	}
    	
    	}

    @Override
    public void limpar() {
        this.tamanho= 0;
    	this.inicio = null;
    	this.fim = null;
        this.inicioCabeca.setProximo(fimCabeca);
        this.fimCabeca.setAnterior(inicioCabeca);

    }
    
    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaDuplamenteEncadeada<>(this.inicio);
    }

}

