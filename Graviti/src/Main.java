/**
 * @author dagosttv
 * @date 4/20/14
 * @version 0.1
 * Purpose: None currently.
 */

public class Main {

	static Boolean Speed_Test = false;
	
	public static void main(String[] args) {

		new GUI();
		
		if(Speed_Test){
			SpeedComparison wow = new SpeedComparison(320,20);
			wow.test();
		}
	}

}
