package it.polito.tdp.food.db;


public class TestDao {

	public static void main(String[] args) {
		FoodDao dao = new FoodDao();
		
		System.out.println(dao.listAllFood());
		System.out.println(dao.listAllCondiment());

	}

}
