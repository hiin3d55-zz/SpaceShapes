package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and DynamicShape.
 * 
 * @author Dave Shin
 * 
 */
public class TestDynamicShape {

	/**
	 * Fixture object that is used by the tests.
	 */
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)"
				+ "(rectangle 112,35,25,35)", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		DynamicShape shape = new DynamicShape(Color.blue, 100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(color set to: java.awt.Color[r=0,g=0,b=255])"
				+ "(rectangle 110,35,25,35) => filled with: java.awt.Color[r=0,g=0,b=255] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])"
				+ "(color set to: java.awt.Color[r=0,g=0,b=255])"
				+ "(rectangle 98,50,25,35) => filled with: java.awt.Color[r=0,g=0,b=255] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		DynamicShape shape = new DynamicShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,25,35)(color set to: java.awt.Color[r=255,g=255,b=255])"
				+ "(rectangle 0,35,25,35) => filled with: java.awt.Color[r=255,g=255,b=255] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])"
				+ "(color set to: java.awt.Color[r=255,g=255,b=255])"
				+ "(rectangle 12,50,25,35) => filled with: java.awt.Color[r=255,g=255,b=255] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottom() {
		DynamicShape shape = new DynamicShape(Color.red, 10, 55, 0, 20);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 10,55,25,35)"
				+ "(rectangle 10,65,25,35)"
				+ "(rectangle 10,45,25,35)",
				_painter.toString());
	}

	@Test 
	public void testShapeMoveWithBounceOffTop() {
		DynamicShape shape = new DynamicShape(Color.red, 10, 10, 0, -20);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,25,35)"
				+ "(rectangle 10,0,25,35)"
				+ "(rectangle 10,20,25,35)",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the top-most and right-most 
	 * boundary and to ensure that the Shape's position after the movement 
	 * is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopThenRight() {
		DynamicShape shape = new DynamicShape(Color.orange, 45, 19, 16, -20);
		shape.paint(_painter);
		shape.move(100, 100);
		shape.paint(_painter);
		shape.move(100, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 45,19,25,35)(rectangle 61,0,25,35)"
				+ "(color set to: java.awt.Color[r=255,g=200,b=0])"
				+ "(rectangle 75,20,25,35) => filled with: java.awt.Color[r=255,g=200,b=0] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])"
				+ "(color set to: java.awt.Color[r=255,g=200,b=0])"
				+ "(rectangle 59,40,25,35) => filled with: java.awt.Color[r=255,g=200,b=0] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top-most and left-most 
	 * boundary and to ensure that the Shape's position after the movement 
	 * is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeftThenTop() {
		DynamicShape shape = new DynamicShape(Color.orange, 20, 38, -20, -20);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		shape.move(10000, 100);
		shape.paint(_painter);
		assertEquals("(rectangle 20,38,25,35)(color set to: java.awt.Color[r=255,g=200,b=0])"
				+ "(rectangle 0,18,25,35) => filled with: java.awt.Color[r=255,g=200,b=0] "
				+ "(color set to: java.awt.Color[r=212,g=212,b=212])"
				+ "(rectangle 20,0,25,35)"
				+ "(rectangle 40,20,25,35)", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct. We assume
	 * that when the shape hits the corner, and therefore hits both vertical and 
	 * horizontal walls simultaneously, removing the color from the shape has a 
	 * higher priority over filling the color.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		DynamicShape shape = new DynamicShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,25,35)"
				+ "(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top left corner and to
	 * ensure that the Shape's position after the movement is correct. We assume
	 * that when the shape hits the corner, and therefore hits both vertical and 
	 * horizontal walls simultaneously, removing the color from the shape has a 
	 * higher priority over filling the color.
	 */
	@Test
	public void testShapeMoveWithBounceOffTopAndleft() {
		DynamicShape shape = new DynamicShape(10, 10, -12, -15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,10,25,35)"
				+ "(rectangle 0,0,25,35)"
				+ "(rectangle 12,15,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct. We assume
	 * that when the shape hits the corner, and therefore hits both vertical and 
	 * horizontal walls simultaneously, removing the color from the shape has a 
	 * higher priority over filling the color.
	 */
	@Test 
	public void testShapeMoveWithBounceOffBottomAndRight() {
		DynamicShape shape = new DynamicShape(97, 95, 12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 97,95,25,35)"
				+ "(rectangle 100,100,25,35)"
				+ "(rectangle 88,85,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct. We assume
	 * that when the shape hits the corner, and therefore hits both vertical and 
	 * horizontal walls simultaneously, removing the color from the shape has a 
	 * higher priority over filling the color.
	 */
	@Test 
	public void testShapeMoveWithBounceOffTopAndRight() {
		DynamicShape shape = new DynamicShape(97, 10, 12, -15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 97,10,25,35)"
				+ "(rectangle 100,0,25,35)"
				+ "(rectangle 88,15,25,35)", 
				_painter.toString());
	}
}

