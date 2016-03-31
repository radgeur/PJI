package strategy.attackStrategy;

import java.util.List;

import entities.Entity;

/**
 * Interface to could implements the different attacks Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public interface AttackStrategy {
	
	/** Action to do when attack
	 * @param entity that do the attack
	 * @param listAttackableEnnemies list of enemies that could be attack
	 */
	public void action(Entity entity, List<Entity> listAttackableEnemies);
}
