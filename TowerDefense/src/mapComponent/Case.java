package mapComponent;

import java.util.List;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entities.Character;
import entities.Defence;
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
	
	/**
	 * Check if there is already a defence on the case.
	 * @return true if there is a defence on the case.
	 */
	public boolean hasDefence();
	
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

	/** Indicates if the case is a wall or not.
	 * @return true if the case is a wall, else return false 
	 */
	public boolean isWall();

	/** Remove an entity of the current case.
	 * @param entity
	 */
	public void removeEntity(Entity entity);
	
	/** return the distance from the nexus to the current case
	 * @return int distance to the nexus
	 */
	public int getPathFindingNexus();
	
	/** update the distance of the current case of the nexus
	 * @param pathfinding the distance to the nexus
	 */
	public void setPathFindingNexus(int pathfinding);
	
	/** Return the treeMap with the defence that are in the catchArea with their distance
	 * @return TreeMap
	 */
	public TreeMap<Integer, List<Defence>> getPathFindingDefence();
	
	/** Update the treeMap with the defence
	 * @param key the distance
	 * @param value the defence
	 */
	public void setPathFindingDefence(int key, Defence value);
	
	/** Return the distance to the closest defence
	 * @return int the distance to the closest defence
	 */
	public int getClosestPathFindingDefence();
	
	/** Return the defence present on this case 
	 * @return the defence present on this case
	 */
	public Defence getDefence();
	
	/** Put defence on the case
	 * @param defence to pu on the case
	 */
	public void putDefence(Defence defence);
	
	/** Know if we can put a defence on the case
	 * @return true if can, else false
	 */
	public boolean canPut();
	
	/** return the picture of the case
	 * @return picture
	 */
	public ImageIcon getPicture();
	
	/** Set the picture of the case
	 * @param picture new
	 */
	public void setPicture(ImageIcon picture);
	
	/** return the label of the case
	 * @return label
	 */
	public JLabel getLabel();
	
}
