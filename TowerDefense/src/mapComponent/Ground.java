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

	private Defence defence;
	
	private List<Character> listCharacter;
	
	private int x,y;
	
	public Ground(int x, int y){
		this.x = x;
		this.y = y;
		listCharacter = new ArrayList<Character>();
	}
	
	
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Character> getListCharacter()
	{
		return listCharacter;
	}
	
}
