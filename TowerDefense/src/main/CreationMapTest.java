package main;

import java.io.FileNotFoundException;

import controler.GameControler;
import mapComponent.Map;
import model.GameModel;
import view.GameView;

/**
 * Class to test the creation of a map referenced in a test file
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */

public class CreationMapTest {
	public static void main(String[] args) throws FileNotFoundException{
		Map map = GameModel.readMap("../map_test.txt");
		GameModel model = new GameModel(map);
		GameView view = new GameView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
		controler.run();
	}
}
