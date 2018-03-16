package reference;

public class TestCompare {

	public static void main(String[] args) {
		int i1 = 100;
		int i2 = 100;
		Integer I1 = new Integer(i1);
		Integer I2 = new Integer(i2);
		
		System.out.println("i1==i2:" + (i1==i2));  //true 
		System.out.println("I1==I2:" + (I1==I2));                //false (object)
		System.out.println("I1.equals(I2):" + (I1.equals(I2)));  //true  (value)
	}
}
