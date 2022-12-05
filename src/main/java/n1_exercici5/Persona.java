package n1_exercici5;

import java.io.Serializable;

public class Persona implements Serializable {

	private String name;
	private String lastName;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Persona(String name, String lastName, int id) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Persona [name=" + name + ", lastName=" + lastName + ", id=" + id + "]";
	}

	
	
}
