package entities;

/**
 * Class to instantiate a Character Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy
 * 
 */

public class Character extends Entity{

	/** {@inheritDoc}*/
	public Character(int HP, int width, int height, int range, int power, boolean isFriendly) {
		super(HP, width, height, range, power, isFriendly);
	}

	@Override
	public boolean isDefense() {
		return false;
	}
}
