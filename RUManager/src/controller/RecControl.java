package controller;

import controller.database.RecDB;
import javafx.collections.ObservableList;
import model.Model;
import model.Rec;
import model.table.TItemModel;
import model.table.TRecModel;
import model.table.TableModel;

public class RecControl extends Control {
	
	public RecControl() {
		super(new RecDB());
	}

	@Override
	public void loadTable(ObservableList<TableModel> data) {
		data.clear();
		if (map.isEmpty()) {
			data.add(new TItemModel());
			return;
		}
		for (Model m : map.values()) {
			Rec r = (Rec) m;
			data.add(new TRecModel(r.getId(), r.getNome(), r.getValorCalorico(), r.getNoPorcoes()));
		}
	}
}
