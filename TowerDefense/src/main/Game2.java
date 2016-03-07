package main;

import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;
import model.GameModel;
import strategy.actStrategy.NoActionActStrategy;
import strategy.actStrategy.SimpleCharacterActStrategy;
import strategy.attackStrategy.SimpleAttackStrategy;
import strategy.moveStrategy.SimpleMoveStrategy;
import view.GameView;
import controler.GameControler;
import entities.Character;
import entities.Defence;

public class Game2 {

	public void run() {
		Map map = initMap();
		GameModel model = new GameModel(map);
		GameView view = new GameView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
		controler.run();
	}

	private Map initMap() {
		int nbCase = 10;
		Map m = new Map(nbCase);
		m.setHeight(50);
		m.setWidth(50);
		Case[][] c = new Case[nbCase][nbCase];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Wall(i, j);
			}
		}

		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Ground(i, j);
			}
		}

		for (int i = 6; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Wall(i, j);
			}
		}

		m.setMap(c);
		
		Character monster = new Character(100, 30, 30, 1, 5, false);
		monster.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster));
		monster.setSpeed(1);
		monster.setX(250);
		monster.setY(0);
		m.addCharacter(monster);
		c[2][0].addCharacter(monster);
		
		Character monster2 = new Character(10, 30, 30, 1, 5, false);
		monster2.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster2));
		monster2.setSpeed(1);
		monster2.setX(270);
		monster2.setY(200);
		m.addCharacter(monster2);
		c[2][0].addCharacter(monster2);
		
		
		Defence defence = new Defence(10, 50, 50, 0, 0, true);
		defence.setActStrategy(new NoActionActStrategy());
		defence.setX(200);
		defence.setY(200);
		m.addDefense(defence);

		Defence nexus = new Defence(10, 50, 50, 0, 0, true);
		nexus.setActStrategy(new NoActionActStrategy());
		nexus.setX(200);
		nexus.setY(400);
		m.setNexus(nexus);
		Ground g = new Ground(2, 4);
		g.putDefence(nexus);
		c[4][8] = g;
		return m;
	}
	
	public static void main(String[] args){
		Game2 g = new Game2();
		g.run();
	}
	
}
