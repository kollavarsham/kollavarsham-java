package org.kollavarsham.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.kollavarsham.calculations;
import org.kollavarsham.celestial;
import org.kollavarsham.math;

public class TestCelestial {
	celestial kvcelestial;
	math kvmath;
	calculations kvcalculations;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kvcelestial = celestial.getInstance();
		
	    kvcelestial.setPrimaryConstants();
	    kvcelestial.setSecondaryConstants();
	    kvcelestial.setPlanetaryConstants();
	    kvmath = new math();
	    kvcalculations = new calculations();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZero360() {
	    assertEquals(kvcelestial.zero360(75.2), 75.2, 0);
	    assertEquals(kvcelestial.zero360(-75.2), 284.8, 0);
	    assertEquals(kvcelestial.zero360(370.0), 10, 0);
	    assertEquals(kvcelestial.zero360(0.0), 0, 0);
	    assertEquals(kvcelestial.zero360(0.234), 0.234, 0);
	}

	@Test
	public void testThreeRelation() {
	    assertEquals(kvcelestial.threeRelation(-1.0, 1.0, 3.0), 1, 0);
	    assertEquals(kvcelestial.threeRelation(1.0, -1.0, -3.0), -1, 0);
	    assertEquals(kvcelestial.threeRelation(1.0, 1.0, 1.0), 0, 0);
	    assertEquals(kvcelestial.threeRelation(1.0, 5.0, -3.0), 0, 0); //invalid scenario
	}

