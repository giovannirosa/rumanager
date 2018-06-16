package view.tabs;

import controller.Control;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.table.TableModel;
import view.Main;
import view.table.Table;
import view.utils.Factory;
import view.utils.UtilPane;

public abstract class AbstractTab extends Tab {
	VBox geralPane = new VBox(20);
	GridPane inputPane = new GridPane();
	HBox buttonPane = new HBox(20);
	
	Table<TableModel> table;
	UtilPane addPane;
	Control control;
	
	Button addBut = new Button("_Adicionar",new ImageView(Factory.getButIcon("add.png")));
	Button editBut = new Button("_Editar",new ImageView(Factory.getButIcon("edit.png")));
	Button delBut = new Button("_Deletar",new ImageView(Factory.getButIcon("delete.png")));
	Button closeBut = new Button("_Fechar",new ImageView(Factory.getButIcon("exit.png")));
	
	Scene scene;
	
	public AbstractTab(String title, Control control) {
		scene = new Scene(geralPane);
		this.setContent(geralPane);
		this.setText(title);
		this.control = control;
		setCommomActions();
		addBut.setMnemonicParsing(true);
		editBut.setMnemonicParsing(true);
		delBut.setMnemonicParsing(true);
		closeBut.setMnemonicParsing(true);
	}
	
	protected void setTable(Table<TableModel> table) {
		this.table = table;
	}
	
	protected void setAddPane(UtilPane addPane) {
		this.addPane = addPane;
	}
	
	protected void addPane() {
		addPane.showAndWait();
	}
	
	protected boolean checkSelection() {
		if (table.getSelectionModel().getSelectedItem() == null) {
			Factory.showWarning("Por favor selecione um registro!");
        	return false;
		} else if (table.getSelectionModel().getSelectedItem().getId().equals("")) {
			Factory.showWarning("N�o existem registros!");
        	return false;
		}
		return true;
	}
	
	protected boolean delete(TableModel model) {
		if (model.getId().equals("")) {
			Factory.showWarning("N�o existem mais registros para serem deletados!");
			return false;
		}
		int id = Integer.parseInt(model.getId());
		boolean b;
		if (Factory.showConfirmation("Deletar \""+model.getDesc()+"\" permanentemente?")) {
			b = control.remove(id);
		} else {
			return false;
		}
		
		refreshTable();
		
		return b;
	}
	
	protected void initUI() {
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(addBut,editBut,delBut,closeBut);

		geralPane.setAlignment(Pos.BOTTOM_CENTER);
		geralPane.setPadding(new Insets(20));
		geralPane.getChildren().addAll(table,buttonPane);
		VBox.setVgrow(table, Priority.ALWAYS);
		table.setPrefHeight(Factory.screen.getHeight()*0.9);
	}

	public void removeAddPane() {
		geralPane.getChildren().remove(addPane);
	}
	
	public void refreshTable() {
		control.loadTable(table.getData());
	}
	
	public void refreshUITable() {
		table.getColumns().get(0).setVisible(false);
		table.getColumns().get(0).setVisible(true);
	}
	
	private void setCommomActions() {
		closeBut.setOnAction(e -> {
			if (geralPane.getChildren().contains(addPane)) {
				geralPane.getChildren().remove(addPane);
			}
			Main.tabPane.getTabs().remove(this);
		});
	}
}
