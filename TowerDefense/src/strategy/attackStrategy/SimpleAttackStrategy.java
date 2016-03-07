package strategy.attackStrategy;

import java.util.List;

import entities.Entity;

/**
 * Attack Strategy that simply attack the first Entity that can
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleAttackStrategy implements AttackStrategy{
	//ATTRIBUTS
	protected Entity entity;
	
	//METHODS
	/** {@inheritDoc}*/
	public void action(Entity entity, List<Entity> listAttackableEnemies) {
		this.entity = entity;
		Entity enemy = closestEnemy(listAttackableEnemies);
		this.entity.attack(enemy);
	}



	/**
	 * Method to find the closest enemy in a list of enemies
	 * @param listAttackableEnemies list of enemies attackable by the entity in this class
	 * @return the closest enemy in the list
	 */
	private Entity closestEnemy(List<Entity> listAttackableEnemies) {
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
