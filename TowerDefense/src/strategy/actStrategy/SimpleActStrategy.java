package strategy.actStrategy;

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
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
	private Entity entity;
	
	public SimpleActStrategy(AttackStrategy att, MoveStrategy move, Entity entity){
		this.attackStrategy = att;
		this.moveStrategy = move;
		this.entity = entity;
	}
	
	@Override
	public void action(Entity entity) {
		List<Entity> listAttackableEntity = getAttackableEntity();
		if(listAttackableEntity == null)
			moveStrategy.action(entity);
		else
			attackStrategy.action(entity, listAttackableEntity);
	}
	
	public List<Entity> getAttackableEntity(){
		List<Entity> listEntity = GameModel.map.getEntities();
		List<Entity> listAttackableEntity = new ArrayList<Entity>();
		for(Entity ent : listEntity){
			if(ent.isOpponent(entity)){
				if(ent.getX() <= entity.getX() && (ent.getX() + ent.getWidth()) >= entity.getX()){
					if((ent.getY() - entity.getY()) <= entity.getRange())
						listAttackableEntity.add(ent);
				}
			}
		}
		return listAttackableEntity;
	}
	
}
