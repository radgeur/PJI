package strategy.actStrategy;

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.MoveStrategy;
import entities.Character;
import entities.Entity;


/**
 * Act Strategy that simply action the first Entity that can
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */
public class SimpleCharacterActStrategy implements ActStrategy<Character>{
	//ATTRIBUTES
	private AttackStrategy attackStrategy;
	private MoveStrategy moveStrategy;
	private Character character;
	
	//METHODS
	/** Constructor
	 * @param att attackstrategy to add
	 * @param move movestrategy to add
	 * @param character that gonna act the strategy
	 */
	public SimpleCharacterActStrategy(AttackStrategy att, MoveStrategy move, Character character){
		this.attackStrategy = att;
		this.moveStrategy = move;
		this.character = character;
	}
	
	@Override
	public void action() {
		List<Entity> listAttackableEntity = getAttackableEntities();
		if(listAttackableEntity.size() == 0)
			moveStrategy.action(character);
		else
			attackStrategy.action(character, listAttackableEntity);
	}
	
	/** return the attackable entities
	 * @return the list of attackable entities
	 */
	public List<Entity> getAttackableEntities(){
		List<Entity> listEntity = GameModel.map.getEntities();
		List<Entity> listAttackableEntity = new ArrayList<Entity>();
		for(Entity ent : listEntity){
			if(ent.isOpponent(character)){
				if(ent.getX() <= character.getX() && (ent.getX() + ent.getWidth()) >= character.getX()){
					if((ent.getY() - character.getY() - character.getHeight()) <= character.getRange())
						listAttackableEntity.add(ent);
				}
			}
		}
		return listAttackableEntity;
	}
	
}
