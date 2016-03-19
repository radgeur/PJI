package entities;

import java.awt.Point;

import strategy.actStrategy.ActStrategy;

/**
 * Class to could instantiate the different kind of Entity
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 * 
 */

public abstract class Entity {

	// ATTRIBUTS
	protected int HP;
	protected int maxHP;
	protected int width;
	protected int height;
	protected int range;
	protected int power;
	protected int x;
	protected int y;
	protected int speed;
	protected boolean isFriendly;
	protected ActStrategy<? extends Entity> actStrategy;
	
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
		this.maxHP = this.HP = HP;
		this.width = width;
		this.height = height;
		this.range = range + (int) Math.sqrt((height/2)^2 + (width/2)^2);
		this.power = power;
		this.isFriendly = isFriendly;
	}
	
	public void action(){
		actStrategy.action();
	}
	
	public int getHP() {return HP;}
	
	public int getMaxHP() {return maxHP;}
	
	public void setHP(int hP) {HP = hP;}
	
	public void removeHP(int rmHp){
		if(HP - rmHp <= 0)
			HP = 0;
		else
			HP -= rmHp;
	}
	
	public int getWidth() {return width;}
	
	public void setWidth(int widht) {this.width = widht;}
	
	public int getHeight() {return height;}
	
	public void setHeight(int height) {this.height = height;}
	
	public int getRange() {return range;}
	
	public void setRange(int range) {this.range = range;}
	
	public int getPower() {return power;}
	
	public void setPower(int power) {this.power = power;}
	
	public int getX() {return x;}
	
	public void setX(int x) {this.x = x;}
	
	public int getY() {return y;}
	
	public void setY(int y) {this.y = y;}
	
	public boolean getFriendly() {return isFriendly;}
	
	public void setFriendly(boolean isFriendly) {this.isFriendly = isFriendly;}
	
	public int getSpeed() {return speed;}

	public void setSpeed(int speed) {this.speed = speed;}
	
	public void setActStrategy(ActStrategy<? extends Entity> act){this.actStrategy = act;}
	
	/** To know if both are on the same side
	 * @return true if same side, else false
	 */
	public boolean isOpponent(Entity entity) {
		return entity.getFriendly() != this.isFriendly;
	}
	
	public void attack(Entity enemy){
		enemy.removeHP(power);
	}
	
	public abstract boolean isDefense();
	
	/** Return the center of an Entity
	 * @param entity
	 * @return center of the entity
	 */
	public Point getCenter() {
		int x = (this.x + width) / 2;
		int y = (this.y + height) / 2;
		return new Point(x,y);
	}
	
	/** Return the distance between the current entity and an other entity
	 * @param entity to compare the distance
	 * @return distance between both
	 */
	public double distance(Entity entity) {
		double dist;
		Point currentEntityCenter = this.getCenter();
		Point otherEntityCenter = entity.getCenter();
		dist = Math.abs(currentEntityCenter.getX() - otherEntityCenter.getX());
		dist += Math.abs(currentEntityCenter.getY() - otherEntityCenter.getY());
		return dist;
	}
}
