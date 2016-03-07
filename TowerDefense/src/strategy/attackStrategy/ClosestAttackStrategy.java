package strategy.attackStrategy;

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
		Entity closest = listAttackableEnemies.get(0);
		double distance = entity.distance(listAttackableEnemies.get(0));
		for(Entity ent : listAttackableEnemies) {
			if(entity.distance(ent) < distance){
				distance = entity.distance(ent);
				closest = ent;
			}
		}
		return closest;
	}
	
	/** {@inheritdoc} */
	public void action(Entity entity, List<Entity> listAttackableEnemies) {
		this.entity = entity;
		Entity enemy = closestEnemy(listAttackableEnemies);
		this.entity.attack(enemy);
	}
	
}
