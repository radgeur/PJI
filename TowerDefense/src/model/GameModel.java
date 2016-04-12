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
	public static Map map;
	public GameModel(Map map){this.map = map;}
	
	public void setchange(){this.setChanged();}
	
	/** Create a map from a file
	 * @param filename 
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static Map readMap(String fileName) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(fileName));
		int height = Integer.parseInt(scan.nextLine());
		int width = Integer.parseInt(scan.nextLine());
		String currentLine;
		char currentChar;
		Map map = new Map(height);
		Case[][] cases = new Case[width][height];
		for(int i = 0;i<height;i++){
			currentLine = scan.nextLine();
			for(int j = 0; j<width; j++){
				currentChar = currentLine.charAt(j);
				System.out.println(currentChar);
				if(currentChar == 'X')
					cases[j][i] = new Wall(j*Map.caseHeight,i*Map.casewidth);
				/*else if (currentChar == 'N'){
					cases[j][i] = new Ground(j*Map.caseHeight,i*Map.casewidth);
					Defence nexus = new Defence(10, 1, 1, 0, 0, true);
					nexus.setX(j*Map.casewidth);
					nexus.setY(i*Map.caseHeight);
					map.setNexus(nexus);
				}*/
				else
					cases[j][i] = new Ground(j*Map.caseHeight,i*Map.casewidth);					
			}
		}
		scan.close();
		map.setMap(cases);
		return map;
	}
}
