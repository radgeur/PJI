package strategy.moveStrategy;

import entities.Character;
import entities.Entity;


/**
 * Interface to could implements the different move Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public interface MoveStrategy {
	
	/** Action to do when move 
	 * @param entity */
	public void action(Character character);
}
