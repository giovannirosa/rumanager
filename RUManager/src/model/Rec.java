package model;

import java.util.List;

public class Rec implements Model {
	
	private int id;
	private String nome;
	private String modoPreparo;
	private int noPorcoes;
	private int valorCalorico;
	
	private List<Ing> listaIngrediente;
	
	public Rec(int id, String nome, String modoPreparo, int noPorcoes, int valorCalorico, List<Ing> listaIngrediente) {
		super();
		this.id = id;
		this.nome = nome;
		this.modoPreparo = modoPreparo;
		this.noPorcoes = noPorcoes;
		this.valorCalorico = valorCalorico;
		this.setListaIngrediente(listaIngrediente);
	}
	
	public String mountRec() {
		StringBuilder text = new StringBuilder();
		text.append("Nome: "+nome+"\n");
		text.append("Porções: "+noPorcoes+"\n");
		text.append("Calorias: "+valorCalorico+"\n");
		text.append("Ingredientes:\n");
		for (Ing i : listaIngrediente) {
			text.append(" - "+i.mountIng()+"\n");
		}
		text.append("Modo de Preparo:\n\n");
		text.append(modoPreparo);
		return text.toString();
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

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public int getNoPorcoes() {
		return noPorcoes;
	}

	public void setNoPorcoes(int noPorcoes) {
		this.noPorcoes = noPorcoes;
	}

	public int getValorCalorico() {
		return valorCalorico;
	}

	public void setValorCalorico(int valorCalorico) {
		this.valorCalorico = valorCalorico;
	}

	public List<Ing> getListaIngrediente() {
		return listaIngrediente;
	}

	public void setListaIngrediente(List<Ing> listaIngrediente) {
		this.listaIngrediente = listaIngrediente;
	}

	@Override
	public String getDesc() {
		return nome;
	}
}
