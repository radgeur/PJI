package strategy.actStrategy;

/**
 * ActStrategy class that do nothing
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import entities.Entity;

public class NoActionActStrategy implements ActStrategy<Entity>{

	@Override
	public void action() {}

}
