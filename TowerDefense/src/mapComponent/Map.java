package mapComponent;

import java.util.ArrayList;
import java.util.List;

import entities.Character;
import entities.Defence;
import entities.Entity;


/**
 * This class represent the game surface of our tower defense.
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Map {
	//ATTRIBUTES
	private Case[][] map;
	private List<Entity> listEntities;
	private Defence nexus;
	public static int caseHeight = 10;
	public static int casewidth = 10;
	
	//METHODS
	public Map(int length){
		map = new Case[length][length];
		listEntities = new ArrayList<Entity>();
	}
	
	public Case getCaseWithPixel(int x, int y){
		if(x > map.length * casewidth || x< 0) return null;
		if(y > map[0].length * caseHeight || y< 0) return null;
		return map[x/caseHeight][y/casewidth];
	}
	
	public List<Entity> getEntities() {return listEntities;}
	
	public void addCharacter(Character character){
		Case tmp = getCaseWithPixel(character.getX(), character.getY());
		if(!tmp.isWall()){
			listEntities.add(character);
			tmp.addCharacter(character);
		}
	}
	
	public void addDefense(Defence defence){
		Case tmp = getCaseWithPixel(defence.getX(), defence.getY());
		if(!tmp.isWall() && ((Ground)tmp).canPut(defence)){
			listEntities.add(defence);
			((Ground)tmp).putDefence(defence); 
		}
	}
	
	public Case[][] getMap() {return map;}
	
	public void setMap(Case[][] c) {this.map = c;}

	public Defence getNexus() {return nexus;}

	public void setNexus(Defence nexus) {
		listEntities.add(nexus);
		this.nexus = nexus;
	}
	
	public boolean isFinished(){return nexus.getHP() <= 0;}
	
	public void setHeight(int h){caseHeight = h;}
	
	public void setWidth(int w){casewidth = w;}

	/**
	 * remove an entity of the list of entities and of the case where she is present.
	 * @param entity 
	 */
	public void removeEntity(Entity entity) {
		listEntities.remove(entity);
		Case tmp = getCaseWithPixel(entity.getX(), entity.getY());
		tmp.removeEntity(entity);
	}
	
	/**
	 * remove a list of entities of the list of entities and of the case where they are present.
	 * @param entity 
	 */
	public void removeEntities(List<Entity> entities) {
		for(Entity ent : entities){
			removeEntity(ent);
		}
	}
	
}
