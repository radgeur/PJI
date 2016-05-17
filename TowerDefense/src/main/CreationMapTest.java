package main;

import java.io.IOException;

import model.GameModel;
import view.GameUserView;
import controler.GameControler;

/**
 * Class to test the creation of a map referenced in a test file
 * 
 * @author Dimitri CHARNEUX, Rémy LEPRETRE
 *
 */

public class CreationMapTest {
	public static void main(String[] args) throws IOException{
		GameModel model = new GameModel();
		model.readMap("../map_boucle.txt");
		GameUserView view = new GameUserView();
		model.addObserver(view);
		GameControler controler = new GameControler(model);
		controler.run();
	}
}
