package application;

public class Boost extends Board{
	
	// Horses on the boost tile move additional spaces depending on the number of boost tile
	@Override
	public void move(boolean condition) {
		
	}
	
	// Boost items are randomly located on the board
	public int[][] randomlocation (int low, int high) {

		return board;
	}
	
	// Boost item number varies from 1 to 6
	public int randomFrom () {

		int randNum = 0;
		int low = 1;
		int high = 6;

		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}

}
