package view.tabs;

import model.table.TItemModel;
import model.table.TableModel;
import view.Main;
import view.pane.ItemPane;
import view.table.ItemTable;

public class ItemTab extends AbstractTab {
	
	ItemTable itTable = new ItemTable();
	ItemPane itemPane = new ItemPane(itTable,this);

	public ItemTab(String title) {
		super(title, Main.itemControl);
		setTable(itTable);
		setAddPane(itemPane);
		initUI();
		setActions();
		Main.itemControl.loadTable(itTable.getData());
	}
	
	public void removeAddPane() {
		geralPane.getChildren().remove(addPane);
	}
	
	private void setActions() {
		addBut.setOnAction(e -> {
			itemPane.addMode();
			itemPane.clear();
			addPane();
		});
		editBut.setOnAction(e -> {
			if (!checkSelection())
				return;
			
			itemPane.editMode(itTable.getSelectionModel().getSelectedItem());
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
			
//			Screen.itemControl.refreshBox(Screen.storageTab.getPane().itemBox);
//			Screen.itemControl.refreshBoxCombo(comboPane.itemBox);
//			String log = Screen.userControl.getUser().getName()+" removed "+model.getDesc()+" from items!";
//			System.out.println(log);
//			Factory.log(log);
		});
	}
}