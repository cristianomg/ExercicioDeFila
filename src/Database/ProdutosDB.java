package Database;

import Lista.classes.Lista;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;
import Models.Produto;

public class ProdutosDB implements DB_Interface<Produto>{
	private static ProdutosDB uniqueInstance;
	private Lista<Produto> listaProdutos;

	
	private ProdutosDB(){
		this.listaProdutos = new ListaDuplamenteEncadeada<Produto>();
	}
	
	public static synchronized ProdutosDB getInstance() {
		
		if (uniqueInstance == null){
			uniqueInstance = new ProdutosDB();
		}
		return uniqueInstance;
	}

	@Override
	public boolean inserir(Produto item) {
		boolean contem = false;
		if(this.listaProdutos.tamanho() > 0) {
			for (Produto produto : this.listaProdutos) {
				if (produto.getId() == item.getId()) {
					contem = true;
					break;
				}
			}
			if(!contem) {
				this.listaProdutos.adicionar(item);
				return true;
			}
		}
		else {
			this.listaProdutos.adicionar(item);
			return true;
		}
		return false;
	}

	@Override
	public boolean atualizar(Produto newItem) {
		boolean contem = false;
		int pos = 0;
		for (Produto produto : this.listaProdutos) {
			if (produto.getId() == newItem.getId()) {
				this.listaProdutos.remover(pos);
				contem = true;
				break;
			}
			pos++;
		}
		if(!contem) {
			this.listaProdutos.adicionar(newItem);
			return true;
		}
		return false;
	}

	@Override
	public boolean remover(int id) {
		int pos = 0;
		for (Produto produto : this.listaProdutos) {
			if (produto.getId() == id) {
				this.listaProdutos.remover(pos);
				return true;
			}
			pos++;
		}
		return false;
	}

	@Override
	public Lista<Produto> getLista() {
		return this.listaProdutos;
	}

	@Override
	public Produto getById(int id) {
		for (Produto produto : this.listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
}
