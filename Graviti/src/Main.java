public class Main {

	public static void main(String[] args) {
		SciNot sci = new SciNot(12359832., (short) 10);
		SciNot sci2 = new SciNot(8789., (short) 5);
		SciNot sci3 = new SciNot("54545");
		System.out.println("Norm " + sci);
		System.out.println("Norm2 " + sci2);
		System.out.println("divide " + sci.divide(sci2));
		System.out.println("multiply " + sci.multiply(sci2));
		System.out.println("add " + sci.add(sci2));
		System.out.println("sub " + sci.subtract(sci2));
		System.out.println("sub " + sci2.subtract(sci));
		System.out.println("Sqrt " + sci3.sqrt());
		System.out.println("Fun!");

		SciNot[] oneP = { new SciNot(1.05783174466,(short)8), new SciNot(1.05783174466,(short)8) };
		SciNot[] oneV = { new SciNot(0d), new SciNot(0d) };

		SciNot[] twoP = { new SciNot(0d), new SciNot(0d) };
		SciNot[] twoV = { new SciNot(0d), new SciNot(0d) };

		Body one = new Body(Body.MASS_SUN, oneP, oneV, 10);
		Body two = new Body(Body.MASS_EARTH, twoP, twoV, 10);
		System.out.println("One on Two: " + one.magnitude(two));
		//new GUI();

	}

}
