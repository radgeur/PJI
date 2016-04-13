package strategy.actStrategy;

/**
 * ActStrategy for a defence
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
import strategy.attackStrategy.AttackStrategy;
import entities.Defence;
import entities.Entity;

public class SimpleDefenceActStrategy implements ActStrategy<Defence>{
	//ATTRIBUTES
	private AttackStrategy attackStrategy;
	private Defence defence;
	
	//METHODS
	/** Constructor
	 * @param att attackStrategy
	 * @param defence that gonna act the strategy
	 */
	public SimpleDefenceActStrategy(AttackStrategy att, Defence defence){
		this.attackStrategy = att;
		this.defence = defence;
	}
	
	@Override
	public void action() {
		List<Entity> listEntity = GameModel.map.getEntities();
		List<Entity> listAttackable = new ArrayList<Entity>();
		for(Entity ent : listEntity){
			if(ent.isOpponent(defence)){
				double dist = ent.minimalDistance(defence);
				if(ent.minimalDistance(defence) <= defence.getRange()){
					listAttackable.add(ent);
				}
			}
		}
		
		if(listAttackable.size() != 0){
			attackStrategy.action(defence, listAttackable);
		}
	}

}
