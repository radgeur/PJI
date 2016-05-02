package view;

/**
 * Class to instantiate a frame for the game
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;

public class GameView implements Observer{
	private JFrame window;
	private MyPanel panel;
	private ToolBar toolbar;
	private Map map;
	
	/** Constructor */
	public GameView(){
		map = GameModel.map;
		//MyPanel
		panel = new MyPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setPreferredSize(new Dimension(500,550));
	    panel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(ToolBar.putDefence != null){
					Case c = map.getCaseWithPixel(e.getX(), e.getY());
					if(!c.isWall()){
						ToolBar.putDefence.setX(c.getXInPixel());
						ToolBar.putDefence.setY(c.getYInPixel());
						Map.defencesToAdd.add(ToolBar.putDefence);
						ToolBar.putDefence = null;
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
	    	
	    });
	    
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
