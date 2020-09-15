package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and HexagonShape.
 * 
 * @author Dave Shin
 * 
 */
public class TestHexagonShape {

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
	 * Test to check if the ¡°small¡± Hexagon instance is constructed correctly.
	 */
	@Test
	public void testConstructionForSmallHexagon() {
		HexagonShape smallShape = new HexagonShape(50, 35, 15, 30, 16, 30);
		smallShape.paint(_painter);
		assertEquals("(hexagon 50,35,16,30)(small hexagon. line sequence: "
				+ "(50,50) to (58,35) to (66,50) to (58,65) to (50,50))",
				_painter.toString());
	}

	/**
	 * Test to check if the ¡°regular¡± Hexagon instance is constructed correctly.
	 */
	@Test
	public void testConstructionForRegularHexagon() {
		HexagonShape bigShape = new HexagonShape(60, 55, 15, 30, 50, 40);
		bigShape.paint(_painter);
		assertEquals("(hexagon 60,55,50,40)(regular hexagon. line sequence: "
				+ "(60,75) to (80,55) to (90,55) to (110,75) to "
				+ "(90,95) to (80,95) to (60,75))",
				_painter.toString());
	}
	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(hexagon 100,20,25,35)(small hexagon. line sequence: "
				+ "(100,37) to (112,20) to (125,37) to (112,55) to (100,37))"
				+ "(hexagon 112,35,25,35)(small hexagon. line sequence: "
				+ "(112,52) to (124,35) to (137,52) to (124,70) to (112,52))", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(hexagon 100,20,25,35)(small hexagon. line sequence: "
				+ "(100,37) to (112,20) to (125,37) to (112,55) to (100,37))"
				+ "(hexagon 110,35,25,35)(small hexagon. line sequence: "
				+ "(110,52) to (122,35) to (135,52) to (122,70) to (110,52))"
				+ "(hexagon 98,50,25,35)(small hexagon. line sequence: "
				+ "(98,67) to (110,50) to (123,67) to (110,85) to (98,67))", 
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(hexagon 10,20,25,35)(small hexagon. line sequence: "
				+ "(10,37) to (22,20) to (35,37) to (22,55) to (10,37))"
				+ "(hexagon 0,35,25,35)(small hexagon. line sequence: "
				+ "(0,52) to (12,35) to (25,52) to (12,70) to (0,52))"
				+ "(hexagon 12,50,25,35)(small hexagon. line sequence: "
				+ "(12,67) to (24,50) to (37,67) to (24,85) to (12,67))",
				_painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(hexagon 10,90,25,35)(small hexagon. line sequence: "
				+ "(10,107) to (22,90) to (35,107) to (22,125) to (10,107))"
				+ "(hexagon 0,100,25,35)(small hexagon. line sequence: "
				+ "(0,117) to (12,100) to (25,117) to (12,135) to (0,117))"
				+ "(hexagon 12,85,25,35)(small hexagon. line sequence: "
				+ "(12,102) to (24,85) to (37,102) to (24,120) to (12,102))", 
				_painter.toString());
	}
}

