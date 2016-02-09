package strategy.moveStrategy;

import mapComponent.Map;
import model.GameModel;
import entities.Entity;
import mapComponent.Case;

/**
 * Basic move Strategy
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class SimpleMoveStrategy implements MoveStrategy{
	
	protected final int DEFAULT_MOVE_SPEED = 10;
	
	//ATTRIBUTS
	protected Map map;
	protected Entity entity;
	
	//METHODS
	/** Constructor
	 * @param map 
	 */
	public SimpleMoveStrategy(){
		map = GameModel.map;
	}
	
	/** {@inheritDoc}*/
	public void action(Entity entity) {
		this.entity = entity;
		Case c = map.getCaseWithPixel(entity.getX(), entity.getY());
		c.removeEntity(entity);
		entity.setY(entity.getY() + DEFAULT_MOVE_SPEED * entity.getSpeed());
		if (entity.getY() + entity.getHeight() > map.getMap().length * Map.casewidth)
			entity.setY(map.getMap().length * Map.casewidth - entity.getHeight());
		c = map.getCaseWithPixel(entity.getX(), entity.getY());
		c.addEntity(entity);
	} 
}