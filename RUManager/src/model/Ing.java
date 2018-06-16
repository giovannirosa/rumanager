package model;

public class Ing implements Model {

	private int id;
	private String nome;
	private int qtde;
	private String unidade;
	
	public Ing(int id, String nome, int qtde, String unidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtde = qtde;
		this.unidade = unidade;
	}
	
	public String mountIng() {
		return nome+" > "+qtde+" "+unidade;
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

	@Override
	public String getDesc() {
		return nome;
	}
}
