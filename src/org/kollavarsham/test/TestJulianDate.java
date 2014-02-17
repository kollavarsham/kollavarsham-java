package org.kollavarsham.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kollavarsham.JulianDate;

public class TestJulianDate {
 
	JulianDate jD;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		jD = new JulianDate(2012, 12,31);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
	    //assertEquals(jD.toString(), "2013 12 31");
	    assertEquals("0001 01 01", new JulianDate(1,1,1).toString());
	}

	@Test
	public void testConstructor() {
	    assertEquals(jD.getYear(), 2012, 0);
	    assertEquals(jD.getMonth(), 12, 0);
	    assertEquals(jD.getDay(), 31, 0);
	}

}
