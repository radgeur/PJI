package strategy.moveStrategy;

import mapComponent.Map;
import model.GameModel;
import entities.Character;
import entities.Entity;
import mapComponent.Case;

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
	protected Character character;
	
	//METHODS
	/** Constructor */
	public SimpleMoveStrategy(){
		map = GameModel.map;
	}
	
	/** {@inheritDoc}*/
	public void action(Character character) {
		this.character = character;
		Case c = map.getCaseWithPixel(character.getX(), character.getY());
		c.removeCharacter(character);
		character.setY(character.getY() + DEFAULT_MOVE_SPEED * character.getSpeed());
		if (character.getY() + character.getHeight() > map.getMap().length * Map.casewidth)
			character.setY(map.getMap()[0].length * Map.casewidth - character.getHeight());
		c = map.getCaseWithPixel(character.getX(), character.getY());
		c.addCharacter(character);
	} 
}