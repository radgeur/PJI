package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.DefenceMouseListener;
import mapComponent.Map;
import strategy.actStrategy.NoActionActStrategy;
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
		public static Defence putDefence = null;

		//METHODS
		@Override
		public void paintComponent(Graphics g){
			//create elements
			////Defence1
			ImageIcon selec = new ImageIcon("./media/tourelleSelec_toolbar.png");
			ImageIcon noSelec = new ImageIcon("./media/tourelle_toolbar.png");
		    JLabel labelDefence1 = new JLabel();
		    Defence defence1 = new Defence(10, Map.casewidth-1, Map.caseHeight-1,5,5,true);
		    defence1.setActStrategy(new NoActionActStrategy());
		    
		    //listeners
		    labelDefence1.addMouseListener(new DefenceMouseListener(defence1, selec, noSelec, labelDefence1));
		    
		    //add elements
			this.add(labelDefence1);
			
		}
	
}
