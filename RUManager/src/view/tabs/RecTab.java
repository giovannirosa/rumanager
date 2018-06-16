package view.tabs;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.table.TItemModel;
import model.table.TableModel;
import view.Main;
import view.pane.RecPane;
import view.table.RecTable;
import view.utils.Factory;

public class RecTab extends AbstractTab {

	RecTable itTable = new RecTable();
	RecPane itemPane;
	
	Button viewBut = new Button("Visualizar", new ImageView(Factory.getButIcon("search.png")));

	public RecTab(String title) {
		super(title, Main.recControl);
		itTable.getColumns().remove(4);
		setTable(itTable);
		initUI();
		setActions();
		buttonPane.getChildren().remove(editBut);
		buttonPane.getChildren().add(2, viewBut);
		Main.recControl.loadTable(itTable.getData());
	}
	
	public void removeAddPane() {
		geralPane.getChildren().remove(addPane);
	}
	
	private void setActions() {
		addBut.setOnAction(e -> {
			itemPane = new RecPane(itTable,this);
			itemPane.addMode();
			setAddPane(itemPane);
			addPane();
		});
		viewBut.setOnAction(e -> {
			if (!checkSelection())
				return;
			
			itemPane = new RecPane(itTable,this);
			itemPane.editMode(itTable.getSelectionModel().getSelectedItem());
			setAddPane(itemPane);
			addPane();
		});
		delBut.setOnAction(e -> {
			if (!checkSelection())
				return;
			
			TableModel model = table.getSelectionModel().getSelectedItem();
			
			if (!delete(model))
				return;
			
			if (itTable.getItems().size() < 1)
				itTable.getData().add(new TItemModel());

		});
	}
}
