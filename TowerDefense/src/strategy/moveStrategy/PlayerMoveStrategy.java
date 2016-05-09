package strategy.moveStrategy;

import java.util.List;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;
import entities.Character;

public class PlayerMoveStrategy implements MoveStrategy{

	private Character character;
	private int x, y;
	
	@Override
	public void action(Character character) {
		this.character = character;
		move();
	}

	public void setDirection(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	private void move() {
		List<Case> cases = GameModel.map.getCasesOfEntity(character);
		int xChar = character.getX();
		int yChar = character.getY();
		//System.out.println("move : " +x + " , " + y);
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
