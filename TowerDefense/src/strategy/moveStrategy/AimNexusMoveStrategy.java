package strategy.moveStrategy;

import java.util.List;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;
import entities.Character;

public class AimNexusMoveStrategy implements MoveStrategy {
	protected final int DEFAULT_MOVE_SPEED = 2;

	// ATTRIBUTS
	protected Character character;

	
	@Override
	public void action(Character character) {		
		this.character = character;
		List<Case> characterCases = GameModel.map.getCasesOfEntity(character);
		if(characterCases.size() == 1){
			Case characterCase = characterCases.get(0);
			List<Case> neighbors = GameModel.map.getNeighbors(characterCase);
			Case closestOfNexus = null;
			for (Case c : neighbors) {
				if (closestOfNexus == null) {
					if (c.getPathFindingNexus() != -1)
						closestOfNexus = c;
				} else if (c.getPathFindingNexus() < closestOfNexus
						.getPathFindingNexus() && c.getPathFindingNexus() != -1)
					closestOfNexus = c;
			}
			/*
			 * Détection de la direction à emprunter
			 */
			if (Math.abs(characterCase.getX() - closestOfNexus.getX()) == 1
					&& Math.abs(characterCase.getY() - closestOfNexus.getY()) == 0) {
				if (closestOfNexus.getX() - characterCase.getX() == 1) {
					move(character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
				} else {
					move(-character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
				}
			}
			if (Math.abs(characterCase.getX() - closestOfNexus.getX()) == 0
					&& Math.abs(characterCase.getY() - closestOfNexus.getY()) == 1) {
				if (closestOfNexus.getY() - characterCase.getY() == 1) {
					move(0, character.getSpeed() * DEFAULT_MOVE_SPEED);
				} else {
					move(0, -character.getSpeed() * DEFAULT_MOVE_SPEED);
				}
			}
			
			
			
		} else if(characterCases.size() == 2){
			Case closestNexusCase = characterCases.get(0);
			Case farthestNexusCase = characterCases.get(1);
			if(farthestNexusCase.getPathFindingNexus() < closestNexusCase.getPathFindingNexus()){
				closestNexusCase = characterCases.get(1);
				farthestNexusCase = characterCases.get(0);
			}
			
			//Détection de la direction à emprunter
			if (Math.abs(farthestNexusCase.getX() - closestNexusCase.getX()) == 1
					&& Math.abs(farthestNexusCase.getY() - closestNexusCase.getY()) == 0) {
				if (closestNexusCase.getX() - farthestNexusCase.getX() == 1) {
					move(character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
				} else {
					move(-character.getSpeed() * DEFAULT_MOVE_SPEED, 0);
				}
			}
			if (Math.abs(farthestNexusCase.getX() - closestNexusCase.getX()) == 0
					&& Math.abs(farthestNexusCase.getY() - closestNexusCase.getY()) == 1) {
				if (closestNexusCase.getY() - farthestNexusCase.getY() == 1) {
					move(0, character.getSpeed() * DEFAULT_MOVE_SPEED);
				} else {
					move(0, -character.getSpeed() * DEFAULT_MOVE_SPEED);
				}
			}
			
			
		}
	}
	
	

	private void move(int x, int y) {
		List<Case> cases = GameModel.map.getCasesOfEntity(character);
		int xChar = character.getX();
		int yChar = character.getY();
		for (Case caseC : cases)
			caseC.removeCharacter(character);
		for(int i = x; i>0; i--){
			boolean canPass = true;
			character.setX(character.getX() + i);
			if (character.getX() + character.getWidth() >= GameModel.map.getMap().length
					* Map.casewidth)
				character.setX(GameModel.map.getMap().length * Map.casewidth
						- character.getWidth()-1);
			if (character.getX() < 0)
				character.setX(0);
			cases = GameModel.map.getCasesOfEntity(character);
			for(Case c : cases){
				if(!c.canPass(character)){
					canPass = false;
				}
			}
			
			if(canPass)
				break;
			else
				character.setX(xChar);
		}
		
		for(int i = x; i<0; i++){
			boolean canPass = true;
			character.setX(character.getX() + i);
			if (character.getX() + character.getWidth() >= GameModel.map.getMap().length
					* Map.casewidth)
				character.setX(GameModel.map.getMap().length * Map.casewidth
						- character.getWidth()-1);
			if (character.getX() < 0)
				character.setX(0);
			cases = GameModel.map.getCasesOfEntity(character);
			for(Case c : cases){
				if(!c.canPass(character)){
					canPass = false;
				}
			}
			
			if(canPass)
				break;
			else
				character.setX(xChar);
		}
		
		for(int i = y; i>0; i--){
			boolean canPass = true;
			character.setY(character.getY() + i);
			if (character.getY() + character.getHeight() >= GameModel.map.getMap()[0].length
					* Map.caseHeight)
				character.setY(GameModel.map.getMap()[0].length * Map.caseHeight
						- character.getHeight()-1);
			if (character.getY() < 0)
				character.setY(0);
			cases = GameModel.map.getCasesOfEntity(character);
			for(Case c : cases){
				if(!c.canPass(character)){
					canPass = false;
				}
			}
			
			if(canPass)
				break;
			else
				character.setY(yChar);
				
		}
		
		for(int i = y; i<0; i++){
			boolean canPass = true;
			character.setY(character.getY() + i);
			if (character.getY() + character.getHeight() >= GameModel.map.getMap()[0].length
					* Map.caseHeight)
				character.setY(GameModel.map.getMap()[0].length * Map.caseHeight
						- character.getHeight()-1);
			if (character.getY() < 0)
				character.setY(0);
			cases = GameModel.map.getCasesOfEntity(character);
			for(Case c : cases){
				if(!c.canPass(character)){
					canPass = false;
				}
			}
			
			if(canPass)
				break;
			else
				character.setY(yChar);
		}
		
		
		cases = GameModel.map.getCasesOfEntity(character);
		for (Case caseC : cases)
			caseC.addCharacter(character);
	}
}
