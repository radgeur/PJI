package controler;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import model.GameModel;

public class GameControler {
	private GameModel model;
	
	public GameControler(GameModel model){this.model = model;}

	public void run() {
		model.notifyObservers();
		while(!GameModel.map.isFinished()){
			for(Entity entity : GameModel.map.getEntities()){
				entity.action();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			List<Entity> tmp = new ArrayList<Entity>();
			for(Entity entity : model.map.getEntities()){
				if(entity.getHP() <= 0){
					tmp.add(entity);
				}
			}
			model.map.removeEntities(tmp);
			model.setchange();
			model.notifyObservers();
		}
		if(model.map.getNexus().getHP() > 0)
			System.out.println("vous avez gagné");
		else
			System.out.println("Vous avez perdu");
		
	}
}
