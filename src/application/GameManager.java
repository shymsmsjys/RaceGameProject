/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 6th, 2020
 */
package application;
import java.util.Scanner;

public class GameManager extends Thread {
	private static int MAX_PLAYER =4;
	private Player[] players;
	int boostLocation0 = 0;
	int boostLocation1 = 0;
	int obstacleLocation0 = 0;
	int obstacleLocation1 = 0;
	
	public GameManager() {
		setup();
			boostLocation0 = randomFrom(1, 20);
			System.out.println("Boost tile is at "+boostLocation0);
			boostLocation1 = randomFrom(1, 20);
			System.out.println("Boost tile is at "+boostLocation1);
			obstacleLocation0 = randomFrom(1, 20);
			System.out.println("Obstacle tile is at " + obstacleLocation0);
			obstacleLocation1 = randomFrom(1, 20);
			System.out.println("Obstacle tile is at " + obstacleLocation1);
	}
		
	// setup location to Starting Line, get name and number of players
	public void setup() {
		players = new Player[MAX_PLAYER];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
		}

		
	}
	// one turn, one throw dice and move the horses
	public void run() {
		while(!gameOver()) {
			
				for (int i = 0; i < players.length; i++) {
				
					if (players[i].isRunning()) {
						if (players[i].getatObstacle() == true) {
							players[i].Obstacle(false);
							System.out.println("players"+i + "is out of obstacle now");
							continue;
						}
						
						players[i].dice();
						
						if (players[i].getHorse().getLocation() == boostLocation1 || players[i].getHorse().getLocation() == boostLocation0) {
							players[i].Boost();
						}
						if (players[i].getHorse().getLocation() == obstacleLocation1 || players[i].getHorse().getLocation() == obstacleLocation0) {
							players[i].Obstacle(true);
						
						}
						for (int j = 0; j < players.length; j++) {
							//
							if(j == i) {
								continue;
							}
							if (players[i].getHorse().getLocation() == players[j].getHorse().getLocation()) {
								players[j].Caught();
							}	
						}
						
					}
				
				}
						
				
		}
		System.out.println("game is over");
	}
		
	public boolean gameOver() {
	
		for (int i = 0; i < players.length; i++) {
			if (players[i].isRunning()) {
				return false;
			}
		}
		return true;
	}
	
	public int randomFrom (int low, int high) {

		int randNum = 0;

		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}
	
	
//	public Player[] getPlayer() {
//		return player;
//	}

}
