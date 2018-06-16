package model;

public class Item implements Model {
	
	private int id;
	private String nome;
	private int qtde;
	private String unidade;
	private double preco;
	
	public Item(int id, String nome, int qtde, String unidade, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtde = qtde;
		this.unidade = unidade;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String getDesc() {
		return nome;
	}
}
