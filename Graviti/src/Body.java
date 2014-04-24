
public class Body {

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

	SciNot mass;
	SciNot[] position;
	SciNot[] velocity;
	int radius;
	
	public Body(SciNot m, SciNot[] p, SciNot[] v,int rad){
		this.mass = m;
		this.position = p;
		this.velocity = v;
		this.radius = rad;
	}
}
