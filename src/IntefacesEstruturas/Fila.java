package IntefacesEstruturas;

public interface Fila<T> {
    public boolean enfileirar(T valor);
    public T desenfileirar();
    public int tamanho();
    public boolean vazia();
    public T primeiro();
    public T ultimo();
}

