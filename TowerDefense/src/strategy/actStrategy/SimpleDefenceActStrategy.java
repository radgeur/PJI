package strategy.actStrategy;

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
import strategy.attackStrategy.AttackStrategy;
import entities.Defence;
import entities.Entity;

public class SimpleDefenceActStrategy implements ActStrategy<Defence>{

	private AttackStrategy attackStrategy;
	private Defence defence;
	
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
				System.out.println(ent.distance(defence));
				if(ent.distance(defence) <= defence.getRange()){
					listAttackable.add(ent);
				}
			}
		}
		
		if(listAttackable.size() != 0){
			attackStrategy.action(defence, listAttackable);
		}
	}

}
