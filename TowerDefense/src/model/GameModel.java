package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Scanner;

import strategy.actStrategy.NoActionActStrategy;
import entities.Defence;
import mapComponent.Case;
import mapComponent.Ground;
import mapComponent.Map;
import mapComponent.Wall;

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
	 * @return
	 * @throws FileNotFoundException 
	 */
	public void readMap(String fileName) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(fileName));
		int height = Integer.parseInt(scan.nextLine());
		int width = Integer.parseInt(scan.nextLine());
		String currentLine;
		char currentChar;
		Case[][] cases = new Case[width][height];
		Defence nexus = new Defence(10, 9, 9, 0, 0, true);
		nexus.setActStrategy(new NoActionActStrategy());
		for(int i = 0;i<height;i++){
			currentLine = scan.nextLine();
			for(int j = 0; j<width; j++){
				currentChar = currentLine.charAt(j);
				System.out.println(currentChar);
				if(currentChar == 'X')
					cases[j][i] = new Wall(j,i);
				else if (currentChar == 'N'){
					cases[j][i] = new Ground(j,i);
					nexus.setX(j*Map.casewidth);
					nexus.setY(i*Map.caseHeight);
				}
				else
					cases[j][i] = new Ground(j,i);					
			}
		}
		scan.close();
		map.setMap(cases);
		map.setNexus(nexus);
	}
}
