/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description:
 * Significant Methods/Attributes:

 */
package application;

public class RocketMan extends Player{

	
	public RocketMan(int id, String name) {
		super(id, name);
		System.out.println("player"+id+ ":" + name + " is assigned with Rocketman skill");
		// TODO Auto-generated constructor stub
	}

	//Player with rocketman skill, horses shall multiply boost tile number by 1.5 fore extra move

	@Override
	public int Boost() {
		int num;
		int extraNum;
		num = randomFrom(2, 5);
		extraNum = (int) (num * 1.5);
		System.out.println(extraNum-num + " is moved extra with Rocektman Skill (boost tile number: "+num+")");
		horse.updateLocation(num);
		return location;
		
	}
	// Round up the value of move to integar
	public int roundUp(double num) {
		Math.round(num);
		return (int) num;
	}
}
