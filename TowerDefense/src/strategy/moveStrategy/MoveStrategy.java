package strategy.moveStrategy;

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
	public void action(Entity entity);
}
