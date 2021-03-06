/**
 *Shape interface to represent all 2d shapes for canvas
 *@author Bryan Sugiarto
 *@version program3
 */
 
public interface Shape{
   /*
    * A sentence (must be terminated with a period, '.') describing at a high level what
    * this method does.  The first sentence will be part of the brief description that is
    * generated by the javadoc tool. Any additional text will be part of the detailed
    * description.
    *
    * @param someValue A description of what this parameter is for.  Should include 
    * restriction, if any, on the values passed in.
    *
    * @param anotherValue A description of what this parameter is for.  Should include 
    * restriction, if any, on the values passed in.
    *
    * @return A description of what value(s) are returned and under what specific
    * circumstances.
    *
    * @throws InvalidArgumentException describe when this exception is thrown by the
    * method.
    */
	
	/**
	  *Returns area of the shape.
	  *
	  * @return double of the shape's area
	  *
	  */
   public double getArea();
   
   /**
    *Returns color of the shape.
    *
    * @return Color of the shape.
    *
    */
   public java.awt.Color getColor();
   
   /**
    * Sets Color of the shape to color passed in.
    * 
    * @param color Color the shape is set to. Cannot be null.
    *
    * @throws InvalidArgumentException when the shape is null.
    */
   public void setColor(java.awt.Color color);
   
   /**
    * Returns a boolean whether the shape is filled or not.
    *
    * @return true if the shape is filled.
    */
   public boolean getFilled(); 
   
   /**
    * Sets the filled value to the parameter passed in.
    * 
    * @param filled A boolean to represent filled.
    *
    */
   public void setFilled(boolean filled);
   
   /**
    * Returns a java.awt.Point which represents the objects's position.
    *
    * @return A Point which represents the shape's position.
    */
   public java.awt.Point getPosition();
   
   /**
    *Sets the position value to parameter passed in.
    *
    * @param position A Point to set the shape's position to. Cannot be null.
    *
    * @throws InvalidArgumentException if position is null.
    */
   public void setPosition(java.awt.Point position);
   
   /**
    * Moves the position of the shape by the x,y components of delta
    *
    * @param delta A point which has the x,y values to move the shape by
    * 
    * @throws InvalidArgumentException if delta is null.
    */
   public void move(java.awt.Point delta);
 
 }