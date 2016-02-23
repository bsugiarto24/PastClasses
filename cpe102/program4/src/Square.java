/**
 *Square class to represent 2d Square for canvas
 *@author Bryan Sugiarto
 *@version program4
 */

import java.awt.*;

public class Square extends Rectangle{

	public Square(int sideLength, java.awt.Point position,
			java.awt.Color color, boolean filled){
		super(sideLength,sideLength,position,color,filled);
	}
	
	public int getSize(){
		return super.getHeight();
	}
	public void setSize(int side){
		super.setHeight(side);
		super.setWidth(side);
	}
    public void setWidth(int width) {
    	setSize(width);
    }
    public void setHeight(int height){
    	setSize(height);
    } 
	
}
