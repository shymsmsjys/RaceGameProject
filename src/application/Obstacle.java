package application;

public class Obstacle extends Board{
	
	
	// Obstacle makes horses skip one turn
	@Override
	public void move(boolean condition) {
		
	}

	// Obstacles are randomly located on the board
	public int[][] randomlocation () {

		return board;
	}
}
