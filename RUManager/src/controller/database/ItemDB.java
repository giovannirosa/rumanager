package controller.database;

import java.io.File;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import model.Item;
import model.Model;
import view.utils.Factory;

public class ItemDB extends Database {
	
	public ItemDB() {
		table = "item";
		file = new File (Factory.RU_PATH+"\\"+table+".txt");
		checkDatabase();
	}

	@Override
	public void get(Map<Integer, Model> map) {
		map.clear();
		
		for (String line : records) {
			JSONObject obj;
			try {
				obj = new JSONObject(line);
				map.put(obj.getInt("id"), new Item(obj.getInt("id"), obj.getString("nome"),
						obj.getInt("qtde"), obj.getString("unidade"), obj.getDouble("preco")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void set(Map<Integer, Model> map) {
		records.clear();
		
		for (Model m : map.values()) {
			Item i = (Item) m;
			JSONObject obj = new JSONObject();
			
			try {
				obj.put("id", i.getId());
				obj.put("nome", i.getNome());
				obj.put("qtde", i.getQtde());
				obj.put("unidade", i.getUnidade());
				obj.put("preco", i.getPreco());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			records.add(obj.toString());
		}
	}
}
