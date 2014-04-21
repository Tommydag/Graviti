
/**
 * @author dagosttv
 * @date 4/20/14
 * @version 0.1
 */
public class SciNot {

	Double num;
	short exp;
	
	//No-Parameter constructor
	public SciNot (){
		num = 0.0;
		exp = 0;
	}
	public SciNot (Double d){
		short c = 0;
		while(d<=10){
			d*=10;
			c--;
		}
		while(d>=10){
			d/=10;
			c++;
		}
		num = d;
		exp = c;
	}
	public SciNot (Double d, short e){
		while(d<=10){
			d*=10;
			e--;
		}
		while(d>=10){
			d/=10;
			e++;
		}
		num = d;
		exp = e;
	}
	
	public SciNot (String s){
		double d = Double.parseDouble(s);
		short e = 0;
		while(d<=10){
			d*=10;
			e --;
		}
		while(d>=10){
			d/=10;
			e++;
		}
		num = d;
		exp = e;
	}
	//working
	public SciNot divide (SciNot b){
		SciNot c = new SciNot();
		if(b.num == 0){
			System.out.println("!!!Divide by zero error!!!");
			return c;
		}
		c.num=(this.num/ b.num);
		c.exp=((short)(this.exp-b.exp));
		while(c.num<1){
			c.num *=10;
			c.exp--;
		}
		return c;
	}
	//working
	public SciNot multiply(SciNot b){
		SciNot c = new SciNot();
		c.num=(this.num*b.num);
		c.exp=((short)(c.exp+b.exp));
		while(c.getNum()<1){
			c.num *=10;
			c.exp--;
		}
		while(c.getNum()>=10){
			c.num /=10;
			c.exp++;
		}
		return c;
	}
	//Working
	public SciNot subtract(SciNot b){
		SciNot c = new SciNot();
		while(this.exp>b.exp){
			b.num/=10;
			b.exp++;
		}
		c.num = this.num-b.num;
		c.exp = this.exp;
		return c;
	}
	//Working
	public SciNot add(SciNot b){
		SciNot c = new SciNot();
		while(this.exp>b.exp){
			b.num/=10;
			b.exp++;
		}
		c.num = this.num+b.num;
		c.exp = this.exp;
		return c;
	}
	
	
	//Public Access
	public double getNum (){
		return this.num;
	}
	
	public short getExp (){
		return this.exp;
	}
	public void setNum (Double d){
		this.num = d;
	}
	public void setExp (short e){
		this.exp = e;
	}
	public String toString(){
		return(this.num + " x10^" + this.exp);
	}
}
