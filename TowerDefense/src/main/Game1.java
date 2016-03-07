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

public class Game1 {

	public void run() {
		Map map = initMap();
		GameModel model = new GameModel(map);
		GameView view = new GameView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
		controler.run();
	}

	private Map initMap() {
		Map m = new Map(5);
		m.setHeight(100);
		m.setWidth(100);
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

		Character monster = new Character(10, 70, 70, 1, 5, false);
		monster.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster));
		monster.setSpeed(1);
		monster.setX(210);
		monster.setY(0);
		m.addEntity(monster);
		c[2][0].addCharacter(monster);

		Defence nexus = new Defence(10, 100, 100, 0, 0, true);
		nexus.setActStrategy(new NoActionActStrategy());
		nexus.setX(200);
		nexus.setY(400);
		m.setNexus(nexus);
		Ground g = new Ground(2, 4);
		g.putDefence(nexus);
		c[2][4] = g;
		m.setMap(c);

		return m;
	}
	
	public static void main(String[] args){
		Game1 g = new Game1();
		g.run();
	}
	
}
