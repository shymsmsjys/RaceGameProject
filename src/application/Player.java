/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description: Contains characteristics of player and board.
 * Significant Methods/Attributes: 
 * dice(): roll dice from 1 to 6. 
 * shortCut(): If the horse is at certain location, allow horse to use shorter route.
 * Caught(): set horse to zero location in a certain condition
 * Boost(): create boost tile and let horse make extra move based on the boost tile number
 * obstacle(): find out horse is on obstacle or not.
 */
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Player {
	
	int location;
	private String name;
	private  int id;
	Horse horse;
	boolean isRunning = true;
	boolean atObstacle = false;
	int SkillNum;
	// shortcut variables
	static int PATH_FULL = 0;
	static int PATH_1 = 1;
	static int PATH_2 = 2;
	static int PATH_3 = 3;
	private int path = PATH_FULL;
	private int goal[] = {60, 46, 31, 46};
	
	public Player(int id, String name) {
		
		//set name to inputed name
		this.id = id;
		this.name = name;
		System.out.println("player" +id+ ": " + name +" is created" );
		horse = new Horse(id);
	}
	
	// dice ranging from 1 to 6
	public void dice() {
		int dice = 0;
		int low = 1;
		int high = 6;
		dice = (int) (Math.random()*(high-low) + low);
		 
		System.out.println("\n" + name + " rolled dice " + dice);
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
		System.out.println("Player" + id +": "+ name + " is caught. Go to starting line");
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
	public void check() {
		if (horse.getLocation() > goal[path]) {
			setFinish();
			System.out.println("Player" + id + ": "+ name + " is finished");
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
