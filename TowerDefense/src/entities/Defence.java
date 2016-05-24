package entities;

import javax.swing.ImageIcon;

/**
 * Class to instantiate a Defence Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class Defence extends Entity{

	
	public Defence(int HP, int width, int height, int range, int power, boolean isFriendly, ImageIcon picture) {
		super(HP, width, height, range, power, isFriendly, picture);
	}
	
	public Defence(int HP, int width, int height, int range, int power, boolean isFriendly, int x, int y, ImageIcon picture){
		super(HP, width, height, range, power, isFriendly, x, y, picture);
	}

	@Override
	public boolean isDefense() {return true;}
	
}
