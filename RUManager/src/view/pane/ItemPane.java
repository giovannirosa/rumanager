package view.pane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import view.Main;
import view.table.ItemTable;
import view.tabs.ItemTab;
import view.utils.Factory;
import view.utils.UtilPane;
import model.*;
import model.table.TItemModel;
import model.table.TableModel;

public class ItemPane extends UtilPane {
	Label idLabel = new Label("ID:");
	Label nomeLabel = new Label("Nome:");
	Label qtdeLabel = new Label("Quantidade:");
	Label unidadeLabel = new Label("Unidade:");
	Label precoLabel = new Label("Pre�o Unit�rio:");
	
	TextField idField = new TextField();
	TextField nomeField = new TextField();
	Spinner<Integer> qtdeSpin = new Spinner<>();
	TextField unidadeField = new TextField();
	TextField precoField = new TextField();
	
	public ItemPane(ItemTable table, ItemTab tab) {
		super(table,tab);
		
		Factory.configSpin(qtdeSpin, 0, 1000, 0, 1);
		
		// force the field to be numeric only
		precoField.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d,*")) {
	            	precoField.setText(newValue.replaceAll("[^\\d,]", ""));
	            }
	        }
	    });
		
		setControl(Main.itemControl);
	}
	
	private boolean validate() {
		if (nomeField.getText().isEmpty()) {
			Factory.showWarning("Por favor entre com o nome!");
			return false;
		}
		if (unidadeField.getText().isEmpty()) {
			Factory.showWarning("Por favor entre com a unidade!");
			return false;
		}
		if (precoField.getText().isEmpty()) {
			Factory.showWarning("Por favor entre com o pre�o!");
			return false;
		}
		return true;
	}
	
	public void addMode() {
		inputPane.getChildren().clear();
		inputPane.add(nomeLabel, 0, 0);
		inputPane.add(nomeField, 1, 0);
		inputPane.add(qtdeLabel, 0, 1);
		inputPane.add(qtdeSpin, 1, 1);
		inputPane.add(unidadeLabel, 0, 2);
		inputPane.add(unidadeField, 1, 2);
		inputPane.add(precoLabel, 0, 3);
		inputPane.add(precoField, 1, 3);
		
		confirmBut.setOnAction(e -> {			
			if (!validate())
				return;
			
			int id;
			if (table.getItems().isEmpty() || table.getItems().get(0).getId().equals(""))
				id = 0;
			else
				id = Integer.parseInt(table.getItems().get(table.getItems().size()-1).getId());
			
			Item i = new Item(id+1,nomeField.getText(),qtdeSpin.getValue(),
					unidadeField.getText(),Double.parseDouble(precoField.getText()));
			
			insert(i);
			Main.itemControl.refreshBox(IngPane.itemBox);
			
			this.close();
			Factory.showWarning("Estoque atualizado com sucesso!");
		});
	}
	
	public void editMode(TableModel abstractModel) {
		TItemModel model = (TItemModel) abstractModel;
		idField.setText(model.getId());
		idField.setDisable(true);
		
		nomeField.setText(model.getName());
		qtdeSpin.getValueFactory().setValue(Integer.parseInt(model.getQtde()));
		unidadeField.setText(model.getUnidade());
		precoField.setText(model.getPreco());
		
		inputPane.getChildren().clear();
		inputPane.add(idLabel, 0, 0);
		inputPane.add(idField, 1, 0);
		inputPane.add(nomeLabel, 0, 1);
		inputPane.add(nomeField, 1, 1);
		inputPane.add(qtdeLabel, 0, 2);
		inputPane.add(qtdeSpin, 1, 2);
		inputPane.add(unidadeLabel, 0, 3);
		inputPane.add(unidadeField, 1, 3);
		inputPane.add(precoLabel, 0, 4);
		inputPane.add(precoField, 1, 4);
		
		confirmBut.setOnAction(e -> {			
			if (!validate())
				return;
			
			Item i = new Item(Integer.parseInt(model.getId()),nomeField.getText(),
					qtdeSpin.getValue(),unidadeField.getText(),Double.parseDouble(precoField.getText().replace(",", ".")));
			
			insert(i);
			Main.itemControl.refreshBox(IngPane.itemBox);
			
			this.close();
			Factory.showWarning("Estoque atualizado com sucesso!");
		});
	}
	
	public void clear() {
		nomeField.clear();
		qtdeSpin.getValueFactory().setValue(0);
		unidadeField.clear();
		precoField.clear();
	}
}
