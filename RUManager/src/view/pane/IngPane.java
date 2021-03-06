package view.pane;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import model.Item;
import model.table.TItemModel;
import model.table.TableModel;
import view.Main;
import view.table.ItemTable;
import view.utils.Factory;
import view.utils.UtilPane;

public class IngPane extends UtilPane {
	
	Label nomeLabel = new Label("Item:");
//	Label dispLabel = new Label("Disponível:");
	Label qtdeLabel = new Label("Quantidade:");
	Label unidadeLabel = new Label("Unidade:");
	
	public static ComboBox<String> itemBox = new ComboBox<>();
//	TextField dispField = new TextField();
	Spinner<Integer> qtdeSpin = new Spinner<>();
	TextField unidadeField = new TextField();

	public IngPane(ItemTable table) {
		super(table, null);
		
		Main.itemControl.refreshBox(itemBox);
		
		unidadeField.setDisable(true);
//		dispField.setDisable(true);
		itemBox.setOnAction(e -> {
			if (itemBox.getValue() == null)
				return;
			Item i = (Item) Main.itemControl.get(itemBox.getValue());
//			dispField.setText(Integer.toString(i.getQtde()));
			unidadeField.setText(i.getUnidade());
		});
		Item it = (Item) Main.itemControl.get(itemBox.getValue());
//		dispField.setText(Integer.toString(it.getQtde()));
		unidadeField.setText(it.getUnidade());
		
		Factory.configSpin(qtdeSpin, 0, 1000, 0, 1);
		
		confirmBut.setOnAction(e -> {
			Item i = (Item) Main.itemControl.get(itemBox.getValue());
			
			if (table.getItems().get(0).getId().equals("")) {
				table.getItems().remove(0);
			}
			
			table.getItems().add(new TItemModel(i.getId(),i.getNome(),
					qtdeSpin.getValue(),unidadeField.getText(),0.0));
			this.close();
		});
		
		inputPane.getChildren().clear();
		inputPane.add(nomeLabel, 0, 0);
		inputPane.add(itemBox, 1, 0);
//		inputPane.add(dispLabel, 0, 1);
//		inputPane.add(dispField, 1, 1);
		inputPane.add(qtdeLabel, 0, 1);
		inputPane.add(qtdeSpin, 1, 1);
		inputPane.add(unidadeLabel, 0, 2);
		inputPane.add(unidadeField, 1, 2);
	}

	@Override
	public void addMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editMode(TableModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
	}
}
