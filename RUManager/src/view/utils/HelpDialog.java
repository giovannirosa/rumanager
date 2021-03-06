package view.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.Main;

public class HelpDialog extends Stage {
	
	VBox geralPane = new VBox(20);
	VBox centerPane = new VBox(20);
	HBox buttonPane = new HBox(20);
	
	Label titleLabel = new Label("Suporte");
	Label messLabel = new Label("Se tiver alguma d�vida ou algum problema, por favor contate:"
			+ "\n\n\t- Celular: (41) 9 9610-1950"
			+ "\n\n\t- Email: giovanni_rosa4@hotmail.com");
	
	Button closeBut = new Button("Fechar",new ImageView(Factory.getButIcon("exit.png")));
	
	public HelpDialog() {
		this.setTitle("Ajuda");
		this.setResizable(false);
		this.initStyle(StageStyle.UTILITY);
		this.initOwner(Main.getModal());
		this.initModality(Modality.APPLICATION_MODAL);
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(closeBut);
		
		setActions();
		
		messLabel.setId("help");
		
		centerPane.setAlignment(Pos.CENTER);
		centerPane.getChildren().addAll(titleLabel,messLabel);
		
		geralPane.setAlignment(Pos.CENTER);
		geralPane.setPadding(new Insets(20));
		geralPane.getChildren().addAll(centerPane,buttonPane);
		geralPane.setId("Pane");
		
		Scene scene = new Scene(geralPane);
		this.setScene(scene);
		scene.getStylesheets().addAll
		(Main.class.getResource("Style.css").toExternalForm());
		
		this.requestFocus();
	}

	private void setActions() {
		closeBut.setOnAction(e -> this.close());
	}
}