	@Test
	public void testSetAyanamsa() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMeanLongitude() {
		assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15634155, 4320000.0), 298.54776362783));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15637207, 4320000.0), 298.547793708385));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15635681, 4320000.0), 298.547778668108));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15635681, 4320000.0), 298.547778668108));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15637207, 4320000.0), 298.547793708385));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636444, 4320000.0), 298.547786188246));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15635681, 4320000.0), 298.547778668108));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636444, 4320000.0), 298.547786188246));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636063, 4320000.0), 298.547782433088));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636063, 4320000.0), 298.547782433088));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636444, 4320000.0), 298.547786188246));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636253, 4320000.0), 298.54778430592));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636063, 4320000.0), 298.547782433088));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMeanLongitude(1868236.15636253, 4320000.0), 298.54778430592));
	}

	@Test
	public void testGetTrueLongitude() {
		Calendar testDay = Calendar.getInstance();
		testDay.set(1981, Calendar.FEBRUARY, 6);
		kvcalculations.FromGregorian(true, 23.2, testDay);
		assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710693.0, 215.330481398828, "mercury"), 290.256193246842));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710694.0, 216.345092245966, "mercury"), 287.939466847665));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710695.0, 217.360117559963, "mercury"), 285.69872602331));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710696.0, 218.375548627069, "mercury"), 283.567766431273));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772755.0, 183.139229101953, "mercury"), 292.367822361191));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772756.0, 184.136821438217, "mercury"), 293.462095381124));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772757.0, 185.135030298228, "mercury"), 294.554161309681));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1132992.0, 355.302664567532, "mercury"), 294.330597635538));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868191.0, 288.309252298232, "mercury"), 280.5291286866));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868192.0, 289.32751969395, "mercury"), 281.497932838323));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867492.0, 320.200309773426, "mercury"), 285.388042602287));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867886.0, 348.803993428264, "mercury"), 308.404674687418));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867520.0, 348.072902270539, "mercury"), 312.012169567129));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1844848.0, 322.249740952942, "mercury"), 287.862667589296));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710693.0, 215.330481398828, "venus"), 324.308933009715));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710694.0, 216.345092245966, "venus"), 321.407541005215));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710695.0, 217.360117559963, "venus"), 318.226901026202));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710696.0, 218.375548627069, "venus"), 314.775291122611));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772755.0, 183.139229101953, "venus"), 253.240856229459));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772756.0, 184.136821438217, "venus"), 253.582115854346));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772757.0, 185.135030298228, "venus"), 253.942554219963));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1132992.0, 355.302664567532, "venus"), 331.723144303665));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868191.0, 288.309252298232, "venus"), 344.369387070859));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868192.0, 289.32751969395, "venus"), 344.125688357144));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867492.0, 320.200309773426, "venus"), 338.204333524322));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867886.0, 348.803993428264, "venus"), 303.63668762932));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867520.0, 348.072902270539, "venus"), 343.326701630526));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1844848.0, 322.249740952942, "venus"), 289.230030387495));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710693.0, 215.330481398828, "mars"), 158.887067202077));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710694.0, 216.345092245966, "mars"), 159.240835569617));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710695.0, 217.360117559963, "mars"), 159.593872869183));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710696.0, 218.375548627069, "mars"), 159.946154425643));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772755.0, 183.139229101953, "mars"), 147.311514092937));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772756.0, 184.136821438217, "mars"), 147.677928778235));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772757.0, 185.135030298228, "mars"), 148.044220074319));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1132992.0, 355.302664567532, "mars"), 149.172853178935));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868191.0, 288.309252298232, "mars"), 179.846235661092));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868192.0, 289.32751969395, "mars"), 180.010186773321));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867492.0, 320.200309773426, "mars"), 179.72880836255));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867886.0, 348.803993428264, "mars"), 158.084536851156));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867520.0, 348.072902270539, "mars"), 159.029060106121));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1844848.0, 322.249740952942, "mars"), 179.131773264678));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710693.0, 215.330481398828, "saturn"), 194.843713150225));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710694.0, 216.345092245966, "saturn"), 194.935519951897));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710695.0, 217.360117559963, "saturn"), 195.027563651004));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710696.0, 218.375548627069, "saturn"), 195.119823966232));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772755.0, 183.139229101953, "saturn"), 192.153417342728));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772756.0, 184.136821438217, "saturn"), 192.226932462565));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772757.0, 185.135030298228, "saturn"), 192.301333486724));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1132992.0, 355.302664567532, "saturn"), 201.3134602354));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868191.0, 288.309252298232, "saturn"), 200.822899002374));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868192.0, 289.32751969395, "saturn"), 200.88079361344));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867492.0, 320.200309773426, "saturn"), 201.987978576402));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867886.0, 348.803993428264, "saturn"), 201.614465529182));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867520.0, 348.072902270539, "saturn"), 201.643214770863));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1844848.0, 322.249740952942, "saturn"), 202.010337361371));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710693.0, 215.330481398828, "saturn"), 194.843713150225));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710694.0, 216.345092245966, "saturn"), 194.935519951897));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710695.0, 217.360117559963, "saturn"), 195.027563651004));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1710696.0, 218.375548627069, "saturn"), 195.119823966232));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772755.0, 183.139229101953, "saturn"), 192.153417342728));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772756.0, 184.136821438217, "saturn"), 192.226932462565));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1772757.0, 185.135030298228, "saturn"), 192.301333486724));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1132992.0, 355.302664567532, "saturn"), 201.3134602354));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868191.0, 288.309252298232, "saturn"), 200.822899002374));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1868192.0, 289.32751969395, "saturn"), 200.88079361344));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867492.0, 320.200309773426, "saturn"), 201.987978576402));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867886.0, 348.803993428264, "saturn"), 201.614465529182));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1867520.0, 348.072902270539, "saturn"), 201.643214770863));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTrueLongitude(1844848.0, 322.249740952942, "saturn"), 202.010337361371));
	}

	@Test
	public void testGetSighraEquation() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeclination() {
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(31.3101877453024), 12.2026059914001));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(42.2597957259723), 15.8742931864835));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(59.2349729472294), 20.4565845497204));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(62.5975972349908), 21.1677169773821));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(80.4818781723799), 23.6492922420057));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(121.1497130809087), 20.3707052985127));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.declination(320.8687779979979), -14.8738036439391));
	}

	@Test
	public void testGetDaylightEquation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSunriseTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMandaEquation() {
		assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(216.448410870245, "sun"), -1.30810722363905));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(-72.3184309200178, "moon"), -4.83281883352571));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(150.807334962742, "moon"), 2.47190852495064));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(206.122810882618, "sun"), -0.969422483995786));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(203.067198238109, "moon"), -1.98547851952987));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(210.065221570941, "sun"), -1.10305954670912));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(176.937266597806, "moon"), 0.270697085906033));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.094016226779, "sun"), -1.03685394627977));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(163.872300782873, "moon"), 1.40749058746745));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(207.108413554698, "sun"), -1.00328649380511));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(190.002232417937, "moon"), -0.880005747995446));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(209.07961889886, "sun"), -1.07011491083048));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(176.937266597806, "moon"), 0.270697085906033));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.094016226779, "sun"), -1.03685394627977));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(170.404783692979, "moon"), 0.844536073585857));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(207.601214890739, "sun"), -1.02010791244252));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(183.469749507872, "moon"), -0.306629778128034));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.58681756282, "sun"), -1.05352335673225));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(176.937266597806, "moon"), 0.270697085906033));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.094016226779, "sun"), -1.03685394627977));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(190.002232417937, "moon"), -0.880005747995446));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(209.07961889886, "sun"), -1.07011491083048));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(183.469749507872, "moon"), -0.306629778128034));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.58681756282, "sun"), -1.05352335673225));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(180.203508055438, "moon"), -0.0179953506933944));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.340416894636, "sun"), -1.04519830661684));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(186.735990965544, "moon"), -0.594275735600709));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.833218230676, "sun"), -1.06182894265887));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(183.469749507872, "moon"), -0.306629778128034));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.58681756282, "sun"), -1.05352335673225));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(176.937266597806, "moon"), 0.270697085906033));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.094016226779, "sun"), -1.03685394627977));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(180.203508055438, "moon"), -0.0179953506933944));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(208.340416894636, "sun"), -1.04519830661684));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(83.931123946793, "mercury"), 4.59454849262788));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(81.6338497004791, "mercury"), 4.57122541974445));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(191.523444971968, "venus"), -0.365635863559596));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(191.706262903748, "venus"), -0.37135641118768));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(34.7045977141798, "mars"), 6.67523064837691));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(31.3669823899913, "mars"), 6.10047750894678));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(-91.5542432559879, "jupiter"), -5.17767683561233));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(-88.9654048381817, "jupiter"), -5.17874093000353));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(-42.8326673204595, "saturn"), -5.25521105975762));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getMandaEquation(-40.2050617905807, "saturn"), -4.98912071710793));
	}

	@Test
	public void testGetTithi() {
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(37.5275236212135, 294.989551683806), 8.54483099478396));
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(45.9229472947752, 333.593757395798), 6.02743249158144));
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(123.3068304585275, 15.597297524597), 8.97579441116087));
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(15.5275236212135, 163.989551683806), 17.6281643281173));
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(245.9229472947752, 3.593757395798), 20.1940991582481));
		   assertTrue(kvmath.floatingPointEqual(kvcelestial.getTithi(302.3068304585275, 56.597297524597), 20.4757944111609));
	}

	@Test
	public void testSetSuklaKrsna() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTllong() {
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2299158.5), 167.084587116821));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2299159.5), 179.618866280373));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2299160.5), 191.953219840454));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2299161.5), 204.131519861513));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2361220.5), 349.195739637822));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2361221.5), 1.82309136307406));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2361222.5), 14.6945040053245));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(1721457.5), 6.55724149356419));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2456656.5), 16.24829446685));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2456657.5), 29.8253740270552));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2455957.5), 156.709071062542));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2456351.5), 316.081404838166));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2455985.5), 165.854323537076));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTllong(2433313.5), 236.806759936797));
	}

	@Test
	public void testGetTslong() {
		assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2299158.5), 215.330481398828));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2299159.5), 216.345092245966));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2299160.5), 217.360117559963));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2299161.5), 218.375548627069));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2361220.5), 183.139229101953));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2361221.5), 184.136821438217));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2361222.5), 185.135030298228));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(1721457.5), 355.302664567532));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2456656.5), 288.309252298232));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2456657.5), 289.32751969395));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2455957.5), 320.200309773426));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2456351.5), 348.803993428264));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2455985.5), 348.072902270539));
	    assertTrue(kvmath.floatingPointEqual(kvcelestial.getTslong(2433313.5), 322.249740952942));
	}

	@Test
	public void testGetElong() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindConj() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConj() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClong() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNclong() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
