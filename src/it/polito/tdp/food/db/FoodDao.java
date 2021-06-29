package it.polito.tdp.food.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.food.model.Adiacenti;



public class FoodDao {

	public List<Food> listAllFood(){
		String sql = "SELECT * FROM food" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Food> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					list.add(new Food(res.getInt("food_id"),
							res.getInt("food_code"),
							res.getString("display_name"), 
							res.getInt("portion_default"), 
							res.getDouble("portion_amount"),
							res.getString("portion_display_name"),
							res.getDouble("calories")
							));
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
	public List<Condiment> listAllCondiment(){
		String sql = "SELECT * FROM condiment" ;
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Condiment> list = new ArrayList<>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					list.add(new Condiment(res.getInt("condiment_id"),
							res.getInt("food_code"),
							res.getString("display_name"), 
							res.getString("condiment_portion_size"), 
							res.getDouble("condiment_calories")
							));
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();
			return list ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}
	
	public void listIngredienti(double cal,Map<Integer,Condiment> mappa){
		String sql = "SELECT DISTINCT * "
				+ "FROM condiment "
				+ "WHERE condiment_calories < ? ";
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			
			st.setDouble(1, cal);
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					Condiment c = new Condiment(res.getInt("condiment_id"),
							res.getInt("food_code"),
							res.getString("display_name"), 
							res.getString("condiment_portion_size"), 
							res.getDouble("condiment_calories")
							);
					if(!mappa.containsKey(c.getCondiment_id())) {
						
						mappa.put(c.getCondiment_id(), c);
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Adiacenti> getArchi(Map<Integer,Condiment> mappa, double cal){
		String sql = "SELECT c1.condiment_id, c2.condiment_id, COUNT(distinct fc1.food_code) AS peso "
				+ "FROM (SELECT * "
				+ "	FROM condiment "
				+ "	WHERE condiment_calories < ?) AS c1, "
				+ "	(SELECT * "
				+ "	FROM condiment "
				+ "	WHERE condiment_calories < ?) AS c2, "
				+ "	food_condiment fc1, food_condiment fc2 "
				+ "WHERE c1.condiment_id > c2.condiment_id and "
				+ "fc1.condiment_food_code = c1.food_code AND  "
				+ "fc2.condiment_food_code = c2.food_code "
				+ "GROUP BY c1.condiment_id, c2.condiment_id";
		List<Adiacenti> result = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setDouble(1, cal);
			st.setDouble(2, cal);
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				try {
					Condiment c1 = mappa.get(res.getInt("c1.condiment_id"));
					Condiment c2 = mappa.get(res.getInt("c2.condiment_id"));
					if(c1 != null && c2 != null) {
						result.add(new Adiacenti(c1,c2, res.getInt("peso")));
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
