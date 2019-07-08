package it.polito.tdp.food.db;

public class Food {
	private Integer food_id;
	private Integer food_code;
	private String display_name;
	private Integer portion_default;
	private Double portion_amount;
	private String portion_display_name;
	private Double calories;
	
	public Food(Integer food_id, Integer food_code, String display_name, Integer portion_default, Double portion_amount,
			String portion_display_name, Double calories) {
		super();
		this.food_id = food_id;
		this.food_code = food_code;
		this.display_name = display_name;
		this.portion_default = portion_default;
		this.portion_amount = portion_amount;
		this.portion_display_name = portion_display_name;
		this.calories = calories;
	}
	
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
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
	public Integer getPortion_default() {
		return portion_default;
	}
	public void setPortion_default(Integer portion_default) {
		this.portion_default = portion_default;
	}
	public Double getPortion_amount() {
		return portion_amount;
	}
	public void setPortion_amount(Double portion_amount) {
		this.portion_amount = portion_amount;
	}
	public String getPortion_display_name() {
		return portion_display_name;
	}
	public void setPortion_display_name(String portion_display_name) {
		this.portion_display_name = portion_display_name;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_code=" + food_code + ", display_name=" + display_name
				+ ", portion_display_name=" + portion_display_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((food_id == null) ? 0 : food_id.hashCode());
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
		Food other = (Food) obj;
		if (food_id == null) {
			if (other.food_id != null)
				return false;
		} else if (!food_id.equals(other.food_id))
			return false;
		return true;
	}
	
	
	
	
}
