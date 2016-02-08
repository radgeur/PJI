package strategy.actStrategy;

import entities.Entity;

/**
 * Interface to could implements the different action Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */
public interface ActStrategy {
	/**
	 * Action to do when act
	 * @param entity 
	 */
	public void action(Entity entity);
}
