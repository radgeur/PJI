package entities;

import javax.swing.ImageIcon;

/**
 * Class to instantiate a Character Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy
 * 
 */

public class Character extends Entity{

	
	public Character(int HP, int width, int height, int range, int power, boolean isFriendly, ImageIcon picture) {
		super(HP, width, height, range, power, isFriendly, picture);
	}
	
	public Character(int HP, int width, int height, int range, int power, boolean isFriendly, int x, int y, ImageIcon picture){
		super(HP, width, height, range, power, isFriendly, x, y, picture);
	}

	@Override
	public boolean isDefense() {return false;}
}
