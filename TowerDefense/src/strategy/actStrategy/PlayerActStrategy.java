package strategy.actStrategy;

import java.util.ArrayList;
import java.util.List;

import listeners.ActionKeyListener;
import listeners.CharacterAction;
import model.GameModel;
import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.PlayerMoveStrategy;
import entities.Character;
import entities.Entity;

public class PlayerActStrategy implements ActStrategy<Character>{
	// ATTRIBUTES
	private AttackStrategy attackStrategy;
	private PlayerMoveStrategy moveStrategy;
	private Character character;
	protected final int DEFAULT_MOVE_SPEED = 5;

	
	//METHODS
		/** Constructor
		 * @param att attackstrategy to add
		 * @param move movestrategy to add
		 * @param character that gonna act the strategy
		 */
		public PlayerActStrategy(AttackStrategy att, PlayerMoveStrategy move, Character character){
			this.attackStrategy = att;
			this.moveStrategy = move;
			this.character = character;
		}
	
	@Override
	public void action() {
		switch (ActionKeyListener.lastAction) {
		case ATTACK:
			List<Entity> listAttackableEnemies = getAttackableEntities();
			attackStrategy.action(character, listAttackableEnemies);
			break;
		case MOVE_BOTTOM:
			moveStrategy.setDirection(0, character.getSpeed() * DEFAULT_MOVE_SPEED);
			moveStrategy.action(character);
			break;
		case MOVE_TOP:
			moveStrategy.setDirection(0,- character.getSpeed() * DEFAULT_MOVE_SPEED);
			moveStrategy.action(character);
			break;
		case MOVE_RIGHT:
			moveStrategy.setDirection(character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
			moveStrategy.action(character);
			break;
		case MOVE_LEFT:
			moveStrategy.setDirection(-character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
			moveStrategy.action(character);
			break;
		}
		ActionKeyListener.lastAction = CharacterAction.NO_ACTION;
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
