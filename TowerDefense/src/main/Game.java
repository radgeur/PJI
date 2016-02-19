package main;

import controler.GameControler;
import strategy.actStrategy.ActStrategy;
import strategy.actStrategy.NoActionActStrategy;
import strategy.actStrategy.SimpleCharacterActStrategy;
import strategy.attackStrategy.SimpleAttackStrategy;
import strategy.moveStrategy.SimpleMoveStrategy;
import view.GameView;
import entities.Character;
import entities.Defence;
import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;
import model.GameModel;

public class Game {

	public void run() {
		Map map = initMap();
		GameModel model = new GameModel(map);
		GameView view = new GameView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
	}

	private Map initMap() {
		Map m = new Map(5);
		Case[][] c = new Case[5][5];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Wall(i, j);
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Ground(i, j);
			}
		}

		for (int i = 3; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				c[i][j] = new Wall(i, j);
			}
		}

		Character monster = new Character(10, 10, 10, 1, 10, false);
		monster.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster));
		m.addEntity(monster);
		c[2][0].addCharacter(monster);

		Defence nexus = new Defence(10, 10, 10, 0, 0, true);
		nexus.setActStrategy(new NoActionActStrategy());
		m.setNexus(nexus);
		Ground g = new Ground(2, 4);
		g.putDefence(nexus);
		c[2][4] = g;
		m.setMap(c);

		return m;
	}
	
}
