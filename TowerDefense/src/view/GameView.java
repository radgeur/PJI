package view;

/**
 * Class to instantiate a frame for the game
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GameView implements Observer{
	private JFrame window;
	private MyPanel panel;
	
	/** Constructor */
	public GameView(){
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Tower Defense");
	    panel = new MyPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setPreferredSize(new Dimension(500,550));
	    window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
	    window.getContentPane().add(panel);
	    window.setResizable(false);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setLocationRelativeTo(null);
	    window.setVisible(true);
	    window.pack();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		panel.repaint();
	}

}
