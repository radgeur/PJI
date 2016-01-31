package mapComponent;


/**
 * This class represent the game surface of our tower defense.
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Map {
	private Case[][] map;
	
	public Map(int length){
		map = new Case[length][length];
	}
	
}
