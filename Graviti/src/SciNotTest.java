import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author dagosttv
 * @date 8/5/14
 * @version 0.2 
 * 
 * 			All testing values calculated in Maple 17 Purpose: To test the
 *          mathematical functions that will allow for the creation of very
 *          large numbers that appear in celestial mechanics.
 */
public class SciNotTest {

	// sci1 - sci4 test the generation of a SciNot object from a base and
	// exponent (including negatives)

	SciNot sci1 = new SciNot(12359832., (short) 10);
	SciNot sci2 = new SciNot(-5328., (short) 5);
	SciNot sci3 = new SciNot(8789., (short) -5);
	SciNot sci4 = new SciNot(-3745., (short) -2);

	// sci5 - sci8 test the generation of a SciNot object from a string
	// (including negatives)

	SciNot sci5 = new SciNot("54545");
	SciNot sci6 = new SciNot("-45"); // Tests the creation of a SciNot with a
										// negative base
	SciNot sci7 = new SciNot("0.4592"); // Test the creation of a SciNot with a
										// negative exponent
	SciNot sci8 = new SciNot("-0.234"); // Tests the creation of a SciNot with
										// both a negative base and exponent

	/**
	 * Tests creation of SciNot objects
	 **/
	@Test
	public void creation() {
		long start = System.currentTimeMillis();

		System.out.println(this.sci1);
		System.out.println(this.sci2);
		System.out.println(this.sci3);
		System.out.println(this.sci4);
		System.out.println(this.sci5);
		System.out.println(this.sci6);
		System.out.println(this.sci7);

		assertTrue(System.currentTimeMillis() - start < 10);

	}

	/**
	 * Tests the addition method of the SciNot Class
	 * 
	 */
	@Test
	public void addition() {
		assertEquals(0, (this.sci1.add(this.sci5)).compareTo(new SciNot(
				"123598320000054545")));
		assertEquals(0,
				(this.sci6.add(this.sci8)).compareTo(new SciNot("-45.234")));
		assertEquals(0, (this.sci3.add(this.sci2)).compareTo(new SciNot(
				-5.327999999, (short) 8)));
		assertEquals(0, (this.sci4.add(this.sci7)).compareTo(new SciNot(
				"-36.99080000")));

	}

	/**
	 * Tests the subtraction method of the SciNot Class
	 **/
	@Test
	public void subtraction() {
		assertEquals(0, (this.sci1.subtract(this.sci5)).compareTo(new SciNot(
				"123598319999945455")));
		assertEquals(0, (this.sci6.subtract(this.sci8)).compareTo(new SciNot(
				"-44.766")));
		assertEquals(0, (this.sci3.subtract(this.sci2)).compareTo(new SciNot(
				5.328000001, (short) 8)));
		assertEquals(0, (this.sci4.subtract(this.sci7)).compareTo(new SciNot(
				"-37.90920000")));
	}

	/**
	 * Tests the multiplication method of the SciNot Class
	 **/
	@Test
	public void multiplication() {

		assertEquals(0, (this.sci1.multiply(this.sci5)).compareTo(new SciNot(
				"6741670364400000000000")));
		assertEquals(0,
				(this.sci6.multiply(this.sci8)).compareTo(new SciNot("10.530")));
		assertEquals(0, (this.sci3.multiply(this.sci2)).compareTo(new SciNot(
				-4.68277920, (short) 7)));
		assertEquals(0, (this.sci4.multiply(this.sci7)).compareTo(new SciNot(
				"-17.19704000")));
	}

	/**
	 * Tests the division method of the SciNot Class
	 **/
	@Test
	public void division() {

		assertEquals(0, (this.sci1.divide(this.sci5)).compareTo(new SciNot(
				2.265988083, (short) 12)));
		assertEquals(0, (this.sci6.divide(this.sci8)).compareTo(new SciNot(
				"192.3076923")));
		assertEquals(0, (this.sci3.divide(this.sci2)).compareTo(new SciNot(
				-1.649587087, (short) -10)));
		assertEquals(0, (this.sci4.divide(this.sci7)).compareTo(new SciNot(
				"-81.55487805")));
	}

	/**
	 * Tests the division method of the SciNot Class
	 **/
	@Test
	public void sqrt() {

		System.out.println(this.sci1.sqrt());
		assertEquals(0, (this.sci1.sqrt()).compareTo(new SciNot(3.515655273,
				(short) 8)));
		assertEquals(0, (this.sci2.sqrt()).compareTo(new SciNot()));
		assertEquals(0, (this.sci3.sqrt()).compareTo(new SciNot(0.2964624765,
				(short) 0)));
		assertEquals(0, (this.sci4.sqrt()).compareTo(new SciNot()));
		assertEquals(0, (this.sci5.sqrt()).compareTo(new SciNot(233.5487101,
				(short) 0)));
	}

}
