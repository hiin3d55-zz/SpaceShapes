package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.FontMetrics; 

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * Edited by Dave Shin
 */
public class GraphicsPainter implements Painter {
	
	/**
	 * Delegate object.
	 */
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * @see spaceshapes.Painter.drawHexagon.
	 */
	public void drawHexagon(int x, int y, int width, int height) {
		if (width >= 40) {
			drawLine(x, y + (height / 2), x + 20, y);
			drawLine(x + 20, y, (x + width) - 20, y);
			drawLine((x + width) - 20, y, x + width, y + (height / 2));
			drawLine(x + width, y + (height / 2), (x + width) - 20, y + height);
			drawLine((x + width) - 20, y + height, x + 20, y + height);
			drawLine(x + 20, y + height, x, y + (height / 2));
		} else if (width < 40) {
			drawLine(x, y + (height / 2), x + (width / 2), y);
			drawLine(x + (width / 2), y, x + width, y + (height / 2));
			drawLine(x + width, y + (height / 2), x + (width / 2), y + height);
			drawLine(x + (width / 2), y + height, x, y + (height / 2));
		}
	}
	
	/**
	 * @see spaceshapes.Painter.drawImage.
	 */
	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
	}
	
	/**
	 * @see spaceshapes.Painter.fillRect.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}
	
	/**
	 * @see spaceshapes.Painter.getColor.
	 */
	public Color getColor() {
		return _g.getColor();
	}
	
	/**
	 * spaceshapes.Painter.setColor.
	 */
	public void setColor(Color color) {
		_g.setColor(color);
	}
	
	/**
	 * spaceshapes.Painter.translate.
	 */
	public void translate(int x, int y) {
		_g.translate(x, y);
	}
	
	/**
	 * spaceshapes.Painter.drawCentredText.
	 */
	public void drawCentredText(int shapeX, int shapeY, int shapeWidth, int shapeHeight, String text) {
		FontMetrics metrics = _g.getFontMetrics();
		int textX = shapeX + (shapeWidth / 2) - (metrics.stringWidth(text) / 2);
		int textY = shapeY + (shapeHeight / 2);
		// Check if ascent or descent is greater and perform relevant changes to the Y coordinate
		// so that the text is centred.
		if (metrics.getAscent() > metrics.getDescent()) {
			textY = textY + (metrics.getAscent() - metrics.getDescent()) / 2;
		} else if (metrics.getAscent() < metrics.getAscent()) {
			textY = textY - (metrics.getDescent() - metrics.getAscent()) / 2;
		}
		_g.drawString(text, textX, textY);
	}
}
