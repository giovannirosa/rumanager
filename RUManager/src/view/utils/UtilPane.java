package view.utils;

import controller.Control;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Model;
import model.table.TableModel;
import view.Main;
import view.table.Table;
import view.tabs.AbstractTab;
import view.utils.Factory;

public abstract class UtilPane extends Stage {

	Control control;
	protected Table<TableModel> table;
	AbstractTab tab;
	
	Scene scene;
	
	protected VBox geralPane = new VBox(20);
	protected GridPane inputPane = new GridPane();
	protected HBox buttonPane = new HBox(20);
	
	protected Button confirmBut = new Button("Confirm",new ImageView(Factory.getButIcon("check.png")));
	protected Button cancelBut = new Button("Cancel",new ImageView(Factory.getButIcon("exit.png")));

	public UtilPane(Table<TableModel> table, AbstractTab tab) {
		this.setTitle("Submit");
		this.setResizable(false);
		this.initStyle(StageStyle.UTILITY);
		this.initOwner(Main.getModal());
		this.initModality(Modality.APPLICATION_MODAL);
		this.table = table;
		this.tab = tab;
		
		inputPane.setVgap(20);
		inputPane.setHgap(20);
		inputPane.setAlignment(Pos.CENTER);
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(confirmBut,cancelBut);
		
		cancelBut.setOnAction(e -> this.close());
		
		geralPane.setAlignment(Pos.CENTER);
		geralPane.setPadding(new Insets(20));
		geralPane.getChildren().addAll(inputPane,buttonPane);
		geralPane.setId("Pane");
		
		scene = new Scene(geralPane);
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				confirmBut.fire();
			if (e.getCode() == KeyCode.ESCAPE)
				cancelBut.fire();
				
		});
		
		this.setScene(scene);
		scene.getStylesheets().addAll
        (Main.class.getResource("Style.css").toExternalForm(),
        Main.class.getResource("StyleTable.css").toExternalForm(),
        Main.class.getResource("StyleComboBox.css").toExternalForm());
	}

	public void setControl(Control control) {
		this.control = control;
	}
	
	public abstract void addMode();
	public abstract void editMode(TableModel model);
	public abstract void clear();
	
	public void insert(Model m) {
		if (!control.insert(m))
			return;
		control.loadTable(table.getData());
		tab.removeAddPane();
	}
}