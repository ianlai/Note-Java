package syntax;

public class _Conversion {
	public _Conversion(){
		
	}
	public static void main(String[] args) {
		new _Conversion().run();

	}
	public void run(){
		int       i =  9 ; //Integer.MAX_VALUE = 2_147_483_647;
		long      l = Long.MAX_VALUE;
		
		Character c =  '1';
		Character c2 = '9';
		Character c3 = 'A';
		Character c4 = 'a';
		Character c5 = 'z';
		
		String    s = "9";
		String    slong = "9223372036854775807"; //long's MAX (64 bit)
		
		//String -> int
		int ii = Integer.parseInt(s);
		long ilong = Long.parseLong(slong);
		int iic = Character.getNumericValue(c);  
		System.out.println(ii);
		System.out.println(ilong);
		System.out.println(iic);
		
		//int -> String 
		String ss = Integer.toString(i);
		String sss = Long.toString(l);
		System.out.println(ss);
		System.out.println(sss);
		
		System.out.println(c.charValue());                 //'1' -> 1
		System.out.println(Character.getNumericValue(c));  //'1' -> 1	
		System.out.println(c2.charValue());                //'9' -> 9
		System.out.println(Character.getNumericValue(c2)); //'9' -> 1  
		System.out.println(c3.charValue());                           //'A' -> A  
		System.out.println(Character.getNumericValue(c3));            //'A' -> 10
		System.out.println(c4.charValue());                           //'a' -> a 
		System.out.println(Character.getNumericValue(c4));            //'a' -> 10
		System.out.println(c5.charValue());                           //'z' -> z 
		System.out.println(Character.getNumericValue(c5));            //'z' -> 35 
		
		System.out.println("================");
		
		Double D = 2.5;
		double d = 3.5;
		int i1 = D.intValue();
		int i2 = (int)d;
		int i3 = (int)Math.sqrt(2);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}
}
