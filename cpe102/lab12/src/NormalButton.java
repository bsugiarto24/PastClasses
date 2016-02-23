/**
 *Normal Button
 *@author Bryan Sugiarto
 *@version Lab12
 */

import java.awt.FlowLayout;

import javax.swing.*;

public class NormalButton {

	public static void main(String[] args) {
		//make a frame and set closing behavior
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make stuff to add to frame
		JButton button = new JButton("Push Me!");
		
		//add stuff to frame's content pane
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.add(button);
		
		contentPane.setLayout(new FlowLayout());
		
		frame.pack();
		frame.setVisible(true);
	}

}
