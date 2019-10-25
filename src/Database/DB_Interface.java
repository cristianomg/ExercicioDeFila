package Database;

import Lista.classes.Lista;

public interface DB_Interface <T>{
	public boolean inserir(T item);
	public boolean atualizar(T newItem);
	public boolean remover(int id);
	public Lista<T> getLista();
	public T getById(int id);
}
