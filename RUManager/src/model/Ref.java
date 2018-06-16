package model;

import java.util.ArrayList;
import java.util.List;

public class Ref {
	
	private int noRefeicoes;
	private double custoTotal;
	
	List<Rec> listaReceita = new ArrayList<>();
	
	public Ref(int noRefeicoes, double custoTotal) {
		super();
		this.noRefeicoes = noRefeicoes;
		this.custoTotal = custoTotal;
	}

	public int getNoRefeicoes() {
		return noRefeicoes;
	}

	public void setNoRefeicoes(int noRefeicoes) {
		this.noRefeicoes = noRefeicoes;
	}

	public double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}
}
