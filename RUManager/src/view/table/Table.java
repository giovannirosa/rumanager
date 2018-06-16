package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public abstract class Table<T> extends TableView<T> {
	
	private final ObservableList<T> data = FXCollections.observableArrayList();
	
	protected void setPlaceholder() {
		HBox box = new HBox();
	    box.setDisable(true);
	    for (TableColumn<?,?> column : this.getColumns()) {
	        ListView<String> listView = new ListView<>();
	        listView.getItems().add("");
	        listView.setPrefWidth(column.getWidth());
	        box.getChildren().add(listView);
	    }

	    this.setPlaceholder(box);
	}
	
	protected void configColumns() {
		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}

	public ObservableList<T> getData() {
		return data;
	}
}
