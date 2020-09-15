package spaceshapes;

import java.awt.Color;

/**
 * Class to represent a rectangular space-shape that:
 * - Paints itself as a solid figure in the color specified at construction time after 
 *   it bounces off the left or right wall.
 * - Switches its appearance to that of the original unfilled Rectangle after it bounces
 *   off the top or bottom wall.
 * 
 * @author Dave Shin
 */
public class DynamicShape extends Shape {

	// The default color is white.
	private Color _color = Color.white; 
	// Indicates whether to fill the shape with color or not.
	private boolean _fillColor = false; 

	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicShape() {
		super();
	}

	/**
	 * Creates a DynamicShape object with a specified x and y position.
	 */
	public DynamicShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a DynamicShape object with a specified x and y position and color.
	 */
	public DynamicShape(Color color, int x, int y) {
		super(x, y);
		_color = color;
	}
	
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param colour color of the shape.
	 */
	public DynamicShape(Color color, int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
		_color = color;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param color color of the shape.
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, 
			int width, int height, Color color) {
		super(x,y,deltaX,deltaY,width,height);
		_color = color;
	}

	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, 
			int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, 
			int height, String text, Color color) {
		super(x, y, deltaX, deltaY, width, height, text);
		_color = color;
	}

	/**
	 * Paints this DynamicShape object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {
		// When we want to fill in with color.
		if (_fillColor) { 
			Color originalColor = painter.getColor(); // Keep the record of the original color.
			painter.setColor(_color);
			painter.fillRect(_x,_y,_width,_height);
			painter.setColor(originalColor); // Set the color back to the original color.
		// When we don't want to fill in with color.	
		} else if (!_fillColor) {
			painter.drawRect(_x,_y,_width,_height);
		}
	}

	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. The shape gets filled with the specified colour
	 * if the shape hits the left or right boundary and returns to its 
	 * original unfilled shape when it hits the top or bottom boundary.
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		// Keep the record of the velocities before the move.
		int lastDeltaX = _deltaX;
		int lastDeltaY = _deltaY;
		
		super.move(width, height);
		// If deltaX changed sign, it means that the shape has hit the left or right
		// wall. In such case, make _fillColor true so that the shape can be filled 
		// with color. Do the zero check because negative zero is equal to zero.
		if (_deltaY != 0 && _deltaY == -lastDeltaY) {
			_fillColor = false;
		} else if (_deltaX != 0 && _deltaX == -lastDeltaX) {
			_fillColor = true;
		}
	}
}
