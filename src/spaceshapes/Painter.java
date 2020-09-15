package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * Edited by Dave Shin
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * hexagon. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * rectangle that surrounds the oval. Parameters width and height specify 
	 * its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Draws a hexagon. Parameters x and y specify the top left corner of the
	 * rectangle that surrounds the hexagon. Parameters width and height specify 
	 * its width and height.
	 * The top-left and bottom-left vertices of a Hexagon are normally 20 pixels 
	 * to the right of the left hand side of the bounding box. Similarly, the 
	 * top-right and bottom-right vertices of a Hexagon are normally 20 pixels to 
	 * the left of the right hand side of the bounding box. However, if the width 
	 * of a Hexagon is less than 40 pixels, the top-left and top-right vertices 
	 * are both positioned at point (x+width/2, y). Similarly, the bottom-left and 
	 * bottom-right vertices are both positioned at point (x+width/2, y+height). 
	 * In other words, ¡°small¡± Hexagons are four-sided figures.
	 */
	public void drawHexagon(int x, int y, int width, int height);
	
	/**
	 * Allows java.awt.Image objects to be painted.
	 */
	public void drawImage(Image img, int x, int y, int width, int height);
	
	/**
	 * Fills in the rectangle at a specified location with specified dimensions
	 * with a specified color.
	 */
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Gets the color stored in the instance of Graphics.
	 */
	public Color getColor();
	
	/**
	 * Sets the one color that will be stored in the instance of Graphics.
	 */
	public void setColor(Color color);
	
	/**
	 * Translate the origin of the coordinate system of the instanec of Graphics.
	 */
	public void translate(int x, int y);
	
	/**
	 * Draw the specified text on the centre of the shape.
	 */
	public void drawCentredText(int shapeX, int shapeY, int shapeWidth, int shapeHeight, String text);
}
