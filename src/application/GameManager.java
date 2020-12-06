/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description: GameManager generally manages all classes and details. GameManager will interact with GUI.
 * Significant Methods/Attributes:
 * setup(): create players and assign one horse for each player
 * run(): run the dice rolling game and move the horse
 * gameOver(): See every player's horse crossed the finish line. End game.
 * 
 */
package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameManager extends Thread {
	private Player[] players;
	private Main main;// = new Main();
	int playerNum = 0;
	int[] obstacleLocation = new int [8]; 
	int[] boostLocation = new int [8];
	
	public GameManager(int playerNum, String[] playersName) {
		this.playerNum  = playerNum;
		setup(playersName);
		Obstacles();
		boostTiles();
	}
		
	// setup location to Starting Line, get name and number of players
	public void setup(String[] name) {
		players = new Player[playerNum];
		
		for (int i = 0; i < players.length; i++) {
//			players[i] = new Player(i);
			int SkillNum;
			SkillNum = randomFrom(1,4);
			if (SkillNum == 1) {
				players[i] = new RocketMan(i, name[i]);
				
			}
			else if (SkillNum == 2) {
				players[i] = new Invisible(i, name[i]);
			}
			
			else if (SkillNum == 3) {
				players[i] = new Unstoppable(i, name[i]);
			}
		}
		


		
	}
	
	int[] ranking = new int[5] ;
	int index =1;
	// one turn, one throw dice and move the horses
/*	public void run() {
		File file = new File("Ranking Table.txt");
		FileWriter fw;
		BufferedWriter bf = null;;
		try {
			fw = new FileWriter(file);
			bf = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		while(!gameOver()) {
			
				for (int i = 0; i < players.length; i++) {
				
					if (players[i].isRunning()) {
						if (players[i].getatObstacle() == true) {
							players[i].Obstacle(false);
							System.out.println("players"+i + " is out of obstacle now");
							continue;
						}
						
						players[i].dice();
						if (!players[i].isRunning()) {
							String str = "Ranking" +index+":player"+i + ", " + players[i].getName();
							System.out.println(str);
							index++;
//							FileIO();
							try {
								bf.write(str);
								bf.newLine();
//								bf.write("Ranking" +index+":player"+i);
//								bf.newLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							}
						
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
		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	private int mNextPlayerId = 0;
	private int mCurrentPlayerId = 0;
	
	public void nextDice() {
	
		File file = new File("Ranking Table.txt");
		FileWriter fw;
		BufferedWriter bf = null;;
		try {
			fw = new FileWriter(file);
			bf = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (players[mNextPlayerId].isRunning()) {
			if (players[mNextPlayerId].getatObstacle() == true) {
				players[mNextPlayerId].Obstacle(false);
				System.out.println( players[mNextPlayerId].getName() + " is out of obstacle now");
				 return;
			}
			
			players[mNextPlayerId].dice();
			mCurrentPlayerId = mNextPlayerId;
			if (!players[mNextPlayerId].isRunning()) {
				String str = "Ranking" +index+":player"+ mNextPlayerId + ", " + players[mNextPlayerId].getName();
				System.out.println(str);
				index++;
//				FileIO();
				try {
					bf.write(str);
					bf.newLine();
				bf.write("Ranking" +index+":player"+ mNextPlayerId);
				bf.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			
			for (int i = 0; i < boostLocation.length; i++) {
			
				if (players[mNextPlayerId].getHorse().getLocation() == boostLocation[i]) {
					players[mNextPlayerId].Boost();
			}
			}
			
			for (int i = 0; i < obstacleLocation.length; i++) {
				if (players[mNextPlayerId].getHorse().getLocation() == obstacleLocation[i]) {
					players[mNextPlayerId].Obstacle(true);
			}
			
			
			}
			for (int j = 0; j < players.length; j++) {
				//
				if(j == mNextPlayerId) {
					continue;
				}
				if (players[mNextPlayerId].getHorse().getLocation() == players[j].getHorse().getLocation()) {
					players[j].Caught();
				}	
			}
			
			try {
				bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		//mCurrentPlayerId++;
		setNextPlayerId();
		
	}
	
	private void setNextPlayerId() {
		if (++mNextPlayerId >= players.length) {
			mNextPlayerId = 0;
		}
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
	
	public Player[] getPlayers() {
		return players;
	}
	
	
	public Player getCurrentPlayer() {
		return players[mCurrentPlayerId];
	}
	
	public int getPlayerNumber() {
		return playerNum;
	}
	
	public void Obstacles() {
		
		for (int i = 0; i < obstacleLocation.length; i++) {
		
			obstacleLocation[i] = randomFrom(1, 60);
			System.out.println("Obstacle tile is at " + obstacleLocation[i]);
		}
		
	}
	
	public void boostTiles() {
		for (int i = 0; i < boostLocation.length; i++) {
			boostLocation[i] = randomFrom(1, 60);
			System.out.println("Boost tile is at "+ boostLocation[i]);
		}
	}
	
	public int[] getObstacles() {
		return obstacleLocation;
	}
	
	public int[] getBoostTiles() {
		return boostLocation;
	}
	
	
}
