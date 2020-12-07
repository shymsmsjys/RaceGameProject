/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description: contains feature of horse
 * Significant Methods/Attributes:

 */
package application;

public class Horse {
	int id;
	
	private int location;

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
	}
	
	public void updateLocation(int num) {
		location += num;
		if(location >= 61) {
			location = 61;
		}
		System.out.println("horse location is "+ location);
	}
}
