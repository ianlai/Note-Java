package _Syntax;

public class Test {

	public static void main(String[] args) {
		
		int i1 = 100;
		int i2 = 100;
		Integer I1 = new Integer(i1);
		Integer I2 = new Integer(i2);
		
		System.out.println("i1==i2:" + (i1==i2));  //true
		System.out.println("I1==I2:" + (I1==I2));  //false
		System.out.println("I1.equals(I2):" + (I1.equals(I2)));  //true
		
		int a= 200_000_000;
		System.out.print(a);
		StringToInt z = new StringToInt();
		byte[] ss = z.toInt("grass");
		for(int i=0; i<ss.length;i++){
			System.out.print(ss[i] + " ");
		}
		
		System.out.print(test());
		System.out.println("");
		System.out.println(2/3);
		//StringToInt.A a = new StringToInt.A();
		//StringToInt.B b = new B();
	}
	private static boolean test(){
		return 5<3; 
	}

}
