package syntax;

public class _Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A objaa = new A();
		B objbb = new B();
		A objab = new B();
		//B objba = new A();
		
		objaa.a1();
		//objaa.b1();  //no, of course
		System.out.println("-----");
		
		objbb.a1();
		objbb.b1();
		
		System.out.println("-----");
		objab.a1();
		//objab.b1();    //no
	}
}

class A {
	public void a1() {
		System.out.println("A: a1");
	}
}

class B extends A{
	public void a1() {
		System.out.println("B: a1 (override)");
	}
	public void b1() {
		System.out.println("B: b1");
	}
}