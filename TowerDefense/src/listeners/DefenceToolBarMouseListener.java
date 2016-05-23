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

public class DefenceToolBarMouseListener implements MouseListener{
	//ATTRIBUTES
	private Defence defence;
	private ImageIcon imageSelec;
	private ImageIcon imageNoSelec;
	private JLabel label;
	
	//METHODS
	public DefenceToolBarMouseListener(Defence defence, JLabel label){
		super();
		this.defence = defence;
		this.imageSelec = new ImageIcon("./media/tourelleSelec_toolbar.png");
		this.imageNoSelec = new ImageIcon("./media/tourelle_toolbar.png");;
		this.label = label;
		label.setIcon(imageNoSelec);
		label.setToolTipText(defence.toString());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ToolBar.putDefence = new Defence(defence.getHP(), defence.getWidth(), defence.getHeight(), defence.getRange(), defence.getPower(), defence.getFriendly(), defence.getPicture());
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
