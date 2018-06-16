package view.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Item;
import model.table.TItemModel;
import model.table.TableModel;
import view.Main;
import view.pane.IngPane;
import view.table.ItemTable;

public class IngUtilPane extends VBox {
	
	HBox buttonPane = new HBox(20);
	
	Button addBut = new Button("Adicionar", new ImageView(Factory.getButIcon("add.png")));
	Button delBut = new Button("Deletar", new ImageView(Factory.getButIcon("delete.png")));
	
	ItemTable ingTable;
	
	public IngUtilPane(ItemTable table) {
		ingTable = table;
		ingTable.getItems().add(new TItemModel());
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(addBut,delBut);
		
		addBut.setOnAction(e -> {
			new IngPane(ingTable).show();
		});
		
		delBut.setOnAction(e -> {
			if (ingTable.getSelectionModel().getSelectedItem() != null) {
				TableModel m = ingTable.getSelectionModel().getSelectedItem();
				ingTable.getItems().remove(m);
				Item i = (Item) Main.itemControl.get(Integer.parseInt(m.getId()));
				
				int q = Integer.parseInt(((TItemModel)m).getQtde());
				
				i.setQtde(i.getQtde()+q);
				Main.itemControl.insert(i);
				Main.itemTab.refreshTable();
			}
			if (ingTable.getItems().isEmpty()) {
				ingTable.getItems().add(new TItemModel());
			}
		});
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.getChildren().addAll(ingTable, buttonPane);
	}
	
	public void setReadOnly() {
		ingTable.getItems().remove(0);
		this.getChildren().remove(buttonPane);
	}
}
