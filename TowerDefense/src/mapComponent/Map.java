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
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 * 
 */
public class Map {
	// ATTRIBUTES
	private Case[][] map;
	private List<Entity> listEntities;
	private Defence nexus;
	public static int caseHeight = 10;
	public static int casewidth = 10;
	public static int catchArea = 3;
	public static final int costPassDefence = 5;
	
	//METHODS
	/** Constructor */
	public Map(){
		map = new Case[10][10];
		listEntities = new ArrayList<Entity>();
	}

	/** return the case where the point (x,y) is
	 * @param x coordinate of the point
	 * @param yncoordinate of the point
	 * @return case
	 */
	public Case getCaseWithPixel(int x, int y) {
		if (x >= map.length * casewidth || x < 0)
			return null;
		if (y >= map[0].length * caseHeight || y < 0)
			return null;
		return map[x / casewidth][y / caseHeight];
	}

	/** return all the Cases where the entity is
	 * @param entity to locate
	 * @return list of Cases where the entity is
	 */
	public List<Case> getCasesOfEntity(Entity entity) {
		List<Case> cases = new ArrayList<Case>();
		Case start = getCaseWithPixel(entity.getX(), entity.getY());
		Case end = getCaseWithPixel(entity.getX() + entity.getWidth(),
				entity.getY() + entity.getHeight());
		for (int i = start.getX(); i <= end.getX(); i++) {
			for (int j = start.getY(); j <= end.getY(); j++) {
				cases.add(map[i][j]);
			}
		}
		return cases;
	}
	

	/**
	 * Add a Character to the list of entities and on the cases where he is locate
	 * @param character  to add
	 */
	public void addCharacter(Character character) {
		List<Case> tmp = getCasesOfEntity(character);
		listEntities.add(character);
		for(Case c : tmp){
			if (!c.isWall()) {
				c.addCharacter(character);
			}
		}
	}

	/** Add a defence to the list of entities and on the cases where it is locate 
	 * @param defence to add
	 */
	public void addDefense(Defence defence) {
		List<Case> tmp = getCasesOfEntity(defence);
		listEntities.add(defence);
		for(Case c : tmp){
			if(!c.isWall() && c.canPut())
				c.putDefence(defence);
		}
	}

	/** remove an entity to the list of entities and of the case where he is
	 * @param entity to remove
	 */
	public void removeEntity(Entity entity) {
		listEntities.remove(entity);
		List<Case> tmp = getCasesOfEntity(entity);
		for(Case c: tmp) {
			c.removeEntity(entity);
		}
	}

	/** remove a list of entities to the list of entities and of the case where he is
	 * @param list of entities to remove
	 */
	public void removeEntities(List<Entity> entities) {
		for (Entity ent : entities) {
			removeEntity(ent);
		}
	}

	/** List the neighbors cases of the current case
	 * @param current case
	 * @return list of the neighbors cases
	 */
	public List<Case> getNeighbors(Case current) {
		List<Case> neighbors = new ArrayList<Case>();
		Case tmp = getCaseWithPixel(current.getXInPixel() + Map.casewidth,
				current.getYInPixel());
		if (tmp != null)
			neighbors.add(tmp);

		tmp = getCaseWithPixel(current.getXInPixel() - Map.casewidth, current.getYInPixel());
		if (tmp != null)
			neighbors.add(tmp);

		tmp = getCaseWithPixel(current.getXInPixel(), current.getYInPixel() + Map.caseHeight);
		if (tmp != null)
			neighbors.add(tmp);

		tmp = getCaseWithPixel(current.getXInPixel(), current.getYInPixel() - Map.caseHeight);
		if (tmp != null)
			neighbors.add(tmp);

		return neighbors;
	}	

	/** When a Defence is put on the board, his catch area are calculated with the static value 
	 * @param Entity defence was put on the board
	 */
	public void updateDefencesPathFinding(Entity defence){
		List<Case> currentCases = new ArrayList<Case>();
		List<Case> previousCases = new ArrayList<Case>();
 		previousCases = this.getCasesOfEntity(defence);
		
		for(int i=1;i<=catchArea;i++){
			for(Case c : previousCases){
				currentCases.addAll(this.getNeighbors(c));
			}
			for(Case c : currentCases){
				if (!c.isWall() && !previousCases.contains(c))
					c.setPathFindingDefence(i, defence);
			}
			previousCases.addAll(currentCases);
		}
	}

	/** Calculate for each case the distance from the Nexus to this case. */
	public void initNexusPathFinding() {
		List<Case> listTmp = getCasesOfEntity(nexus);
		Queue<Case> listCases = new LinkedList<Case>();
		for (Case c : listTmp) {
			c.setPathFindingNexus(0);
			listCases.add(c);
		}
		while (!listCases.isEmpty()) {
			Case currentCase = listCases.poll();
			List<Case> neighbors = this.getNeighbors(currentCase);
			for (Case tmp : neighbors) {
				if (!tmp.isWall()) {
					if(tmp.hasDefence()){
						if (tmp.getPathFindingNexus() == -1
								|| tmp.getPathFindingNexus() > (currentCase.getPathFindingNexus() + Map.costPassDefence)) {
							tmp.setPathFindingNexus(currentCase
									.getPathFindingNexus() + Map.costPassDefence);
							listCases.add(tmp);
						}
					} else {
						if (tmp.getPathFindingNexus() == -1
								|| tmp.getPathFindingNexus() > currentCase.getPathFindingNexus()) {
							tmp.setPathFindingNexus(currentCase
									.getPathFindingNexus() + 1);
							listCases.add(tmp);
						}
					}
				}
			}
		}
	}
	
	public List<Entity> getEntities() {return listEntities;}
	
	public Case[][] getMap() {return map;}

	public void setMap(Case[][] c) {this.map = c;}

	public Defence getNexus() {return nexus;}

	public void setNexus(Defence nexus) {
		this.nexus = nexus;
		this.addDefense(nexus);
	}

	public boolean isFinished() {return nexus.getHP() <= 0;}

	public void setHeight(int h) {caseHeight = h;}

	public void setWidth(int w) {casewidth = w;}
}
