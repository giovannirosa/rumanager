package model.table;

import java.text.DecimalFormat;

import javafx.beans.property.SimpleStringProperty;

public class TItemModel implements TableModel {

	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty qtde;
	private SimpleStringProperty unidade;
	private SimpleStringProperty preco;
	
	public TItemModel(int i, String n, int q, String u, double p) {
		id = new SimpleStringProperty(Integer.toString(i));
		name = new SimpleStringProperty(n);
		qtde = new SimpleStringProperty(Integer.toString(q));
		unidade = new SimpleStringProperty(u);
		preco = new SimpleStringProperty(new DecimalFormat("##.00").format(p));
	}
	
	public TItemModel() {
		id = new SimpleStringProperty("");
		name = new SimpleStringProperty("");
		qtde = new SimpleStringProperty("");
		unidade = new SimpleStringProperty("");
		preco = new SimpleStringProperty("");
	}

	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getQtde() {
		return qtde.get();
	}

	public void setQtde(String value) {
		this.qtde.set(value);
	}

	public String getUnidade() {
		return unidade.get();
	}

	public void setUnidade(String unidade) {
		this.unidade.set(unidade);
	}

	public String getPreco() {
		return preco.get();
	}

	public void setPreco(String preco) {
		this.preco.set(preco);
	}

	public String getDesc() {
		return name.get();
	}
}
