package application;

public class Player {
	
	int location;
	private String name;
	private  int id;
	SpecialSkills specialSkills = new SpecialSkills();
	Horse horse;
	boolean isRunning = true;
	
	public Player(int id) {
		
		//set name to inputed name
		this.id = id;
		System.out.println("player" +id+ "is created" );
		horse = new Horse(id);
	}
	
	
	public void dice() {
		int dice = 0;
		int low = 1;
		int high = 6;
		dice = (int) (Math.random()*(high-low) + low);
		horse.updateLocation(dice); 
		System.out.println("plyaer" +id + " rolled dice " + dice);
	}
	
	
	public void updateLocation (int num) {
		// set Horse's location
		
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	public void setFinish() {
		isRunning = false;
	}
	
	public Horse getHorse() {
		return horse;
	}

	
}
