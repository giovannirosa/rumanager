package view.pane;

import javafx.scene.control.TextArea;
import model.table.TableModel;
import view.utils.UtilPane;

public class FinalPane extends UtilPane {
	
	

	public FinalPane(TextArea textArea) {
		super(null, null);
		
		geralPane.getChildren().remove(0);
		geralPane.getChildren().add(0, textArea);
		
		confirmBut.setText("Salvar");
		cancelBut.setText("Fechar");
	}

	@Override
	public void addMode() {}

	@Override
	public void editMode(TableModel model) {}

	@Override
	public void clear() {}

}
