package controler;

import java.util.ArrayList;
import java.util.List;

import mapComponent.Map;
import model.GameModel;
import entities.Defence;
import entities.Entity;

public class GameControler {
	//ATTRIBUTES
	private GameModel model;
	public GameControler(GameModel model){this.model = model;}
	
	//METHODS
	public void run() {
		model.notifyObservers();
		while(!GameModel.map.isFinished()){
			for(Defence defence : Map.defencesToAdd){
				GameModel.map.addDefence(defence);
			}
			if(!Map.defencesToAdd.isEmpty())
				GameModel.map.initNexusPathFinding();
			Map.defencesToAdd.removeAll(Map.defencesToAdd);
			for(Entity entity : GameModel.map.getEntities()){
				entity.action();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			List<Entity> tmp = new ArrayList<Entity>();
			for(Entity entity : GameModel.map.getEntities()){
				if(entity.getHP() <= 0){
					tmp.add(entity);
				}
			}
			GameModel.map.removeEntities(tmp);
			model.setchange();
			model.notifyObservers();
		}		
	}
}
