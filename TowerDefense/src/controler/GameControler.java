package controler;

import entities.Entity;
import model.GameModel;

public class GameControler {
	private GameModel model;
	
	public GameControler(GameModel model){this.model = model;}

	public void run() {
		model.notifyObservers();
		while(!model.map.isFinished()){
			for(Entity entity : model.map.getEntities()){
				entity.action();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			model.setchange();
			model.notifyObservers();
		}
		if(model.map.getNexus().getHP() > 0)
			System.out.println("vous avez gagné");
		else
			System.out.println("Vous avez perdu");
		
	}
}
