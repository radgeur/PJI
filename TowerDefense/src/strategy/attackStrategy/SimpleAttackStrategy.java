package strategy.attackStrategy;

import mapComponent.Map;
import entities.Entity;

/**
 * Attack Strategy that simply attack the first Entity that can
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleAttackStrategy implements AttackStrategy{
	protected Map map;
	
	public SimpleAttackStrategy(Map map){
		this.map = map;
	}
	
	
	
	/** {@inheritDoc}*/
	@Override
	public void action(Entity entity) {
		
	}

}
