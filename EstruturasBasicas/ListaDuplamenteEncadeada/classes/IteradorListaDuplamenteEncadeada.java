/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada.classes;

import java.util.Iterator;

/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class IteradorListaDuplamenteEncadeada<T> implements Iterator<T>{
    private NoDuplo<T> atual;

    public IteradorListaDuplamenteEncadeada(NoDuplo<T> inicio) {
        this.atual = inicio;
    }

    @Override
    public boolean hasNext() {
        return atual.getElemento() != null;
    }

    @Override
    public T next() {
        T retorno = this.atual.getElemento();
        this.atual = this.atual.getProximo();
        
        return retorno;
    }
}
