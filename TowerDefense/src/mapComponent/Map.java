package mapComponent;


/**
 * This class represent the game surface of our tower defense.
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */
public class Map {
	private Case[][] map;
	public final int caseHeight = 10;
	public final int casewidth = 10;
	
	public Map(int length){
		map = new Case[length][length];
	}
	
}
