package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Entity;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;

public class GameView implements Observer{
	private JFrame window;
	private MyPanel panel;
	
	public GameView(){
		window = new JFrame();
	    window.setTitle("Tower Defense");
	    window.setSize(500, 550);
	    window.setLocationRelativeTo(null);
	    panel = new MyPanel();
	    panel.setBackground(Color.WHITE);
	    window.setContentPane(panel);
	    window.setResizable(false);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		panel.repaint();
	}
	
	private class MyPanel extends JPanel{
		public void paintComponent(Graphics graph){
		    super.paintComponent(graph);
		    System.out.println("repaint");
		    Map map = GameModel.map;
			for(int i = 0; i<map.getMap().length; i++){
				for(int j = 0; j<map.getMap()[0].length; j++){
					Case c = map.getMap()[i][j];
					if(c.isWall()){
						graph.setColor(Color.BLACK);
						graph.drawRect(c.getX()*100, c.getY()*100, 100, 100);
					}
				}
			}
			
			for(Entity ent : map.getEntities()){
				graph.setColor(Color.BLUE);
				graph.drawRect(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
				graph.drawString(ent.getHP() + "/" + ent.getMaxHP(),ent.getX(), ent.getY());
			}
			
			if(map.isFinished()){
				graph.setColor(Color.RED);
				if(map.getNexus().getHP() > 0)
					graph.drawString("Gagné!!!",200, 200);
				else
					graph.drawString("Perdu!!!",200, 200);
			}
				
		}
	}

}
