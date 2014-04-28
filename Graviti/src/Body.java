/**
 * @author dagosttv
 *
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
		this.mass = m;
		this.position = p;
		this.velocity = v;
		this.radius = rad;
	}

	
	public SciNot magnitude(Body other) {
		return ((this.mass.multiply(other.mass)).multiply(G)).divide(this
				.distance(other));
	}

	// Returns the squared distance
	public SciNot distance(Body other) {
		SciNot xDiff = (this.position[0].subtract(other.position[0]));
		SciNot yDiff = (this.position[1].subtract(other.position[1]));
		return ((xDiff.multiply(xDiff)).add(yDiff.multiply(yDiff)));
	}

	public SciNot getMass() {
		return mass;
	}

	public void setMass(SciNot mass) {
		this.mass = mass;
	}

	public SciNot[] getPosition() {
		return position;
	}

	public void setPosition(SciNot[] position) {
		this.position = position;
	}

	public SciNot[] getVelocity() {
		return velocity;
	}

	public void setVelocity(SciNot[] velocity) {
		this.velocity = velocity;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
