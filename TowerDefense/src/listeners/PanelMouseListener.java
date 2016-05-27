package listeners;

/**
 * Listener to manage the map in the main panel
 * 
 * @author CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mapComponent.Case;
import mapComponent.Map;
import model.GameModel;
import view.ToolBar;

public class PanelMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(ToolBar.putDefence != null){
			Case c = GameModel.map.getCaseWithPixel(e.getX(), e.getY());
			if(!c.isWall()){
				ToolBar.putDefence.setX(c.getXInPixel());
				ToolBar.putDefence.setY(c.getYInPixel());
				Map.defencesToAdd.add(ToolBar.putDefence);
			}
			ToolBar.putDefence = null;
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

}