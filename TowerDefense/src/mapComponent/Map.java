package mapComponent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	
	/** return the case where the point (x,y) is
	 * @param x coordinate of the point
	 * @param y coordinate of the point
	 * @return case
	 */
	public Case getCaseWithPixel(int x, int y){
		if(x > map.length * casewidth || x< 0) return null;
		if(y > map[0].length * caseHeight || y< 0) return null;
		return map[x/caseHeight][y/casewidth];
	}
	
	/** return all the Cases where the entity is
	 * @param entity to locate
	 * @return list of Cases where the entity is
	 */
	public List<Case> getCasesOfEntity(Entity entity) {
		List<Case> cases = new ArrayList<Case>();
		Case start = getCaseWithPixel(entity.getX(), entity.getY());
		Case end = getCaseWithPixel(entity.getX() + entity.getWidth(), entity.getY() + entity.getHeight());
		for(int i = start.getX();i<end.getX();i++){
			for(int j = start.getY();j<end.getY();j++){
				cases.add(map[i][j]);
			}
		}
		return cases;
	}
	
	public List<Entity> getEntities() {return listEntities;}
	
	//TODO remplacer les getcase par des getcases dans addcharacter and adddefence
	/**
	 * Add a Character to the list of entities and on the cases where is locate
	 * @param character to add
	 */
	public void addCharacter(Character character){
		Case tmp = getCaseWithPixel(character.getX(), character.getY());
		if(!tmp.isWall()){
			listEntities.add(character);
			tmp.addCharacter(character);
		}
	}
	
	/**
	 * Add a defence to the list of entities and on the cases where is locate
	 * @param defence to add
	 */
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
	
	public List<Case> getNeighbors(Case current){
		List<Case> neighbors = new ArrayList<Case>();
		Case tmp = getCaseWithPixel(current.getX() + Map.casewidth, current.getY());
		if(tmp != null) neighbors.add(tmp);
		
		tmp = getCaseWithPixel(current.getX() - Map.casewidth, current.getY());
		if(tmp != null) neighbors.add(tmp);
		
		tmp = getCaseWithPixel(current.getX(), current.getY() + Map.caseHeight);
		if(tmp != null) neighbors.add(tmp);
		
		tmp = getCaseWithPixel(current.getX(), current.getY() - Map.caseHeight);
		if(tmp != null) neighbors.add(tmp);
		
		return neighbors;
	}
	
	
	/**
	 * Calculate for each case the distance to Nexus at this case. 
	 */
	public void initNexusPathFinding(){
		Case currentCase = getCaseWithPixel(nexus.getX(), nexus.getY());
		currentCase.setPathFindingNexus(0);
		Queue<Case> listCase = new LinkedList<Case>();
		listCase.add(currentCase);
		while(!listCase.isEmpty()){
			currentCase = listCase.poll();
			List<Case> neighbors = this.getNeighbors(currentCase);
			for(Case tmp : neighbors){
				if(tmp.getPathFindingNexus() >= 0){
					tmp.setPathFindingNexus(currentCase.getPathFindingNexus() +1);
					listCase.add(tmp);
				}
			}
		}
	}
	
}
