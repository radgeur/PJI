package mapComponent;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;



/**
 * This class represent a ground case in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Ground implements Case{

	private List<Character> listCharacter;
	
	private int x,y;
	
	public Ground(int x, int y){
		this.x = x;
		this.y = y;
		listCharacter = new ArrayList<Character>();
	}
	
	
	public boolean canPass(Entity entity) {
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * This method return the list of character on this case.
	 * @return the list of character on this case.
	 */
	public List<Character> getListCharacter(){
		return listCharacter;
	}
	
}
