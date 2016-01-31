package entities;

/**
 * Class to instantiate a Defence Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class Defence extends Entity{

	/** {@inheritDoc}*/
	public Defence(int HP, int width, int height, int range, int power, boolean isFriendly) {
		super(HP, width, height, range, power, isFriendly);
	}
	
}
