package entities;

import java.util.List;

import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.MoveStrategy;

/**
 * Class to could instantiate the different kind of Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 * 
 */

public abstract class Entity {

	// ATTRIBUTS
	protected int HP;
	protected int width;
	protected int height;
	protected int range;
	protected int power;
	protected boolean isFriendly;
	protected List<AttackStrategy> attackStrategy;
	protected List<MoveStrategy> moveStrategy;
	
	//METHODS
	/** Constructor
	 * @param HP
	 * @param width
	 * @param height
	 * @param range
	 * @param power
	 * @param isFriendly to know on which side the Entity is
	 */
	public Entity(int HP, int width, int height, int range, int power, boolean isFriendly) {
		this.HP = HP;
		this.width = width;
		this.height = height;
		this.range = range;
		this.power = power;
		this.isFriendly = isFriendly;
	}
	
	public int getHP() {return HP;}
	
	public void setHP(int hP) {HP = hP;}
	
	public int getWidth() {return width;}
	
	public void setWidth(int widht) {this.width = widht;}
	
	public int getHeight() {return height;}
	
	public void setHeight(int height) {this.height = height;}
	
	public int getRange() {return range;}
	
	public void setRange(int range) {this.range = range;}
	
	public int getPower() {return power;}
	
	public void setPower(int power) {this.power = power;}
	
	public boolean getFriendly() {return isFriendly;}
	
	public void setFriendly(boolean isFriendly) {this.isFriendly = isFriendly;}
	
	/**
	 * Use the AttackStrategy
	 */
	public void attack(){
		for(AttackStrategy strategy : attackStrategy) {
			strategy.action();
		}
	}
	
	/**
	 * Use the MoveStrategy
	 */
	public void move(){
		for(MoveStrategy strategy : moveStrategy) {
			strategy.action();
		}
	}
	
	/** To know if both are on the same side
	 * @return true if same side, else false
	 */
	public boolean isOpponent(Entity entity) {
		return entity.getFriendly() == this.isFriendly;
	}
}
