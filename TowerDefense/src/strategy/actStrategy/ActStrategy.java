package strategy.actStrategy;

import entities.Entity;

/**
 * Interface to could implements the different action Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */
public interface ActStrategy <T extends Entity> {
	/**
	 * Action to do when act
	 */
	public void action();
}
