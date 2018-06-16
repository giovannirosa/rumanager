package view.tabs;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.table.TRecModel;
import model.table.TableModel;
import view.Main;
import view.pane.RefPane;
import view.table.RecTable;
import view.utils.Factory;

public class RefTab extends AbstractTab {
	
	public static RecTable recTable1 = new RecTable();
	RefPane refPane;
	
	Button incBut = new Button("Incluir/Retirar Receita", new ImageView(Factory.getButIcon("restaurant.png")));
	Button finBut = new Button("Finalizar Refei��o", new ImageView(Factory.getButIcon("share.png")));
	Button limpBut = new Button("Limpar Sele��o", new ImageView(Factory.getButIcon("delete.png")));
	

	public RefTab(String title) {
		super(title, null);
		this.setOnClosed(e -> clean());
		
		setActions();
		
		setTable(recTable1);
		initUI();
		
		buttonPane.getChildren().clear();
		buttonPane.getChildren().addAll(incBut,finBut,limpBut,closeBut);
		
		Main.recControl.loadTable(recTable1.getData());
	}
	
	private void clean() {
		for (TableModel m : recTable1.getItems()) {
			TRecModel r = (TRecModel) m;
			r.setSel("");
		}
		refreshUITable();
	}
	
	private void setActions() {
		closeBut.setOnAction(e -> {
			clean();
			if (geralPane.getChildren().contains(addPane)) {
				geralPane.getChildren().remove(addPane);
			}
			Main.tabPane.getTabs().remove(this);
		});
		limpBut.setOnAction(e -> {
			if (Factory.showConfirmation("Tem certeza que deseja limpar a sele��o de receitas?")) {
				clean();
				Factory.showWarning("Sele��o de receitas limpa!");
			}
		});
		incBut.setOnAction(e -> {
			if (!checkSelection())
				return;
			
			TRecModel r = (TRecModel) recTable1.getSelectionModel().getSelectedItem();
			
			if (r.getSel().equals("X")) {
				r.setSel("");
				refreshUITable();
				Factory.showWarning(r.getName()+" retirado da refei��o!");
			} else {
				r.setSel("X");
				refreshUITable();
				Factory.showWarning(r.getName()+" incluso na refei��o!");
			}
		});
		finBut.setOnAction(e -> {
			boolean atLeast = false;
			for (TableModel m : recTable1.getItems()) {
				TRecModel r = (TRecModel) m;
				if (r.getSel().equals("X")) {
					atLeast = true;
				}
			}
			if (!atLeast) {
				Factory.showWarning("Por favor selecione ao menos uma receita!");
				return;
			}
			
			refPane = new RefPane(recTable1, this);
			refPane.showAndWait();
		});
	}
}
