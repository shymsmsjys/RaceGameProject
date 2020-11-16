/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description:
 * Significant Methods/Attributes:

 */
package application;

public class Unstoppable extends Player{
	boolean off = false;
	public Unstoppable(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		System.out.println("player"+id+ " is assigned with Unstoppable skill");
	}
	
	@Override
	public void Obstacle(boolean off) {
		System.out.println("Unstoppable!! No skip");
	}

	//Player with unstoppable skill would not skip one turn on the obstacle 



}
