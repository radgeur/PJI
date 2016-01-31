package mapComponent;

import entities.Character;

/**
 * This class represent a case in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public interface Case {

	/**
	 * To know if a Character can pass or not in this case.
	 * @param entity to compare
	 * @return true if the entity can pass on the case, else false.
	 */
	public boolean canPass(Character character);
	
	/** Return the x coordinate of the case. 
	 * @return x coordinate of the case
	 */
	public int getX();
	
	/** Return the y coordinate of the case. 
	 * @return y coordinate of the case
	 */
	public int getY();
	
	
}
