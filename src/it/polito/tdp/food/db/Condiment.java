package it.polito.tdp.food.db;

public class Condiment {
	private Integer condiment_id;
	private Integer food_code;
	private String display_name;
	private String condiment_portion_size;
	private Double condiment_calories;
	
	public Condiment(Integer condiment_id, Integer food_code, String display_name, String condiment_portion_size,
			Double condiment_calories) {
		super();
		this.condiment_id = condiment_id;
		this.food_code = food_code;
		this.display_name = display_name;
		this.condiment_portion_size = condiment_portion_size;
		this.condiment_calories = condiment_calories;
	}
	
	public Integer getCondiment_id() {
		return condiment_id;
	}
	public void setCondiment_id(Integer condiment_id) {
		this.condiment_id = condiment_id;
	}
	public Integer getFood_code() {
		return food_code;
	}
	public void setFood_code(Integer food_code) {
		this.food_code = food_code;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getCondiment_portion_size() {
		return condiment_portion_size;
	}
	public void setCondiment_portion_size(String condiment_portion_size) {
		this.condiment_portion_size = condiment_portion_size;
	}
	public Double getCondiment_calories() {
		return condiment_calories;
	}
	public void setCondiment_calories(Double condiment_calories) {
		this.condiment_calories = condiment_calories;
	}

	@Override
	public String toString() {
		return condiment_id + " - "+ display_name + " ("
				+ condiment_calories + " cal)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condiment_id == null) ? 0 : condiment_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condiment other = (Condiment) obj;
		if (condiment_id == null) {
			if (other.condiment_id != null)
				return false;
		} else if (!condiment_id.equals(other.condiment_id))
			return false;
		return true;
	}
	
	
	
}
