package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	
	/**
	 * Fields.
	 */
	private StringBuffer _log = new StringBuffer();	// Internal log.
	private Color _color = new Color(212, 212, 212);

	public MockPainter() {
	}
	
	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}
	
	/**
	 * Logs the drawHexagon call.
	 */
	public void drawHexagon(int x, int y, int width, int height) {
		_log.append("(hexagon " + x + "," + y + "," + width + "," + height + ")");
		
		// The top-left and bottom-left vertices of a Hexagon are normally 20 pixels 
		// to the right of the left hand side of the bounding box. Similarly, the 
		// top-right and bottom-right vertices of a Hexagon are normally 20 pixels to 
		// the left of the right hand side of the bounding box.
		if (width >= 40) {
			_log.append("(regular hexagon. line sequence: "
					+ "(" + x + "," + (y + (height / 2)) + ") to "
					+ "(" + (x + 20) + "," + y + ") to "
					+ "(" + (x + width - 20) + "," + y + ") to "
					+ "(" + (x + width) + "," + (y + (height / 2)) + ") to "
					+ "(" + (x + width - 20) + "," + (y + height) + ") to "
					+ "(" + (x + 20) + "," + (y + height) + ") to "
					+ "(" + x + "," + (y + (height / 2)) + "))");
		
		// However, if the width of a Hexagon is less than 40 pixels, the top-left and 
		// top-right vertices are both positioned at point (x+width/2, y). Similarly, 
		// the bottom-left and bottom-right vertices are both positioned at point 
		// (x+width/2, y+height). In other words, ¡°small¡± Hexagons are four-sided figures.	
		} else if (width < 40) {
			_log.append("(small hexagon. line sequence: "
					+ "(" + x + "," + (y + (height / 2)) + ") to "
					+ "(" + (x + (width / 2)) + "," + y + ") to "
					+ "(" + (x + width) + "," + (y + (height / 2)) + ") to "
					+ "(" + (x + (width / 2)) + "," + (y + height) + ") to "
					+ "(" + x + "," + (y + (height / 2)) + "))");
		}
	}
	
	/**
	 * Logs the drawImage call.
	 */
	public void drawImage(Image img, int x, int y, int width, int height) {
		_log.append("(Image painted)");
	}
		
	/**
	 * Calls the drawRect method and logs the fillRect call.
	 */
	public void fillRect(int x, int y, int width, int height) {
		drawRect(x, y, width, height);
		_log.append(" => filled with: " + _color + " ");
	}
	
	public Color getColor() {
		return _color;
	}
	
	/**
	 * Logs the setColor call.
	 */
	public void setColor(Color color) {
		_color = color;
		_log.append("(color set to: " + _color + ")");
	}
	
	public void translate(int x, int y) {
	}
	
	/**
	 * Logs the drawCentredText call.
	 */
	public void drawCentredText(int shapeX, int shapeY, int shapeWidth, int shapeHeight, String text) {
		_log.append("(text: " + text + ", has been painted)");
	}
}