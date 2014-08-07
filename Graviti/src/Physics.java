

/**
 * 
 */

/**
 * @author dagosttv
 * @date 8/6/14
 * @version 0.1 Purpose: The behind-the-scenes location that makes all the magic
 *          happen. The actual interactions are all orchestrated through this
 *          class.
 */
public class Physics {
	private Body[] bodies = new Body[0];

	
	public void simulate(int seconds){
		for(int t = 0; t<seconds; t++){
			Body[] buffer = new Body[bodies.length-1];
		
		}
	}

	
	public void addBody(Body b){
		Body[] temp = new Body[bodies.length];
		for(int i = 0;i<bodies.length;i++){
			temp[i] = bodies[i];
		}
		temp[temp.length-1] = b;
		bodies = temp;
	}
	
	
	
	/**
	 * TODO Finish
	 * @param b
	 */
	public static void removeBody(Body b){
		//To do
	}
	
}
