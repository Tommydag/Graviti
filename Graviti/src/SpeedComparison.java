import java.util.Random;
import java.math.BigDecimal;

/**
 * @author dagosttv
 * Just for fun, I wanted to see the speed difference between the SciNot class and BigDecimal
 */
public class SpeedComparison {
	private int iter;
	private int size;
	private int maxOps;
	
	public SpeedComparison(int iterations, int Max_Exponent){
		this.iter = iterations;
		this.size = Max_Exponent;
		maxOps = this.iter*4;
	}
	
	public void test(){
		Random rand = new Random();
		long alphaTime, betaTime, gammaTime;
		
		SciNot[] sci = new SciNot[this.maxOps];
		BigDecimal[] bd = new BigDecimal[this.maxOps];		
		double[] dub = new double[this.maxOps];
		
		System.out.print("Generating Test Cases...");
		
		for(int x = 0;x<this.maxOps;x++){
			double d = rand.nextDouble();
			short s = (short)rand.nextInt(size);
			sci[x]= new SciNot(d,s);
			bd[x]= new BigDecimal(d).multiply(new BigDecimal(Math.pow(10, s)));
			dub[x] = d*Math.pow(10,s);
		}	
		
		System.out.print("COMPLETE!\n");
		
		System.out.print("Testing doubles...");
		
		
		double number = dub[0];
		gammaTime = System.currentTimeMillis();
		
		
		for(int y=1;y<maxOps-3;y+=4){
			number *= dub[y];
			number -= dub[y+1];
		//	number = Math.sqrt(number);
			number /= dub[y+2];
			number += dub[y+3];
		}
		long gammaTime1 = System.currentTimeMillis()-gammaTime;
		System.out.print("COMPLETE!\n");
		
		System.out.print("Testing SciNot...");
		
		SciNot alpha = sci[0];
		alphaTime = System.currentTimeMillis();
		
		
		for(int y=1;y<maxOps-3;y+=4){
			alpha = alpha.multiply(sci[y]);
			alpha = alpha.subtract(sci[y+1]);
		//	alpha = alpha.sqrt();
			alpha = alpha.divide(sci[y+2]);
			alpha = alpha.add(sci[y+3]);

		}
		long alphaTime1 = System.currentTimeMillis()-alphaTime;
		System.out.print("COMPLETE!\n");
		
		System.out.print("Testing BigDecimal...");
		BigDecimal beta = bd[0];
		betaTime = System.currentTimeMillis();
		
		
		for(int y=1;y<maxOps-3;y+=4){
			beta = beta.multiply(bd[y]);
			beta = beta.subtract(bd[y+1]);
			
			beta = beta.divide(bd[y+2],BigDecimal.ROUND_HALF_UP);
			beta = beta.add(bd[y+3]);
		}
		long betaTime1 = System.currentTimeMillis()-betaTime;
		
		System.out.print("COMPLETE!\n");
		
		System.out.println("Final Times(Milliseconds):");
		System.out.println("\t SciNot: " + alphaTime1);
		System.out.println("\t BigDecimal: " + betaTime1);
		System.out.println("\t Double: " + gammaTime1);
		
		System.out.println("Final Values:");
		System.out.println("\n\t SciNot:\n\t " + alpha);
		System.out.println("\n\t BigDecimal:\n " + beta.toString());
		System.out.println("\n\t Double:\n\t " + number);
		
	}
}
