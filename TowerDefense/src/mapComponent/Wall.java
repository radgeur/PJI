package mapComponent;

import java.util.List;
import java.util.TreeMap;

import entities.Character;
import entities.Defence;
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
	
	@Override
	public boolean canPass(Character character) {return false;}

	@Override
	public boolean hasDefence(){return false;}
	
	@Override
	public int getX() {return x;}

	@Override
	public int getY() {return y;}
	

	@Override
	public int getXInPixel() {return x * Map.casewidth;}

	@Override
	public int getYInPixel() {return y * Map.caseHeight;}

	@Override
	public List<Character> getListCharacter(){return null;}

	@Override
	public void addCharacter(Character character) {}

	@Override
	public void removeCharacter(Character character) {}

	@Override
	public boolean isWall() {return true;}

	@Override
	public void removeEntity(Entity entity) {}

	@Override
	public int getPathFindingNexus() {return -1;}

	@Override
	public void setPathFindingNexus(int pathfinding) {}

	@Override
	public TreeMap<Integer, List<Defence>> getPathFindingDefence() {
		return null;
	}

	@Override
	public void setPathFindingDefence(int key, Defence value) {}
	
	@Override
	public int getClosestPathFindingDefence(){return -1;}

	@Override
	public Defence getDefence() {return null;}
	
	public void putDefence(Defence defence) {}
	
	public boolean canPut(){return false;}
}
