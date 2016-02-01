package strategy.attackStrategy;

import entities.Entity;

/**
 * Interface to could implements the different attacks Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public interface AttackStrategy {
	
	/**
	 * Action to do when attack
	 * @param entity 
	 */
	public void action(Entity entity);
}
