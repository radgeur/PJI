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
	
	/** Return the x coordinate of the case in pixel. 
	 * @return x coordinate of the case in pixel
	 */
	public int getXInPixel();
	
	/** Return the y coordinate of the case in pixel. 
	 * @return y coordinate of the case in pixel.
	 */
	public int getYInPixel();
	
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

	/**
	 * Indicates if the case is a wall or not.
	 * @return true if the case is a wall, else return false 
	 */
	public boolean isWall();

	/**
	 * Remove a entity on the case.
	 * @param entity
	 */
	public void removeEntity(Entity entity);
	
	public int getPathFindingNexus();
	
	public void setPathFindingNexus(int pathfinding);
	
	public int getPathFindingDefence();
	
	public void setPathFindingDefence(int pathfinding);
	
}
