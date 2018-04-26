package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "ingredients")
	private String ingredients;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private float price;
	public Medication() {
		
	}
	public Medication(String name, String manufacturer, String ingredients, int quantity, float price) {
		this.name = name;
		this.manufacturer=manufacturer;
		this.ingredients=ingredients;
		this.quantity=quantity;
		this.price=price;
	}
	public Medication(int id,String name, String manufacturer, String ingredients, int quantity, float price) {
		this.id=id; 
		this.name = name;
		this.manufacturer=manufacturer;
		this.ingredients=ingredients;
		this.quantity=quantity;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() { 
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String toString() {
		return "Medication: " + "Id:" +  this.id+",  " + "Name:" +this.name+",  " + "Manufacturer:" + this.manufacturer+",  "+"Ingredients: " + this.ingredients+",  " + "Quantity: "+ this.quantity+",  "+"Price: "+this.price;
	}
}
