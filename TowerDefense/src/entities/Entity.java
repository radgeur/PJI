package entities;

import java.util.List;

import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.MoveStrategy;

/**
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 * Class to could implements the different kind of Entity
 */

public abstract class Entity {

	// ATTRIBUTS
	int HP;
	int widht;
	int weight;
	int range;
	int power;
	boolean isFriendly;
	List<AttackStrategy> attackStrategy;
	List<MoveStrategy> moveStrategy;
	
	//METHODS
	public int getHP() {return HP;}
	
	public void setHP(int hP) {HP = hP;}
	
	public int getWidht() {return widht;}
	
	public void setWidht(int widht) {this.widht = widht;}
	
	public int getWeight() {return weight;}
	
	public void setWeight(int weight) {this.weight = weight;}
	
	public int getRange() {return range;}
	
	public void setRange(int range) {this.range = range;}
	
	public int getPower() {return power;}
	
	public void setPower(int power) {this.power = power;}
	
	public boolean isFriendly() {return isFriendly;}
	
	public void setFriendly(boolean isGood) {this.isFriendly = isGood;}
	
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
	
	/**
	 * indicate if the entity is an opponent or not
	 * @param entity
	 * @return if the entity is an opponent or not
	 */
	public boolean isOpponent(Entity entity){
		return isFriendly != entity.isFriendly();
	}
}
