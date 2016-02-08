package strategy.actStrategy;

import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.MoveStrategy;
import entities.Entity;


/**
 * Act Strategy that simply action the first Entity that can
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */
public class SimpleActStrategy implements ActStrategy{
	private AttackStrategy attackStrategy;
	private MoveStrategy moveStrategy;
	private Entity character;
	
	public SimpleActStrategy(AttackStrategy att, MoveStrategy move, Entity charac){
		this.attackStrategy = att;
		this.moveStrategy = move;
		this.character = charac;
	}
	
	@Override
	public void action(Entity entity) {
		
	}

}
