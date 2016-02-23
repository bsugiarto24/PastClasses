/**
 *ButtonTextField
 *@author Bryan Sugiarto
 *@version Lab12
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonTextField {

	public static void main(String[] args) {
		//make a frame and set closing behavior
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make stuff to add to frame
		JButton button = new JButton("Push Me!");
		JTextField text = new JTextField(15);
		text.setText("Hello World!");
		
		
		//add stuff to frame's content pane
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.add(button);
		contentPane.add(text);
		
		//change the layout
		contentPane.setLayout(new FlowLayout());
		
		frame.pack();
		frame.setVisible(true);
	}

}
