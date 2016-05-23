package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Result {
	private JFrame window;
	private JPanel panel;

	public Result(boolean victory) {
		panel = new JPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setPreferredSize(new Dimension(200,100));
		JLabel label = new JLabel();
		if(victory)
			label.setText("Victoire !");
		else 
			label.setText("Défaite !");
		panel.add(label);
		
		// JFrame
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Tower Defense");
		window.setLayout(new BoxLayout(window.getContentPane(),
				BoxLayout.X_AXIS));
		window.getContentPane().add(panel);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
	}
}
