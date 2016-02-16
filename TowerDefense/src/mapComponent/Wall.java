package mapComponent;

import java.util.List;

import entities.Character;
import entities.Entity;

/**
 * This class represent a wall in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Wall implements Case{
	//ATTRIBUTS
	private int x, y;
	
	//METHODS
	/** Constructor
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Wall(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/** {@inheritDoc}*/
	public boolean canPass(Character character) {return false;}

	/** {@inheritDoc}*/
	public int getX() {return x;}

	/** {@inheritDoc}*/
	public int getY() {return y;}

	/** {@inheritDoc}*/
	public List<Character> getListCharacter(){return null;}

	/** {@inheritDoc}*/
	public void addCharacter(Character character) {}

	/** {@inheritDoc}*/
	public void removeCharacter(Character character) {}
}
