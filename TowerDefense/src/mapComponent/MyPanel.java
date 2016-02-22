package mapComponent;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.GameModel;
import entities.Entity;

public class MyPanel extends JPanel{
		public void paintComponent(Graphics graph){
		    super.paintComponent(graph);
		    System.out.println("repaint");
		    Map map = GameModel.map;
			for(int i = 0; i<map.getMap().length; i++){
				for(int j = 0; j<map.getMap()[0].length; j++){
					Case c = map.getMap()[i][j];
					if(c.isWall()){
						graph.setColor(Color.BLACK);
						graph.drawRect(c.getX()*map.caseHeight, c.getY()*map.casewidth, map.caseHeight, map.casewidth);
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