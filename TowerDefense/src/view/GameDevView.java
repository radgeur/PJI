package view;

/**
 * Class to instantiate a frame for the game at the developer view
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

import listeners.ActionKeyListener;

public class GameDevView implements Observer{
	private JFrame window;
	private DevPanel panel;
	private ToolBar toolbar;
	
	/** Constructor */
	public GameDevView(){
		//MyPanel
		panel = new DevPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setPreferredSize(new Dimension(500,550));
	    panel.setFocusable(true);
	    panel.requestFocus();
	    
	    panel.addKeyListener(new ActionKeyListener());
	    
	    //toolbar
	    toolbar = new ToolBar();
	    toolbar.setPreferredSize(new Dimension(200,550));
		
		//JFrame
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Tower Defense");
	    window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.X_AXIS));
	    window.getContentPane().add(panel);
	    window.getContentPane().add(toolbar);
	    window.setResizable(false);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	    window.pack();
	    window.setLocationRelativeTo(null);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		panel.repaint();
	}

}
