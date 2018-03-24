package syntax;

public class _Debug {

	public static void main(String[] args) {
		
		/* Print current function name */
		System.out.println("====== Function Name ======");
		func1();
		func2();
		
		/* Print current class name */
		System.out.println("====== Class Name (getClass) ======");
		Parent pp1 = new Parent();
		Parent pp2 = new Child1();
		Parent pp3 = new Child2();
		
		pp1.printClass();
		pp2.printClass();
		pp3.printClass();
		
		System.out.println("====== Class Name (instanceof) ======");
		pp1.printClass2();
		pp2.printClass2();
		pp3.printClass2();
	}
	private static void func1(){
		printFunc();
	}
	private static void func2(){
		printFunc();
		func1();
	}
	private static void printFunc(){
		//[0]: getStackTrace
		//[1]: printSeparate
		//[2]: the caller's name
		String curr = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println(" >> Method: " + curr);
	}
}
//============================================================================
class Parent{
	public void printClass(){
		System.out.println("[" + this.getClass().getSimpleName() + "]\n");
	}	
	public void printClass2(){
		if(this instanceof Child1) 
			System.out.println("Child1");
		else if(this instanceof Child2) 
			System.out.println("Child2");
		else if(this instanceof Parent)
			System.out.println("Parent");
	}
}
class Child1 extends Parent{
	
}
class Child2 extends Parent{
	
}


