package com.thoughtworks.marchant_guide.convertor;

import junit.framework.TestCase;

/**
 * The class <code>CurrencyTest</code> contains tests for the class {@link <code>Currency</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 13/05/16 21:16
 *
 * @author Hitesh
 *
 * @version $Revision$
 */
public class CurrencyTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void keymapping() throws Exception {

		assertEquals(1.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("I"));
		assertEquals(5.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("V"));
		assertEquals(10.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("X"));
		assertEquals(50.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("L"));
		assertEquals(100.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("C"));
		assertEquals(500.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("D"));
		assertEquals(1000.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("M"));

	}

	public void prefixRule_I() throws Exception {

		// Subtract
		assertEquals(4.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("IV"));
		assertEquals(9.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("IX"));

		// ADD
		assertEquals(6.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("VI"));
		assertEquals(11.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("XI"));

	}

	public void prefixRule_X() throws Exception {

		assertEquals(40.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("XL"));
		assertEquals(90.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("XC"));

		assertEquals(60.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("LX"));
		assertEquals(110.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("CX"));

	}

	public void prefixRule_C() throws Exception {

		assertEquals(400.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("CD"));
		assertEquals(900.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("CM"));

		assertEquals(600.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("DC"));
		assertEquals(1100.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit("MC"));

	}

	/**
	 * Run the int calculateCredit(String) method test
	 */
	public void testCalculateCredit1() {

		String input = "MCMIII";

		assertEquals(1903.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit(input));
	}

	/**
	 * Run the int calculateCredit(String) method test
	 */
	public void testCalculateCredit2() {

		String input = "MMVI";

		assertEquals(2006.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit(input));
	}

	/**
	 * Run the int calculateCredit(String) method test
	 */
	public void testCalculateCredit_subtraction() {

		String input = "MCMXLIV";

		assertEquals(1944.0, UniversalCurrencyConvertor.getCurrencyInstance()
				.calculateCredit(input));
	}

	/**
	 * Run the String checkSymentic(String) method test
	 */
	public void testCheckSymentic1() {

		String input = "MCMIII";

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic(input));
	}

	/**
	 * Run the String checkSymentic(String) method test
	 */
	public void testCheckSymentic2() {

		String input = "MMVI";

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic(input));
	}

	/**
	 * Run the String checkSymentic(String) method test
	 */
	public void testCheckSymentic3() {

		String input = "MCMIII";

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic(input));
	}

	/**
	 * Run the Currency getCurrencyInstance() method test
	 */
	public void testGetCurrencyInstance() {

		// add test code here
		UniversalCurrencyConvertor result = UniversalCurrencyConvertor
				.getCurrencyInstance();

		assertNotNull(result);

		assertTrue(result.getClass() == UniversalCurrencyConvertor.class);
	}

	/*
	 * The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more.
	 */

	public void test3OccuranceOf_I() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("III"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIII"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_4_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIII"));

	}

	/*
	 * The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more.
	 */

	public void test3OccuranceOf_X() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXX"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXXX"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_4_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXXX"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXXIX"));

	}

	/*
	 * The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more.
	 */
	public void test3OccuranceOf_C() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCC"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCCC"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_4_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"CCCC"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCCXC"));

	}

	/*
	 * The symbols "I", "X", "C", and "M" can be repeated three times in
	 * succession, but no more.
	 */
	public void test3OccuranceOf_M() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("MMM"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("MMMM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_4_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"MMMM"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("MMMXM"));

	}

	/*
	 * "D", "L", and "V" can never be repeated.
	 */

	public void test1OccuranceOf_D() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("DI"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("DDI"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"DDI"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("DID"));

	}

	/*
	 * "D", "L", and "V" can never be repeated.
	 */

	public void test1OccuranceOf_L() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("LI"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("LLI"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"LLI"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("lIL"));

	}

	/*
	 * "D", "L", and "V" can never be repeated.
	 */

	public void test1OccuranceOf_V() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("VI"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("VVI"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"VVI"));

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("VIV"));

	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_Prefix() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IV"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIV"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIV"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIIV"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIIV"));
	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_PrefixX() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIX"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIX"));
	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_PrefixL() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIL"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIL"));
	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_PrefixC() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIC"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIC"));
	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_PrefixD() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IID"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IID"));
	}

	/*
	 * "I" cannot occure more than once in from of C,X,L,C,D
	 */

	public void test2OccuranceOf_I_PrefixM() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("IIM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"IIM"));
	}

	// "X" cannot occure more than once in from of L,C,D

	public void test2OccuranceOf_X_Prefix() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XM"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXXM"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXXM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXXM"));
	}

	// "X" cannot occure more than once in from of L,C,D

	public void test2OccuranceOf_X_PrefixL() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXL"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXL"));
	}

	// "X" cannot occure more than once in from of L,C,D,M

	public void test2OccuranceOf_X_PrefixC() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXC"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXC"));
	}

	// "X" cannot occure more than once in from of L,C,D,M

	public void test2OccuranceOf_X_PrefixD() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXD"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXD"));
	}

	// "X" cannot occure more than once in from of L,C,D,M

	public void test2OccuranceOf_X_PrefixM() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("XXM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"XXM"));
	}

	// "C" cannot occure more than once in from of D
	public void test2OccuranceOf_C_Prefix() throws Exception {

		assertNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CM"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"CCCM"));

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCCM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"CCCM"));
	}

	// "C" cannot occure more than once in from of D,M
	public void test2OccuranceOf_C_PrefixD() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCD"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"CCD"));
	}

	// "C" cannot occure more than once in from of D,M

	public void test2OccuranceOf_C_PrefixM() throws Exception {

		assertNotNull(UniversalCurrencyConvertor.getCurrencyInstance()
				.checkSymentic("CCM"));

		assertEquals(
				UniversalConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX,
				UniversalCurrencyConvertor.getCurrencyInstance().checkSymentic(
						"CCM"));
	}

}

/*
 * $CPS$ This comment was generated by CodePro. Do not edit it. patternId =
 * com.instantiations.assist.eclipse.pattern.testCasePattern strategyId =
 * com.instantiations.assist.eclipse.pattern.testCasePattern.junitTestCase
 * additionalTestNames = assertTrue = false callTestMethod = true createMain =
 * false createSetUp = true createTearDown = true createTestFixture = false
 * createTestStubs = false methods =
 * calculateCredit(QString;),checkSymentic(QString;),getCurrencyInstance()
 * package = com.thoughtworks.marchant_guide.convertor package.sourceFolder =
 * Merchant Guide/src superclassType = junit.framework.TestCase testCase =
 * CurrencyTest testClassType =
 * com.thoughtworks.marchant_guide.convertor.Currency
 */