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
	protected Entity entity;
	
	//METHODS
	/** Constructor
	 * @param map
	 */
	public SimpleAttackStrategy(Map map){
		this.map = map;
	}
	
	
	
	/** {@inheritDoc}*/
	@Override
	public void action(Entity entity, List<Entity> listAttackableEnemies) {
		this.entity = entity;
		Entity enemy = moreNearEnnemy(listAttackableEnemies);
		this.entity.attack(enemy);
	}



	private Entity moreNearEnnemy(List<Entity> listAttackableEnemies) {
		Entity tmp = null;
		int distMin = Integer.MAX_VALUE;
		for(Entity ent : listAttackableEnemies){
			if((ent.getY() - entity.getY()) < distMin){
				distMin = ent.getY() - entity.getY();
				tmp = ent;
			}
		}
		return tmp;
	}

}
