package strategy.attackStrategy;

import java.util.List;

import mapComponent.Map;
import entities.Entity;

/**
 * Attack Strategy that simply attack the first Entity that can
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleAttackStrategy implements AttackStrategy{
	//ATTRIBUTS
	protected Map map;
	protected Entity character;
	protected Entity enemy;
	
	//METHODS
	/** Constructor
	 * @param map
	 */
	public SimpleAttackStrategy(Map map){
		this.map = map;
	}
	
	
	
	/** {@inheritDoc}*/
	@Override
	public void action(Entity entity, List<Entity> listAttackableEnnemies) {
		
		//récpupère la liste des ennemis qui peuvent etre attaqué par character et attaque celui qui est le proche de lui
	}

}
