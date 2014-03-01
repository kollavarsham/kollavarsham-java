package org.kollavarsham.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.kollavarsham.KollavarshamMath;

public class MathTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsNumber() {
        assertTrue(KollavarshamMath.isNumber("12345"));
        assertTrue(KollavarshamMath.isNumber("123.23"));
        assertFalse(KollavarshamMath.isNumber("abcdef"));
        assertTrue(KollavarshamMath.isNumber("1234567"));
        assertFalse(KollavarshamMath.isNumber("123abd"));
    }

    @Test
    public void testIsInt() {
        assertTrue(KollavarshamMath.isInt("12345"));
        assertFalse(KollavarshamMath.isInt("12345.123"));
        assertFalse(KollavarshamMath.isInt("123.23"));
    }

    @Test
    public void testTruncateDecimals() {
        assertEquals(123.23, KollavarshamMath.truncateDecimals(123.23232323, 2), 0);
        assertEquals(56789.123, KollavarshamMath.truncateDecimals(56789.1234567, 3), 0);
    }

    @Test
    public void testTruncate() {
        assertEquals(123.0, KollavarshamMath.truncate(123.23232323), 0);
        assertEquals(56789.0, KollavarshamMath.truncate(56789.123456), 0);
    }

    @Test
    public void testFloor() {
        assertEquals(123.0, KollavarshamMath.floor(123.999), 0);
        assertEquals(-1.0, KollavarshamMath.floor(-0.44), 0);
        assertEquals(-123.0, KollavarshamMath.floor(-122.43), 0);
    }

    @Test
    public void testFractional() {
        assertEquals(0.999, KollavarshamMath.fractional(123.999), .01);
        assertEquals(-0.44, KollavarshamMath.fractional(-0.44), 0.01);
        assertEquals(-0.43, KollavarshamMath.fractional(-122.43), 0.01);
    }

    @Test
    public void testRound() {
        assertEquals(1.0, KollavarshamMath.round(0.54), 0);
        assertEquals(23.0, KollavarshamMath.round(23.49), 0);
        assertEquals(-23.0, KollavarshamMath.round(-23.49), 0);
    }

	/* Commenting out getters/setters as there is no logic to test here
     * @Test
	public void testGetEpsilon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEpsilon() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRadianMultiplier() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRadianMultiplier() {
		fail("Not yet implemented");
	}*/

    @Test
    public void testSquare() {
        assertEquals(144.0, KollavarshamMath.square(12.0), 0);
        assertEquals(625, KollavarshamMath.square(25), 0);
    }

}
