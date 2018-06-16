package view.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TitlePane extends VBox {
	
	Label markLabel = new Label("RU Manager");
	Label subLabel = new Label("Controle Operacional do Restaurante Universit�rio!");
	
	public TitlePane() {
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(markLabel,subLabel);
		markLabel.setId("title");
	}
}
