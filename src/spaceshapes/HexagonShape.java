package spaceshapes;

/**
 * Class to represent a simple hexagon space-shape.
 * 
 * @author Dave Shin 
 */
public class HexagonShape extends Shape {
	/**
	 * Default constructor that creates a HexagonShape instance whose instance
	 * variables are set to default values.
	 */
	public HexagonShape() {
		super();
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public HexagonShape(int x, int y) {
		super(x, y);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, 
			int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public HexagonShape(int x, int y, int deltaX, int deltaY, int width, 
			int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Paints this HexagonShape object using the supplied Painter object.
	 */
	protected void doPaint(Painter painter) {
		painter.drawHexagon(_x,_y,_width,_height);
	}
}
