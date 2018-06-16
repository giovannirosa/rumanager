package controller.database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Ing;
import model.Model;
import model.Rec;
import view.utils.Factory;

public class RecDB extends Database {
	
	public RecDB() {
		table = "rec";
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
				JSONArray arr = obj.getJSONArray("lista");
				List<Ing> list = new ArrayList<Ing>();
				for(int i = 0; i < arr.length(); i++) {
					int id = arr.getJSONObject(i).getInt("id");
					String nome = arr.getJSONObject(i).getString("nome");
					int qtde = arr.getJSONObject(i).getInt("qtde");
					String unidade = arr.getJSONObject(i).getString("unidade");
				    list.add(new Ing(id, nome, qtde, unidade));
				}
				map.put(obj.getInt("id"), new Rec(obj.getInt("id"), obj.getString("nome"),
						obj.getString("modo"), obj.getInt("porc"), obj.getInt("calor"), list));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void set(Map<Integer, Model> map) {
		records.clear();
		
		for (Model m : map.values()) {
			Rec r = (Rec) m;
			JSONObject obj = new JSONObject();
			
			try {
				obj.put("id", r.getId());
				obj.put("nome", r.getNome());
				obj.put("modo", r.getModoPreparo());
				obj.put("porc", r.getNoPorcoes());
				obj.put("calor", r.getValorCalorico());
				
				JSONArray array = new JSONArray();
				for (Ing i : r.getListaIngrediente()) {
					JSONObject ingJson = new JSONObject();
					ingJson.put("id", i.getId());
					ingJson.put("nome", i.getNome());
					ingJson.put("qtde", i.getQtde());
					ingJson.put("unidade", i.getUnidade());
					array.put(ingJson);
				}
				
				obj.put("lista", array);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			records.add(obj.toString());
		}
	}
}
