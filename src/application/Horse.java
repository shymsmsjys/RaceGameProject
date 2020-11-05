package application;

public class Horse {
	int id;
	
	private int location;
	String color;

	public Horse(int id) {
		this.id = id;
		System.out.println("horse " + id + " is created");
	}
	
	public int getLocation(){

		return location;
	}
	public  void setLocation(int location) {
		this.location = location;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void updateLocation(int num) {
		location += num;
		System.out.println("horse location is "+ location);
	}
}
