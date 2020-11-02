package application;

public class RocketMan extends SpecialSkills{

	//Player with rocketman skill, horses shall multiply boost tile number by 1.5 fore extra move
	@Override
	public void move(boolean condition) {
		
	}
	
	// Round up the value of move to integar
	public int roundUp(double num) {
		Math.round(num);
		return (int) num;
	}
}
