package mapComponent;

import entities.Entity;

/**
 * This class represent a case in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public interface Case {

	/**
	 * Method to know if an entity can pass or not in this case.
	 * @param entity 
	 * @return true if the entity can pass in the case, else false.
	 */
	public boolean canPass(Entity entity);
	
	/**
	 * This method return the x coordinate of the case. 
	 * @return the x coordinate of the case
	 */
	public int getX();
	
	/**
	 * This method return the y coordinate of the case. 
	 * @return the y coordinate of the case
	 */
	public int getY();
	
	
}
