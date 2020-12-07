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
	int[] obstacleLocation = new int [3]; 
	int[] boostLocation = new int [3];
	File file;
	FileWriter fw;
	BufferedWriter bf = null;
	
	public GameManager(int playerNum, String[] playersName) {
		this.playerNum  = playerNum;
		setup(playersName);
		Obstacles();
		boostTiles();
		file = new File("Ranking Table.txt");
		try {
			fw = new FileWriter(file);
			bf = new BufferedWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	private int mNextPlayerId = 0;
	private int mCurrentPlayerId = 0;
	
	public void nextDice() {
		if(gameOver()) {
			try {
				if (bf != null) {
					bf.close();
					bf = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
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
				System.out.println("ranking");
				String str = "Ranking" + index + ":player" + mNextPlayerId + ", " + players[mNextPlayerId].getName();
				System.out.println(str);
				index++;
//				FileIO();
				try {
					bf.write(str);
					bf.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (int i = 0; i < boostLocation.length; i++) {
			
				if (players[mNextPlayerId].getHorse().getLocation() == boostLocation[i]) {
					if(players[mNextPlayerId].getPath() == 0) {
						players[mNextPlayerId].Boost();
					}
				}
			}
			
			for (int i = 0; i < obstacleLocation.length; i++) {
				int playerLocation = players[mNextPlayerId].getHorse().getLocation();
				if (players[mNextPlayerId].getPath() == 3 && playerLocation > 30) {
					playerLocation -= 15;
				}
				if (playerLocation == obstacleLocation[i]) {
					if (playerLocation >= 15 || playerLocation <= 23) {
						if(players[mNextPlayerId].getPath() == 2
								|| players[mNextPlayerId].getPath() == 1) {
									players[mNextPlayerId].Obstacle(true);
								}
					} else {
						if(players[mNextPlayerId].getPath() == 2) {
							players[mNextPlayerId].Obstacle(true);
						}
					}
				}
			}
			for (int j = 0; j < players.length; j++) {
				//
				if(j == mNextPlayerId) {
					continue;
				}
				if(players[j].isRunning) {
					if (players[mNextPlayerId].getHorse().getLocation() == players[j].getHorse().getLocation()) {
						if(players[mNextPlayerId].getPath() == players[j].getPath()) {
							players[j].Caught();
						}
					}	
				}
				
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
		
			obstacleLocation[i] = randomFrom(15, 31);
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
