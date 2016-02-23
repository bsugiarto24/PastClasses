/**
 *SliderFrame
 *@author Bryan Sugiarto
 *@version Lab12
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderFrame extends JFrame{
	private JPanel colorPanel;
	private JSlider redSlider, greenSlider, blueSlider;

	public SliderFrame(){
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(300,300));
		getContentPane().add(colorPanel, BorderLayout.CENTER);
		createControlPanel();
		setSampleColor();
		pack();
	}

	public void createControlPanel(){
		class ColorListener implements ChangeListener{
			public void stateChanged(ChangeEvent event){
				setSampleColor();
			}
		}
		ChangeListener listener = new ColorListener();
		
		redSlider = new JSlider(0,100,25);
		redSlider.addChangeListener(listener);
		
		greenSlider = new JSlider(0,100,50);
		greenSlider.addChangeListener(listener);
		
		blueSlider = new JSlider(0,100,75);
		blueSlider.addChangeListener(listener);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,2));
		
		controlPanel.add(new JLabel("Red", SwingConstants.RIGHT));
		controlPanel.add(redSlider);
		
		controlPanel.add(new JLabel("Green", SwingConstants.RIGHT));
		controlPanel.add(greenSlider);
		
		controlPanel.add(new JLabel("Blue", SwingConstants.RIGHT));
		controlPanel.add(blueSlider);
		
		getContentPane().add(controlPanel,BorderLayout.SOUTH);	
	}
	
	public void setSampleColor(){
		float red = .01F*redSlider.getValue();
		float green = .01F*greenSlider.getValue();
		float blue = .01F*blueSlider.getValue();
		
		colorPanel.setBackground(new Color(red,green,blue));
	}
}
