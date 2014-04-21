
public class Main {

	public static void main(String[] args) {
		SciNot sci = new SciNot(12359832.,(short)10);
		SciNot sci2 = new SciNot(8789.,(short)5);
		SciNot sci3 = new SciNot("54545");
		System.out.println("Norm " + sci);
		System.out.println("Norm2 " +sci2);
		System.out.println("divide " +sci.divide(sci2));
		System.out.println("multiply " +sci.multiply(sci2));
		System.out.println("add " +sci.add(sci2));
		System.out.println("sub " +sci.subtract(sci2));
		System.out.println("sub " +sci2.subtract(sci));
		System.out.println("Sqrt " + sci3.sqrt());
		new GUI();
	}

}
