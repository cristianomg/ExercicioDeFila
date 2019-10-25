/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada.classes;

/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class NoDuplo<T> {
    private T elemento;
    private NoDuplo<T> proximo;
    private NoDuplo<T> anterior;

    public NoDuplo(){
        this.elemento = null;
        this.proximo = null;
        this.anterior = null;
    }
    public NoDuplo(T elemento) {
    	this.elemento = elemento;
    	this.proximo = null;
    }

    public NoDuplo(T elemento, NoDuplo<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    
    public NoDuplo<T> getProximo() {
        return proximo;
    }
    
    public NoDuplo<T> getAnterior(){
        return anterior;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }
    
    public void setAnterior(NoDuplo<T> anterior){
        this.anterior = anterior;
    }
    
    
    
}