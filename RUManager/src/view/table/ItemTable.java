package view.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.table.TableModel;

public class ItemTable extends Table<TableModel> {
	private TableColumn<TableModel, String> idCol = new TableColumn<>("Id");
	private TableColumn<TableModel, String> nameCol = new TableColumn<>("Nome");
	private TableColumn<TableModel, String> qtdeCol = new TableColumn<>("Quantidade");
	private TableColumn<TableModel, String> unidadeCol = new TableColumn<>("Unidade");
	private TableColumn<TableModel, String> precoCol = new TableColumn<>("Pre�o Unit�rio (R$)");
	
	@SuppressWarnings("unchecked")
	public ItemTable() {
		getData().clear();
		this.getColumns().addAll(idCol,nameCol,qtdeCol,unidadeCol,precoCol);
		this.setItems(getData());
		
		idCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("name"));
		qtdeCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("qtde"));
		unidadeCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("unidade"));
		precoCol.setCellValueFactory(new PropertyValueFactory<TableModel,String>("preco"));
		
		configColumns();
	}
}
