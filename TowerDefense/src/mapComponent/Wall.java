package mapComponent;

import entities.Character;
import entities.Entity;

/**
 * This class represent a wall in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Wall implements Case{
	
	private int x, y;
	
	public Wall(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean canPass(Character character) {
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
