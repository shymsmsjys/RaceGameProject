package application;
import java.util.Scanner;

public class GameManager extends Thread {
	private static int MAX_PLAYER =4;
	private Player[] players;
	Scanner sc = new Scanner(System.in);
	private int playerNum = 0;
	
	public GameManager() {
		setup();
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

			//for (Player player : players) {
				for (int i = 0; i < players.length; i++) {
				
					if (players[i].isRunning()) {
						players[i].dice();
						
//						if (players[i].getHorse().getLocation() > 30) {
//							players[i].setFinish();
//						}
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
	
//	public Player[] getPlayer() {
//		return player;
//	}

}
