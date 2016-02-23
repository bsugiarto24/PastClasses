/**
 *Frame
 *@author Bryan Sugiarto
 *@version Lab12
 */

import javax.swing.*;

public class Frame {

	public static void main(String args[]){
		//Make a frame.
		JFrame frame = new JFrame();
		
		//Set closing behavior
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//In general, do these two things last...
		frame.pack();
		frame.setVisible(true);
	}

}
