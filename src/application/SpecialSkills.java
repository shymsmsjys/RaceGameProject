package application;

public class SpecialSkills {
	boolean condition;

	
	public void move (boolean condition) {
		
	}
	
	public int randomFrom (int low, int high) {

		int randNum = 0;

		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}

	public void randomAssign (int player[]) {
		
		for (int i = 0; i < player.length; i++) {
			
		}
	}
}

