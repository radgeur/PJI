package main;

import javax.swing.ImageIcon;

import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;
import model.GameModel;
import strategy.actStrategy.AimNexusActStrategy;
import strategy.actStrategy.NoActionActStrategy;
import strategy.actStrategy.PlayerActStrategy;
import strategy.actStrategy.SimpleCharacterActStrategy;
import strategy.actStrategy.SimpleDefenceActStrategy;
import strategy.attackStrategy.ClosestAttackStrategy;
import strategy.attackStrategy.SimpleAttackStrategy;
import strategy.moveStrategy.AimNexusMoveStrategy;
import strategy.moveStrategy.PlayerMoveStrategy;
import strategy.moveStrategy.SimpleMoveStrategy;
import view.GameDevView;
import controler.GameControler;
import entities.Character;
import entities.Defence;

public class Game2 {

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
		int nbCase = 10;
		Map m = new Map();
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
		//Uncomment to test the pathfinding.
		c[5][5] = new Wall(5, 5);
		m.setMap(c);
		
		Character monster = new Character(500, 30, 30, 20, 5, false,new ImageIcon("./media/monster.png"));
		
		// TEST de aintonexus strategy
		  
		 /* monster.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster));
		*/
		monster.setActStrategy(new AimNexusActStrategy(
				new ClosestAttackStrategy(), new AimNexusMoveStrategy(), monster));
		
		monster.setSpeed(3);
		monster.setX(210);
		monster.setY(0);
		m.addCharacter(monster);
		
		
		Character player = new Character(1000, 30, 30, 20, 100, true, new ImageIcon("./media/hero.png"));
		
		
		player.setActStrategy(new PlayerActStrategy(new ClosestAttackStrategy(), new PlayerMoveStrategy(), player));
		
		player.setSpeed(3);
		player.setX(210);
		player.setY(150);
		m.addCharacter(player);
		
		Character monster2 = new Character(10, 30, 30, 1, 5, false, new ImageIcon("./media/monster.png"));
		monster2.setActStrategy(new SimpleCharacterActStrategy(
				new SimpleAttackStrategy(), new SimpleMoveStrategy(), monster2));
		monster2.setSpeed(1);
		monster2.setX(270);
		monster2.setY(200);
		m.addCharacter(monster2);
		
		
		Defence defence = new Defence(10, 49, 49, 100, 5, true, new ImageIcon("./media/tourelle.png"));
		defence.setActStrategy(new SimpleDefenceActStrategy(new ClosestAttackStrategy(), defence));
		defence.setX(200);
		defence.setY(200);
		m.addDefence(defence);

		Defence nexus = new Defence(10, 49, 49, 0, 0, true, new ImageIcon("./media/tourelle.png"));
		nexus.setActStrategy(new NoActionActStrategy());
		nexus.setX(200);
		nexus.setY(400);
		m.setNexus(nexus);
		return m;
	}
	
	public static void main(String[] args){
		Game2 g = new Game2();
		g.run();
	}
	
}
