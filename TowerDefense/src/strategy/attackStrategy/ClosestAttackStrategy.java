package strategy.attackStrategy;

/**
 * AttackStrategy that attack the closest enemy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.util.List;

import entities.Entity;


public class ClosestAttackStrategy implements AttackStrategy{
	//ATTRIBUTES
	protected Entity entity;

	/** return the closest enemy of the current entity
	 * @param listAttackableEnnemies all the enemies that the current entity could attack
	 * @return the closest enemy
	 */
	public Entity closestEnemy(List<Entity> listAttackableEnemies) {
		Entity closest = null;
		double distance = Double.MAX_VALUE;
		for(Entity ent : listAttackableEnemies) {
			if(entity.distance(ent) < distance){
				distance = entity.distance(ent);
				closest = ent;
			}
		}
		return closest;
	}
	
	@Override
	public void action(Entity entity, List<Entity> listAttackableEnemies) {
		this.entity = entity;
		Entity enemy = closestEnemy(listAttackableEnemies);
		if(enemy != null)
			this.entity.attack(enemy);
	}
	
}
