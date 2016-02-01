package strategy.moveStrategy;

import mapComponent.Map;
import entities.Entity;

/**
 * Basic move Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleMoveStrategy implements MoveStrategy{
	protected Map map;
	
	public SimpleMoveStrategy(Map map){
		this.map = map;
	}
	
	
	/** {@inheritDoc}*/
	@Override
	public void action(Entity entity) {
		
	}

}
