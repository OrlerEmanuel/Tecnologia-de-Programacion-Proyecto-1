package proyecto_1;

public class OperatingSystem {
	protected String name;
	protected int id;
	
	public OperatingSystem(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	//Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}