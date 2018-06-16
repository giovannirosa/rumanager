package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.Main;

public class RUManager extends Application {

	public static void main(String[] args) throws Exception {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new Main();
		stage.show();
	}
}
