package keyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class listen the key action to know the character action desired.
 * @author  CHARNEUX Dimitri, LEPRETRE Rémy 
 *
 */
public class ActionKeyListener implements KeyListener{
	public static CharacterAction lastAction = CharacterAction.NO_ACTION;
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped : " + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed : " + e.getKeyChar());
		switch (e.getKeyChar()) {
		case 'z':
			ActionKeyListener.lastAction = CharacterAction.MOVE_TOP;
			break;
		case 'q':
			ActionKeyListener.lastAction = CharacterAction.MOVE_LEFT;
			break;
		case 's':
			ActionKeyListener.lastAction = CharacterAction.MOVE_BOTTOM;
			break;
		case 'd':
			ActionKeyListener.lastAction = CharacterAction.MOVE_RIGHT;
			break;
		case ' ':
			ActionKeyListener.lastAction = CharacterAction.ATTACK;
			break;
		default : 
			ActionKeyListener.lastAction = CharacterAction.NO_ACTION;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased : " + e.getKeyChar());
	}
}
