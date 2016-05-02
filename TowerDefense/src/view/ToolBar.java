package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mapComponent.Map;
import entities.Defence;

/**
 * JPanel for the defence and others
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

public class ToolBar extends JPanel{

	//ATTRIBUTES
		private static final long serialVersionUID = 1L;
		protected static Defence putDefence = null;

		//METHODS
		@Override
		public void paintComponent(Graphics g){
			//create elements
			ImageIcon noSelec = new ImageIcon("./media/tourelle_selec.jpg");
			ImageIcon selec = new ImageIcon("./media/tourelle.jpg");
		    JLabel label = new JLabel(new ImageIcon("./media/tourelle.jpg"));
		    
		    //listeners
		    label.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					putDefence= new Defence(10, Map.casewidth-1, Map.caseHeight-1,5,5,true);
				}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					label.setIcon(noSelec);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					label.setIcon(selec);
				}
		    	
			});
		    
		    //add elements
			this.add(label);
			
		}
	
}
