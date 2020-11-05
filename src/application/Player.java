package application;

public class Player {
	
	int location;
	private String name;
	private  int id;
	SpecialSkills specialSkills = new SpecialSkills();
	Horse horse;
	boolean isRunning = true;
	
	static int PATH_FULL = 0;
	static int PATH_1 = 1;
	static int PATH_2 = 2;
	static int PATH_3 = 3;
	private int path = PATH_FULL;
	private int goal[] = {20, 16, 11, 16};
	
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
		 
		System.out.println("\nplyaer" +id + " rolled dice " + dice);
		updateLocation(dice);
		check();
	}
	
	
	public void updateLocation (int num) {
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
	
	private void check() {
		if (horse.getLocation() > goal[path]) {
			setFinish();
			System.out.println("Player" + id + " is finished");
		}
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
