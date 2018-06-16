package view.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.table.TableModel;

public class RecTable extends Table<TableModel> {
	private TableColumn<TableModel, String> idCol = new TableColumn<>("Id");
	private TableColumn<TableModel, String> nameCol = new TableColumn<>("Nome");
	private TableColumn<TableModel, String> porcCol = new TableColumn<>("Por��es");
	private TableColumn<TableModel, String> calorCol = new TableColumn<>("Valor Cal�rico");
	private TableColumn<TableModel, String> selCol = new TableColumn<>("Selecionado");
	
	@SuppressWarnings("unchecked")
	public RecTable() {
		getData().clear();
		this.getColumns().addAll(idCol,nameCol,porcCol,calorCol,selCol);
		this.setItems(getData());
		
		idCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("name"));
		porcCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("porc"));
		calorCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("calor"));
		selCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("sel"));
		selCol.setStyle("-fx-alignment: CENTER;");
		
		configColumns();
	}
}
