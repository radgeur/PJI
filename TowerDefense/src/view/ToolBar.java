package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.DefenceToolBarMouseListener;
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
		    JLabel labelDefence1 = new JLabel();
		    Defence defence1 = new Defence(50, Map.casewidth-1, Map.caseHeight-1,5,5,true,new ImageIcon("./media/tourelle.png"));
		    defence1.setActStrategy(new NoActionActStrategy());
		    
		    //listeners
		    labelDefence1.addMouseListener(new DefenceToolBarMouseListener(defence1, labelDefence1));
		    
		    //add elements
			this.add(labelDefence1);
			
		}
	
}
