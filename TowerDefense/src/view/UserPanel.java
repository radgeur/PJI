package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;
import entities.Entity;

/**
 * JPanel for the map at the user view
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class UserPanel extends JPanel{
	//ATTRIBUTES
	private static final long serialVersionUID = 1L;

	//METHODS
	@Override
	public void paintComponent(Graphics graph){
		this.removeAll();	    
		Map map = GameModel.map;
		for(Entity ent : map.getEntities()){
			//is the entity is a defence
			if(ent.isDefense()){
				//if this is the nexus
				if(ent == map.getNexus()){
					JLabel nexus = new JLabel(new ImageIcon("./media/nexus.png"));
					nexus.setBounds(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
					this.add(nexus);
				}
				//if this is any defence
				else{
					JLabel defence = new JLabel(new ImageIcon("./media/tourelle.png"));
					defence.setBounds(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
					this.add(defence);
				}
			}
			//else this is not a defence
			else {
				//if this is not a monster
				if(ent.getFriendly()){
					JLabel hero = new JLabel(new ImageIcon("./media/hero.png"));
					hero.setBounds(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
					this.add(hero);
				} else {
					JLabel monster = new JLabel(new ImageIcon("./media/monster.png"));
					monster.setBounds(ent.getX(), ent.getY(), ent.getWidth(), ent.getHeight());
					this.add(monster);
				}
			}
		}
		//wall and ground pictures
		this.setLayout(null);
		ImageIcon wallPicture = new ImageIcon("./media/wall.jpg");
		ImageIcon groundPicture = new ImageIcon("./media/ground.jpg");
	    super.paintComponent(graph);
		for(int i = 0; i<map.getMap().length; i++){
			for(int j = 0; j<map.getMap()[0].length; j++){
				Case c = map.getMap()[i][j];
				if(c.isWall()){
					JLabel wall = new JLabel(wallPicture);
					wall.setBounds(c.getX()*Map.casewidth, c.getY()*Map.caseHeight, Map.casewidth, Map.caseHeight);
					this.add(wall);
				} else {
					JLabel ground = new JLabel(groundPicture);
					ground.setBounds(c.getX()*Map.casewidth, c.getY()*Map.caseHeight, Map.casewidth, Map.caseHeight);
					this.add(ground);
				}
			}
		}
		
		
		
		if(map.isFinished()){
			graph.setColor(Color.RED);
			if(map.getNexus().getHP() > 0)
				graph.drawString("Gagné!!!",200, 300);
			else
				graph.drawString("Perdu!!!",200, 300);
		}
	}
}
