/**
 * @author dagosttv
 * @date 4/20/14
 * @version 1.0
 * Purpose: To allow for easy assignment of all of the vectors (properties)
 * 	a body can have in this simulator.
 */
public class Body {
	
	private final static SciNot G = new SciNot(6.67384, (short) -11);
	public final static SciNot MASS_EARTH = new SciNot(5.97219, (short) 24);
	public final static SciNot MASS_SUN = new SciNot(1.98855, (short) 30);
	public final static SciNot DISTANCE_EARTHANDSUN = new SciNot(1.496, (short) 8);
	

	private SciNot mass;
	private SciNot[] position;
	private SciNot[] velocity;
	private int radius;

	public Body(SciNot m, SciNot[] p, SciNot[] v, int rad) {
		
		if(m.compareTo(SciNot.ZERO)==-1){
			System.out.println("Negative Mass, IT'S A TRAP!");
			this.mass = SciNot.ZERO;
		}
		else{
			this.mass = m;
		}
		if(rad<0){
			System.out.println("Negative Radius, IT'S A TRAP!");
		}
		this.radius = Math.abs(rad);
		this.position = p;
		this.velocity = v;
		
	}

	//Returns the magnitude of the gravitational force caused by another object
	public SciNot magnitude(Body other) {
		return ((this.mass.multiply(other.mass)).multiply(G)).divide(this
				.distance(other));
	}

	// Returns the squared distance
	public SciNot distance(Body other) {
		return ((deltaX(other).multiply(deltaX(other))).add(deltaY(other).multiply(deltaY(other))));
	}

	//Returns the difference in x coordinates
	public SciNot deltaX(Body other){
		return (this.position[0].subtract(other.position[0]));
	}
	
	//Returns the difference in x coordinates
	public SciNot deltaY(Body other){
		return (this.position[1].subtract(other.position[1]));
	}
	
	public SciNot getMass() {
		return this.mass;
	}

	public void setMass(SciNot mass) {
		this.mass = mass;
	}

	public SciNot[] getPosition() {
		return this.position;
	}

	public void setPosition(SciNot[] position) {
		this.position = position;
	}

	public SciNot[] getVelocity() {
		return this.velocity;
	}

	public void setVelocity(SciNot[] velocity) {
		this.velocity = velocity;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
