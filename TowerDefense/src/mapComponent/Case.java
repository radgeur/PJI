package mapComponent;

import java.util.List;

import entities.Character;
import entities.Entity;

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
	
	/**
	 * This method return the list of character on this case.
	 * @return the list of character on this case.
	 */
	public List<Character> getListCharacter();
	
	/** Add an entity on the Case
	 * @param entity to add on the Case
	 */
	public void addCharacter(Character character);
	
	/** Remove the entity of the Case
	 * @param entity to remove of the Case
	 */
	public void removeCharacter(Character character);
	
}
