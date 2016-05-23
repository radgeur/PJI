package mapComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entities.Character;
import entities.Defence;
import entities.Entity;



/**
 * This class represent a ground case in the game.
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Ground implements Case{

	//ATTRIBUTS
	private Defence defence;
	private List<Character> listCharacter;
	private int x,y;
	private int nexusDistance;
	private TreeMap<Integer, List<Defence>> defencesDistance;
	private ImageIcon picture;
	private JLabel label;
	
	//METHODS
	/** Constructor
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Ground(int x, int y){
		this.x = x;
		this.y = y;
		listCharacter = new ArrayList<Character>();
		nexusDistance = -1;
		this.defencesDistance =  new TreeMap<Integer, List<Defence>>();
		this.picture = new ImageIcon("./media/ground.jpg");
		this.label = new JLabel(picture);
		this.label.setBounds(this.getX()*Map.casewidth, this.getY()*Map.caseHeight, Map.casewidth, Map.caseHeight);
	}
	
	@Override
	public boolean canPass(Character caracter) {
		if(!hasDefence())
			return true;
		return !defence.isOpponent(caracter);
	}
	
	/** Check if a defence could be place on the case.
	 * @return true if a defence can be place on the case.
	 */
	public boolean canPut(){return this.defence == null && listCharacter.isEmpty();}
	
	@Override
	public boolean hasDefence(){return defence != null;}
	
	/** Put a defence on this case.
	 * @param d
	 */
	public void putDefence(Defence d){
		if(canPut())
			this.defence = d;
	}

	@Override
	public void addCharacter(Character character) {listCharacter.add(character);}

	@Override
	public void removeCharacter(Character character) {listCharacter.remove(character);}

	@Override
	public boolean isWall() {return false;}

	@Override
	public void removeEntity(Entity entity) {
		if(entity.isDefense())
			defence = null;
		else 
			listCharacter.remove(entity);
	}

	@Override
	public void setPathFindingDefence(int key, Defence defence) {
		List<Defence> tmp;
		TreeMap<Integer, List<Defence>> tmpTreeMap = (TreeMap<Integer, List<Defence>>) defencesDistance.clone();
		//check if the treemap already contains the defence
		if(!tmpTreeMap.keySet().isEmpty()) {
			for(Integer k : tmpTreeMap.keySet()){
				if(tmpTreeMap.get(k).contains(defence)){
					//if the new distance is farest than the first
					if (k < key)
						return;
					else
						defencesDistance.get(k).remove(defence);
				}
				//if the key already exist in the map
				if(!tmpTreeMap.containsKey(key))
					tmp =new ArrayList<Defence>();
				else 
					tmp = tmpTreeMap.get(key);
				tmp.add(defence);
				this.defencesDistance.put(key, tmp);
			}
		} else {
			//if the key already exist in the map
			if(!tmpTreeMap.containsKey(key))
				tmp = new ArrayList<Defence>();
			else 
				tmp = tmpTreeMap.get(key);
			tmp.add(defence);
			this.defencesDistance.put(key, tmp);
		}
	}
	
	@Override
	public int getClosestPathFindingDefence(){
		if (this.hasDefence())
			return 0;
		else if(!defencesDistance.isEmpty()){
			for(Integer key : defencesDistance.keySet()){
				for(Entity d : defencesDistance.get(key)){
					if(d.getHP() > 0){
						return key;
					}
				}
			}
			return 0;
		}
		else 
			return 0;
	}
	
	
	
	@Override
	public List<Character> getListCharacter() {return listCharacter;}
	
	@Override
	public int getPathFindingNexus() {return nexusDistance;}

	@Override
	public void setPathFindingNexus(int pathfinding) {this.nexusDistance = pathfinding;}

	@Override
	public TreeMap<Integer, List<Defence>> getPathFindingDefence() {return defencesDistance;}
	
	@Override
	public int getX() {return x;}

	@Override
	public int getY() {return y;}

	@Override
	public int getXInPixel() {return x * Map.casewidth;}

	@Override
	public int getYInPixel() {return y * Map.caseHeight;}

	@Override
	public Defence getDefence() {return defence;}
	
	@Override
	public ImageIcon getPicture(){return this.picture;}
	
	@Override
	public JLabel getLabel(){return this.label;}
}
