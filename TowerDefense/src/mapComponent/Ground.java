package mapComponent;

import java.util.ArrayList;
import java.util.List;

import entities.Character;
import entities.Defence;



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
	
	//METHODS
	public Ground(int x, int y){
		this.x = x;
		this.y = y;
		listCharacter = new ArrayList<Character>();
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

	public int getX() {return x;}

	public int getY() {return y;}

	/**
	 * This method return the list of character on this case.
	 * @return the list of character on this case.
	 */
	public List<Character> getListCharacter(){
		return listCharacter;
	}
	
}
