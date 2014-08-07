import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author dagosttv
 * @date 8/6/2014
 * @version 0.1
 *  Purpose: Testing the methods of the body class
 */
public class BodyTest {
	
	SciNot[] ePosition = {new SciNot(1.057831745,(short)11),new SciNot(1.057831745,(short)11)};
	SciNot[] eMinusPosition = {new SciNot(-1.057831745,(short)11),new SciNot(-1.057831745,(short)11)};
	SciNot[] sPosition = {new SciNot(0d,(short)0), new SciNot(0d,(short)0)};
	SciNot[] fixed = {new SciNot(0d,(short)0), new SciNot(0d,(short)0)};
	
	Body earth = new Body(Body.MASS_EARTH, ePosition, fixed,2);
	Body earthMinus = new Body(Body.MASS_EARTH, eMinusPosition, fixed,2);
	Body sun = new Body(Body.MASS_SUN, sPosition, fixed,2);
	
	/**
	 * Tests the division method of the SciNot Class
	 **/
	@Test
	public void magnitude(){
		System.out.println(earth.magnitude(sun));
		assertEquals(0, earth.magnitude(sun).compareTo(new SciNot(3.541463213,(short)22)));
		assertEquals(0, earthMinus.magnitude(sun).compareTo(new SciNot(3.541463213,(short)22)));
		
	}

}
