package application;

public class Player {
	
	int [][] location;
	private String name;
	private  int id;
	SpecialSkills specialSkills = new SpecialSkills();
	Horse horse = new Horse();
	
	public Player(String inputName) {
		
		//set name to inputed name
		name = inputName;
	}
	
	
	public int dice() {
		int dice = 0;
		int low = 1;
		int high = 6;
		dice = (int) (Math.random()*(high-low) + low);
		
		return dice; 
	}
	
	
	public int[][] calculateLocation () {
		// set Horse's location
		return location;
	}
	

	
}
