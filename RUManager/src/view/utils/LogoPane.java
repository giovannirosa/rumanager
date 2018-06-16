package view.utils;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class LogoPane extends HBox {
	
	ImageView imgView = new ImageView();
	
	public LogoPane(double width, double height) {
		Image img = new Image(Factory.getImagePath("ufpr.jpg"), width, height, true, true);
		imgView.setImage(img);
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(imgView);
	}
}
