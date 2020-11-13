/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 6th, 2020
 */
package application;

public class Player {
	
	int location;
	private String name;
	private  int id;
	SpecialSkills specialSkills = new SpecialSkills();
	Horse horse;
	boolean isRunning = true;
	boolean atObstacle = false;
	
	// shortcut variables
	static int PATH_FULL = 0;
	static int PATH_1 = 1;
	static int PATH_2 = 2;
	static int PATH_3 = 3;
	private int path = PATH_FULL;
	private int goal[] = {20, 16, 11, 16};
	
	public Player(int id) {
		
		//set name to inputed name
		this.id = id;
		System.out.println("player" +id+ "is created" );
		horse = new Horse(id);
	}
	
	// dice ranging from 1 to 6
	public void dice() {
		int dice = 0;
		int low = 1;
		int high = 6;
		dice = (int) (Math.random()*(high-low) + low);
		 
		System.out.println("\nplyaer" +id + " rolled dice " + dice);
		shortCut(dice);
		check();
	}
	
	
	public void shortCut (int num) {
		// set Horse's location
		horse.updateLocation(num);
		
		if (path == PATH_FULL ) {
			if (horse.getLocation() == 5) {
				path = PATH_1;
				System.out.println("Path changed to Path1");
			}
			else if (horse.getLocation() == 10) {
				path = PATH_3;
				System.out.println("Path changed to Path3");
			}
		}
		else if (path == PATH_1) {
			if (horse.getLocation() == 8) {
				path = PATH_2;
				System.out.println("Path changed to Path2");
			}
		}
		
	}
	// Horse caught and go to starting line
	public void Caught() {
		horse.setLocation(0);
		
	}
	// Boost tile number give extra move to Horse
	public int Boost() {;
		int num;
		num = randomFrom(2, 5);
		System.out.println(num + " boost tile increased the speed!!");
		horse.updateLocation(num);
		return location;
	}
	// Make player one turn skip
	public void Obstacle(boolean on) {

		atObstacle = on;
		System.out.println("You are trapped at the obstacle. Skip one turn");
		
		
		
	}
	// Check the state of horse finish or not
	private void check() {
		if (horse.getLocation() > goal[path]) {
			setFinish();
			System.out.println("Player" + id + " is finished");
		}
	}
	//  still running?
	public boolean isRunning() {
		return isRunning;
	}
	public void setFinish() {
		isRunning = false;
	}
	
	public Horse getHorse() {
		return horse;
	}
	
	public int randomFrom (int low, int high) {

		int randNum = 0;

		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}
	
	public boolean getatObstacle() {
		return atObstacle;
	}
	
}
