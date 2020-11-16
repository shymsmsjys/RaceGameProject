/* Name: Seongkwan Son
 * Section: 01 DB
 * Date Created: Nov 2nd, 2020
 * Date Modifed: Nov 13th, 2020
 * Description:
 * Significant Methods/Attributes:

 */
package application;

public class Invisible extends Player {
	
	
	public Invisible(int id) {
		super(id);
		System.out.println("player"+id+ " is assigned with Invisible skill");
		
	}

	// Player with invisible skill, horses shall not start over after capture
	@Override
	public void Caught() {
		System.out.println("Horse is invisible!");
	}
	
	

}
