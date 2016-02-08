package strategy.moveStrategy;

import mapComponent.Map;
import model.GameModel;
import entities.Entity;
import mapComponent.*;

/**
 * Basic move Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleMoveStrategy implements MoveStrategy{
	
	protected final int DEFAULT_MOVE_SPEED = 10;
	
	//ATTRIBUTS
	protected Map map;
	protected Entity character;
	
	//METHODS
	/** Constructor
	 * @param map 
	 */
	public SimpleMoveStrategy(){
		map = GameModel.Map;
	}
	
	/** {@inheritDoc}*/
	@Override
	public void action(Entity entity) {
		//avance de la vitesse du character multiplier par une valeur fixe qui est la valeur de déplacement par défaut
		this.character = entity;
		character.setY(character.getY() + DEFAULT_MOVE_SPEED * character.getSpeed());
		Case case = map.getCaseWithPixel(character.getX(), character.getY());
	}

}