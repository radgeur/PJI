package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class GameView implements Observer{
	private JFrame window;
	private MyPanel panel;
	
	public GameView(){
		window = new JFrame();
	    window.setTitle("Tower Defense");
	    window.setSize(500, 550);
	    window.setLocationRelativeTo(null);
	    panel = new MyPanel();
	    panel.setBackground(Color.WHITE);
	    window.setContentPane(panel);
	    window.setResizable(false);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		panel.repaint();
	}

}
