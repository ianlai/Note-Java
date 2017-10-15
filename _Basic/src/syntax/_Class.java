package syntax;

public class _Class {

	class InClass{
		InClass(){
			System.out.println("InClass()");
		}
	}
	
	public static void main(String[] args) {
		
		Class2 c2 = new Class2();
		
		//InClass ic = new InClass();  //no
		
		_Class obj = new _Class();
		obj.run();
	}
	public void run(){
		InClass ic = new InClass();  //yes
	}
}

//public class Class2{  //no
class Class2{           //yes
	Class2(){
		System.out.println("Class2()");
	}
}