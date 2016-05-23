package listeners;

/**
 * Listener to manage the color of the case on the map when a user try to put a defence on it
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapComponent.Case;

public class CaseListener implements MouseListener{
	//ATTRIBUTES
	private Case c;
	private JLabel label;
	private ImageIcon base;
	private ImageIcon canPut;
	private ImageIcon cannotPut;
	
	//METHODS
	/** Constructor
	 * @param c the case to manage
	 * @param label the picture
	 */
	public CaseListener(Case c, JLabel label, ImageIcon picture){
		super();
		this.c = c;
		this.base = picture;
		this.label = label;
		this.canPut = new ImageIcon("./media/grassCan.jpg");
		this.cannotPut = new ImageIcon("./media/grassCannot.jpg");
		label.setIcon(base);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(c.canPut())
			label.setIcon(canPut);
		else
			label.setIcon(cannotPut);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setIcon(base);
	}
	
}
