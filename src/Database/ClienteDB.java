package Database;

import Lista.classes.Lista;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;
import Models.Cliente;

public class ClienteDB implements DB_Interface<Cliente>{
	private static ClienteDB uniqueInstance;
	private Lista<Cliente> listaClientes;
	
	private ClienteDB(){
		this.listaClientes = new ListaDuplamenteEncadeada<Cliente>();
	}
	
	public static synchronized ClienteDB getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new ClienteDB();
		}
		return uniqueInstance;
	}

	@Override
	public boolean inserir(Cliente item) {
		boolean contem = false;
		if(this.listaClientes.tamanho() > 0) {
			for (Cliente cliente : this.listaClientes) {
				if (cliente.getId() == item.getId()) {
					contem = true;
					break;
				}
			}
			if(!contem) {
				this.listaClientes.adicionar(item);
				return true;
			}
		}else {
			this.listaClientes.adicionar(item);
			return true;
		}
		return false;	
	}

	@Override
	public boolean atualizar(Cliente newItem) {
		boolean contem = false;
		int pos = 0;
		for (Cliente cliente : this.listaClientes) {
			if (cliente.getId() == newItem.getId()) {
				this.listaClientes.remover(pos);
				contem = true;
				break;
			}
			pos++;
		}
		if(!contem) {
			this.listaClientes.adicionar(newItem);
			return true;
		}
		return false;
	}

	@Override
	public boolean remover(int id) {
		int pos = 0;
		for (Cliente cliente : this.listaClientes) {
			if (cliente.getId() == id) {
				this.listaClientes.remover(pos);
				return true;
			}
			pos++;
		}
		return false;
	}

	@Override
	public Lista<Cliente> getLista() {
		return this.listaClientes;
	}

	@Override
	public Cliente getById(int id) {
		for (Cliente cliente : this.listaClientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}
}
