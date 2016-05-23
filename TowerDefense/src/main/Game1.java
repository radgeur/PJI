package main;

import javax.swing.ImageIcon;

import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;
import model.GameModel;
import strategy.actStrategy.NoActionActStrategy;
import strategy.actStrategy.SimpleCharacterActStrategy;
import strategy.attackStrategy.SimpleAttackStrategy;
import strategy.moveStrategy.SimpleMoveStrategy;
import view.GameDevView;
import controler.GameControler;
import entities.Character;
import entities.Defence;

public class Game1 {

	public void run() {
		Map map = initMap();
		GameModel model = new GameModel(map);
		GameDevView view = new GameDevView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
		map.initNexusPathFinding();
		controler.run();
	}

	private Map initMap() {
		Map m = new Map();
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
		m.setMap(c);
		Character monster = new Character(10, 70, 70, 10, 5, false, new ImageIcon("./media/monster.png"));
		monster.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster));
		monster.setSpeed(1);
		monster.setX(210);
		monster.setY(0);
		m.addCharacter(monster);
		c[2][0].addCharacter(monster);

		Defence nexus = new Defence(10, 99, 99, 0, 0, true,new ImageIcon("./media/nexus.png"));
		nexus.setActStrategy(new NoActionActStrategy());
		nexus.setX(200);
		nexus.setY(400);
		m.setNexus(nexus);
		return m;
	}
	
	public static void main(String[] args){
		Game1 g = new Game1();
		g.run();
	}
	
}
