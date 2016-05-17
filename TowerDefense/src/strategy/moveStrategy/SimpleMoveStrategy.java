package strategy.moveStrategy;

import java.util.List;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;
import entities.Character;

/**
 * Basic move Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy
 * 
 */

public class SimpleMoveStrategy implements MoveStrategy {

	protected final int DEFAULT_MOVE_SPEED = 10;

	// ATTRIBUTS
	protected Character character;

	// METHODS
	/** Constructor */
	public SimpleMoveStrategy() {
	}

	@Override
	public void action(Character character) {
		Map map = GameModel.map;
		int tmpY = character.getY();
		this.character = character;
		List<Case> cases = map.getCasesOfEntity(character);
		for (Case caseC : cases)
			caseC.removeCharacter(character);
		character.setY(character.getY() + DEFAULT_MOVE_SPEED
				* character.getSpeed());
		if (character.getY() + character.getHeight() >= GameModel.map.getMap()[0].length
				* Map.caseHeight)
			character.setY((GameModel.map.getMap()[0].length * Map.caseHeight)
					- character.getHeight() - 1);
		cases = map.getCasesOfEntity(character);
		boolean canPass = true;
		for (Case caseC : cases){
			if(!caseC.canPass(character)){
				canPass = false;
			}
		}
		if(!canPass)
			character.setY(tmpY);
		cases = map.getCasesOfEntity(character);
		for (Case caseC : cases)
			caseC.addCharacter(character);
	}
}