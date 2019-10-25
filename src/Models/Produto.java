package Models;

public class Produto {
	private static int incremento = 1;
	private int id;
	private String nome;
	private Integer valor;
	private Integer qtdEstoque;
	
	
	
	public Produto(String nome, Integer valor, Integer qtdEstoque) {
		super();
		this.id = incremento;
		this.nome = nome;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		Produto.incremento++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public int getId() {
		return id;
	}
	
}
