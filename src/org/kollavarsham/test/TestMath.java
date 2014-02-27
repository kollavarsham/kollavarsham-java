package org.kollavarsham.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.kollavarsham.math;

public class TestMath {
    math testmath;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        testmath = new math();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsNumber() {
        assertTrue(testmath.isNumber("12345"));
        assertTrue(testmath.isNumber("123.23"));
        assertFalse(testmath.isNumber("abcdef"));
        assertTrue(testmath.isNumber("1234567"));
        assertFalse(testmath.isNumber("123abd"));
    }

    @Test
    public void testIsInt() {
        assertTrue(testmath.isInt("12345"));
        assertFalse(testmath.isInt("12345.123"));
        assertFalse(testmath.isInt("123.23"));
    }

    @Test
    public void testTruncateDecimals() {
        assertEquals(123.23, testmath.truncateDecimals(123.23232323, 2), 0);
        assertEquals(56789.123, testmath.truncateDecimals(56789.1234567, 3), 0);
    }

    @Test
    public void testTruncate() {
        assertEquals(123.0, testmath.truncate(123.23232323), 0);
        assertEquals(56789.0, testmath.truncate(56789.123456), 0);
    }

    @Test
    public void testFloor() {
        assertEquals(123.0, testmath.floor(123.999), 0);
        assertEquals(-1.0, testmath.floor(-0.44), 0);
        assertEquals(-123.0, testmath.floor(-122.43), 0);
    }

    @Test
    public void testFractional() {
        assertEquals(0.999, testmath.fractional(123.999), .01);
        assertEquals(-0.44, testmath.fractional(-0.44), 0.01);
        assertEquals(-0.43, testmath.fractional(-122.43), 0.01);
    }

    @Test
    public void testRound() {
        assertEquals(1.0, testmath.round(0.54), 0);
        assertEquals(23.0, testmath.round(23.49), 0);
        assertEquals(-23.0, testmath.round(-23.49), 0);
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
        assertEquals(144.0, testmath.square(12.0), 0);
        assertEquals(625, testmath.square(25), 0);
    }

}
