package mapComponent;

import java.util.ArrayList;
import java.util.List;

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
	
	public void addEntity(Entity ent){
		listEntities.add(ent);
		
		
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
	
}
