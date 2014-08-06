/**
 * @author dagosttv
 * @date 4/20/14 updated: 8/5/2014
 * @version 1.0
 *  Purpose: Provide an easy way to handle the very large numbers
 *          that appear in celestial mechanics.
 * 
 *          A SciNot object follows the format: num * 10^(exp)
 */

public class SciNot {
	
	/**
	 * A Static Zero for comparison Purposes
	 */
	public static final SciNot ZERO = new SciNot(0d,(short)0);

	/**
	 * The floating point base of a SciNot Object
	 */
	private Double num;

	/**
	 * The short exponent of a SciNot Object
	 */
	private short exp;

	/**
	 * No-Parameter constructor
	 * 
	 */
	public SciNot() {
		this.num = 0.0;
		this.exp = 0;
	}

	/**
	 * @param d
	 */
	public SciNot(Double d) {
		short c = 0;
		int negative = 1;
		if (d < 0) {
			negative = -1;
		}
		d = Math.abs(d);
		if (d == 0d) {
			this.num = 0d;
			this.exp = 0;
		} else {
			while (d <= 1) {
				d *= 10;
				c--;
			}
			while (d >= 10) {
				d /= 10;
				c++;
			}
			this.num = d * negative;
			this.exp = c;
		}
	}

	/**
	 * Constructor that takes a double num and a short exp
	 * 
	 * @param d
	 * @param e
	 */
	public SciNot(Double d, short e) {
		int negative = 1;
		if (d < 0) {
			negative = -1;
		}
		d = Math.abs(d);
		if (d == 0d) {
			this.num = 0d;
			this.exp = 0;
		} else {
			while (d <= 10) {
				d *= 10;
				e--;
			}
			while (d >= 10) {
				d /= 10;
				e++;
			}
			this.num = d * negative;
			this.exp = e;
		}
	}

	/**
	 * Constructor that takes a string object
	 * 
	 * @param s
	 */
	public SciNot(final String s) {
		double d = Double.parseDouble(s);
		int negative = 1;
		if (d < 0) {
			negative = -1;
		}
		d = Math.abs(d);
		short e = 0;
		if (d == 0d) {
			this.num = 0d;
			this.exp = 0;
		} else {
			while (d <= 10) {
				d *= 10;
				e--;
			}
			while (d >= 10) {
				d /= 10;
				e++;
			}
			this.num = d * negative;
			this.exp = e;
		}
	}

	/**
	 * working
	 * 
	 * @param b
	 * @return The quotient of two SciNot objects
	 */
	public SciNot divide(final SciNot b) {
		final SciNot c = new SciNot();

		if (b.num == 0) {
			System.out.println("!!!Divide by zero error!!!");
			return c;
		}

		c.num = (this.num / b.num);
		c.exp = ((short) (this.exp - b.exp));

		return new SciNot(c.num, c.exp);
	}

	/**
	 * working
	 * 
	 * @param b
	 * @return The product of two SciNot Objects
	 */
	public SciNot multiply(final SciNot b) {
		SciNot c = new SciNot();
		c.num = (this.num * b.num);
		c.exp = ((short) (this.exp + b.exp));
		return new SciNot(c.num, c.exp);
	}

	/**
	 * Working
	 * 
	 * @param b
	 * @return The difference of two SciNot objects
	 */
	public SciNot subtract(final SciNot b) {
		if (this.exp == b.exp) {
			return new SciNot(this.num - b.num, b.exp);
		} else if (this.exp > b.exp) {
			final double temp = this.num * Math.pow(10, this.exp - b.exp);
			return new SciNot(temp - b.num, b.exp);
		} else {
			final double temp = b.num * Math.pow(10, b.exp - this.exp);
			return new SciNot(this.num - temp, this.exp);
		}
	}

	/**
	 * 
	 * @param b
	 * @return sum of two SciNot objects
	 */
	// Working
	public SciNot add(final SciNot b) {
		if (this.exp == b.exp) {
			return new SciNot(this.num + b.num, b.exp);
		} else if (this.exp > b.exp) {
			final double temp = this.num * Math.pow(10, this.exp - b.exp);
			return new SciNot(temp + b.num, b.exp);
		} else {
			final double temp = b.num * Math.pow(10, b.exp - this.exp);
			return new SciNot(temp + this.num, this.exp);
		}
	}

	/**
	 * Working 
	 * If given a negative number, the method returns a blank SciNot
	 * Object and prints a warning
	 * 
	 * @return sqrt of a SciNot
	 */
	public SciNot sqrt() {
		final SciNot c = new SciNot();
		if (this.num < 0) {
			System.out.println("ERROR: SQRT of a negative number");
			return c;
		} else if (this.exp % 2 == 0) {
			c.num = Math.sqrt(this.num);
			c.exp = (short) (this.exp / 2);
			return c;
		} else {
			c.num = Math.sqrt(this.num * 10);
			c.exp = (short) ((this.exp - 1) / 2);
			return c;
		}
	}

	// Public Access
	/**
	 * Allows public access to the num value of a SciNot
	 * 
	 * @return num
	 */
	public double getNum() {
		return this.num;
	}

	/**
	 * Allows public access to the exp value of a SciNot
	 * 
	 * @return exp
	 */
	public short getExp() {
		return this.exp;
	}

	/**
	 * Allows external changing of the num value
	 * 
	 * @param d
	 */
	public void setNum(final Double d) {
		this.num = d;
	}

	/**
	 * Allows external changing of the exp value
	 * 
	 * @param e
	 */
	public void setExp(final short e) {
		this.exp = e;
	}

	@Override
	public String toString() {
		return (this.num + " x10^" + this.exp);
	}

	@Override
	public boolean equals(final Object other) {
		return other == this;
	}

	/**
	 * @param beta
	 * @return 1 if greater, 0 if equal, or -1 if lesser
	 */
	public int compareTo(final SciNot beta) {
		if (this.exp == beta.exp) {
			if (Math.abs(this.num - beta.num) < (0.0000001)) {
				return 0;
			} else if (this.num - beta.num > 0) {
				return 1;
			} else
				return -1;
		} else {
			if (this.exp > beta.exp)
				return 1;
			else
				return -1;
		}
	}

}
