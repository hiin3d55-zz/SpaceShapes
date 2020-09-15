package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements a test case aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Dave Shin
 * 
 */
public class TestShapeWithText {
	
	// Fixture object that is used by the tests.
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
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.addText("Hi");
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(text: Hi, has been painted)(rectangle 100,20,25,35)"
				+ "(text: Hi, has been painted)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.addText("Hi");
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(text: Hi, has been painted)(rectangle 100,20,25,35)"
				+ "(text: Hi, has been painted)(rectangle 110,35,25,35)"
				+ "(text: Hi, has been painted)(rectangle 98,50,25,35)", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.addText("Bye");
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(text: Bye, has been painted)(rectangle 10,20,25,35)"
				+ "(text: Bye, has been painted)(rectangle 0,35,25,35)"
				+ "(text: Bye, has been painted)(rectangle 12,50,25,35)", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.addText("Fight me");
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(text: Fight me, has been painted)(rectangle 10,90,25,35)"
				+ "(text: Fight me, has been painted)(rectangle 0,100,25,35)"
				+ "(text: Fight me, has been painted)(rectangle 12,85,25,35)", 
				_painter.toString());
	}
}
