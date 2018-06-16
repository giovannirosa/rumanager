package controller;

import controller.database.ItemDB;
import javafx.collections.ObservableList;
import model.Item;
import model.Model;
import model.table.TItemModel;
import model.table.TableModel;

public class ItemControl extends Control {

	public ItemControl() {
		super(new ItemDB());
	}

	@Override
	public void loadTable(ObservableList<TableModel> data) {
		data.clear();
		if (map.isEmpty()) {
			data.add(new TItemModel());
			return;
		}
		for (Model m : map.values()) {
			Item i = (Item) m;
			data.add(new TItemModel(i.getId(), i.getNome(), i.getQtde(), i.getUnidade(), i.getPreco()));
		}
	}
}
