package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.ImageIcon;

import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;
import strategy.actStrategy.AimNexusActStrategy;
import strategy.actStrategy.NoActionActStrategy;
import strategy.actStrategy.PlayerActStrategy;
import strategy.attackStrategy.ClosestAttackStrategy;
import strategy.moveStrategy.AimNexusMoveStrategy;
import strategy.moveStrategy.PlayerMoveStrategy;
import entities.Character;
import entities.Defence;

public class GameModel extends Observable{
	//ATTRIBUTES
	public static Map map;
	
	//METHODS
	/** empty Constructor */
	public GameModel() {
		map = new Map();
	}
	
	/** Constructor
	 * @param map for the game
	 */
	public GameModel(Map m){map = m;}
	
	public void setchange(){this.setChanged();}
	
	/** Create a map from a file
	 * @param filename
	 * @throws IOException 
	 */
	public void readMap(String fileName) throws IOException{
		//to count the lineNumber of the file
		LineNumberReader ln = new LineNumberReader(new FileReader(new File(fileName)));
		ln.skip(Long.MAX_VALUE);
		
		//to read the file
		Scanner scan = new Scanner(new File(fileName));
		int height = Integer.parseInt(scan.nextLine());
		int width = Integer.parseInt(scan.nextLine());
		int cptNexus = 0;
		
		//not the right length for the file
		if(height+2 < ln.getLineNumber() || height+2 > ln.getLineNumber()) {
			System.out.println("the length of the file isn't right");
			scan.close();
			ln.close();
			return;
		}
		String currentLine;
		char currentChar;
		Case[][] cases = new Case[width][height];
		Defence nexus = new Defence(100, Map.caseHeight-1, Map.casewidth-1, 0, 0, true, new ImageIcon("./media/nexus.png"));
		nexus.setActStrategy(new NoActionActStrategy());
		for(int i = 0;i<height;i++){
			currentLine = scan.nextLine();
			
			//A line haven't the right length
			if(currentLine.length() < width || currentLine.length() > width) {
				System.out.println("the length of the line " + (i+2+1) + " isn't right");
				scan.close();
				ln.close();
				return;
			}
			
			for(int j = 0; j<width; j++){
				currentChar = currentLine.charAt(j);
				if(currentChar == 'X')
					cases[j][i] = new Wall(j,i);
				else if (currentChar == 'N' && cptNexus<1){
					cptNexus++;
					cases[j][i] = new Ground(j,i);
					nexus.setX(j*Map.casewidth);
					nexus.setY(i*Map.caseHeight);
				}
				else if (currentChar == 'N' && cptNexus>=1){
					System.out.println("There are more than 1 Nexus on the map, this is forbidden");
					scan.close();
					ln.close();
					return;
				}
				else
					cases[j][i] = new Ground(j,i);					
			}
		}
		scan.close();
		ln.close();
		map.setMap(cases);
		
		Character monster = new Character(500, 30, 30, 20, 5, false, new ImageIcon("./media/monster.png"));
		monster.setActStrategy(new AimNexusActStrategy(
				new ClosestAttackStrategy(), new AimNexusMoveStrategy(), monster));
		
		monster.setSpeed(3);
		monster.setX(210);
		monster.setY(0);
		map.addCharacter(monster);
		
		Character player = new Character(1000, 30, 30, 20, 300, true, new ImageIcon("./media/hero.png"));
		
		
		player.setActStrategy(new PlayerActStrategy(new ClosestAttackStrategy(), new PlayerMoveStrategy(), player));
		
		player.setSpeed(3);
		player.setX(210);
		player.setY(150);
		map.addCharacter(player);
		
		
		map.setNexus(nexus);
		map.initNexusPathFinding();
	}
}
