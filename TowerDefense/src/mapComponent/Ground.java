package mapComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import entities.Character;
import entities.Defence;
import entities.Entity;



/**
 * This class represent a ground case in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Ground implements Case{

	//ATTRIBUTS
	private Defence defence;
	private List<Character> listCharacter;
	private int x,y;
	private int nexusDistance;
	private TreeMap<Integer, List<Entity>> defencesDistance;
	
	//METHODS
	public Ground(int x, int y){
		this.x = x;
		this.y = y;
		listCharacter = new ArrayList<Character>();
		nexusDistance = -1;
		this.defencesDistance =  new TreeMap<Integer, List<Entity>>();
	}
	
	/** If a character could or not go throw this case
	 * @param character 
	 * @return if there is no defence on this case then true else false
	 */
	public boolean canPass(Character caracter) {
		if(!hasDefence())
			return true;
		return !defence.isOpponent(caracter);
	}
	
	/**
	 * Indicate if a defence can be place on the case.
	 * @param defence
	 * @return true if a defence can be place on the case.
	 */
	public boolean canPut(Defence defence){
		return this.defence == null;
	}
	
	/**
	 * indicate if there is a defence on the case.
	 * @return true if there is a defence on the case.
	 */
	public boolean hasDefence(){
		return defence != null;
	}
	
	/**
	 * Put a defence on this case.
	 * @param d
	 */
	public void putDefence(Defence d){
		if(canPut(d))
			this.defence = d;
	}

	/** {@inheritDoc}*/
	public int getX() {return x;}

	/** {@inheritDoc}*/
	public int getY() {return y;}

	/** {@inheritDoc}*/
	public List<Character> getListCharacter() {return listCharacter;}

	/** {@inheritDoc}*/
	public void addCharacter(Character character) {
		listCharacter.add(character);
	}

	/** {@inheritDoc}*/
	public void removeCharacter(Character character) {
		listCharacter.remove(character);
	}

	@Override
	public boolean isWall() {
		return false;
	}

	@Override
	public void removeEntity(Entity entity) {
		if(entity.isDefense())
			defence = null;
		else 
			listCharacter.remove(entity);
	}

	@Override
	public int getPathFindingNexus() {
		return nexusDistance;
	}

	@Override
	public void setPathFindingNexus(int pathfinding) {
		this.nexusDistance = pathfinding;
	}

	@Override
	public TreeMap<Integer, List<Entity>> getPathFindingDefence() {
		return defencesDistance;
	}

	@Override
	public void setPathFindingDefence(TreeMap<Integer, List<Entity>> pathfinding) {
		this.defencesDistance = pathfinding;
	}
	
	
	
}
