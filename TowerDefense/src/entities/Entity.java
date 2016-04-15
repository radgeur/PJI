package entities;

import java.awt.Point;
import mapComponent.Map;
import mapComponent.Case;

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
	
	/** Define how the entity gonna act */
	public void action(){
		actStrategy.action();
	}
	
	
	/** Calculate the substraction of life points
	 * @param rmHp number of life points to substract
	 */
	public void removeHP(int rmHp){
		if(HP - rmHp <= 0)
			HP = 0;
		else
			HP -= rmHp;
	}
	
	
	/** To know if both are on the same side
	 * @return true if same side, else false
	 */
	public boolean isOpponent(Entity entity) {
		return entity.getFriendly() != this.isFriendly;
	}
	
	/** Method call when an entity attack
	 * @param enemy attacked
	 */
	public void attack(Entity enemy){
		enemy.removeHP(power);
	}
	
	/** Define if the entity is a defence or not */
	public abstract boolean isDefense();
	
	/** Return the center of an Entity
	 * @param entity
	 * @return center of the entity
	 */
	public Point getCenter() {
		int x = this.x + width / 2;
		int y = this.y + height / 2;
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
	
	/** Return the minimal distance between the current entity and an other entity
	 * @param entity to compare the distance
	 * @return distance between both
	 */
	public double minimalDistance(Entity entity) {
		Point currentEntityCenter = this.getCenter();
		if(currentEntityCenter.getX() >= entity.getX() 
				&& currentEntityCenter.getX() <= entity.getX() + entity.getWidth() ){
			double d1 = Math.abs(currentEntityCenter.getY() - entity.getY());
			double d2 = Math.abs(currentEntityCenter.getY() - (entity.getY() + entity.getHeight()));
			return d1<d2?d1:d2;
		} else if(currentEntityCenter.getY() >= entity.getY() 
				&& currentEntityCenter.getY() <= entity.getY() + entity.getHeight()){
			double d1 = Math.abs(currentEntityCenter.getX() - entity.getX());
			double d2 = Math.abs(currentEntityCenter.getX() - (entity.getX() + entity.getWidth()));
			return d1<d2?d1:d2;
		} else {
			return distance(entity);
		}
	}
	
	/** Return the distance between the current entity and an case
	 * @param case to compare the distance
	 * @return distance between both
	 */
	public int distanceInLineToCase(Case c) {
		int dist = Integer.MAX_VALUE;
		dist = Math.min(dist, this.x - c.getXInPixel());
		dist = Math.min(dist, this.x - (c.getXInPixel() + Map.casewidth));
		dist = Math.min(dist, (this.x + this.width) - c.getXInPixel());
		dist = Math.min(dist, (this.x + this.width) - (c.getXInPixel() + Map.casewidth));
		
		dist = Math.min(dist, this.y - c.getYInPixel());
		dist = Math.min(dist, this.y - (c.getYInPixel() + Map.caseHeight));
		dist = Math.min(dist, (this.y + this.height) - c.getYInPixel());
		dist = Math.min(dist, (this.y + this.height) - (c.getYInPixel() + Map.caseHeight));	
		
		return dist;
	}
	
	public int getHP() {return HP;}
	
	public int getMaxHP() {return maxHP;}
	
	public void setHP(int hP) {HP = hP;}
	
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
}
