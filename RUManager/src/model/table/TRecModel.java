package model.table;

import javafx.beans.property.SimpleStringProperty;

public class TRecModel implements TableModel {

	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty porc;
	private SimpleStringProperty calor;
	private SimpleStringProperty sel;
	
	public TRecModel(int i, String n, int c, int p) {
		id = new SimpleStringProperty(Integer.toString(i));
		name = new SimpleStringProperty(n);
		porc = new SimpleStringProperty(Integer.toString(p));
		calor = new SimpleStringProperty(Integer.toString(c));
		sel = new SimpleStringProperty("");
	}
	
	public TRecModel() {
		id = new SimpleStringProperty("");
		name = new SimpleStringProperty("");
		porc = new SimpleStringProperty("");
		calor = new SimpleStringProperty("");
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

	public String getCalor() {
		return calor.get();
	}

	public void setCalor(String value) {
		this.calor.set(value);
	}

	public String getPorc() {
		return porc.get();
	}

	public void setPorc(String unidade) {
		this.porc.set(unidade);
	}

	public String getSel() {
		return sel.get();
	}

	public void setSel(String sel) {
		this.sel.set(sel);
	}

	public String getDesc() {
		return name.get();
	}
}
