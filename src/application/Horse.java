/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 6th, 2020
 */
package application;

public class Horse {
	int id;
	
	private int location;
	String color;

	// Pass horse id
	public Horse(int id) {
		this.id = id;
		System.out.println("horse " + id + " is created");
	}
	
	public int getLocation(){

		return location;
	}
	public  void setLocation(int location) {
		this.location = location;
		System.out.println("horse " + id + " setLocation " + this.location);
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
