package listeners;

/**
 * Listener for the defence in the toolBar
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.ToolBar;
import entities.Defence;

public class DefenceMouseListener implements MouseListener{
	//ATTRIBUTES
	private Defence defence;
	private ImageIcon imageSelec;
	private ImageIcon imageNoSelec;
	private JLabel label;
	
	//METHODS
	public DefenceMouseListener(Defence defence, ImageIcon imageSelec, ImageIcon imageNoSelec, JLabel label){
		this.defence = defence;
		this.imageSelec = imageSelec;
		this.imageNoSelec = imageNoSelec;
		this.label = label;
		label.setIcon(imageNoSelec);
		label.setToolTipText(defence.toString());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ToolBar.putDefence = new Defence(defence.getHP(), defence.getWidth(), defence.getHeight(), defence.getRange(), defence.getPower(), defence.getFriendly());
		ToolBar.putDefence.setActStrategy(defence.getActStrategy());
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setIcon(imageSelec);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setIcon(imageNoSelec);
	}

}
