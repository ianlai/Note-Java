package syntax;

public class _Debug {

	public static void main(String[] args) {
		
		/* Print current function name */
		func1();
		func2();
		
		/* Print current class name */
		Parent pp1 = new Parent();
		Parent pp2 = new Child1();
		Parent pp3 = new Child2();
		
		pp1.printClass();
		pp2.printClass();
		pp3.printClass();
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
		System.out.println("--------" + curr + "--------");
	}
}
//============================================================================
class Parent{
	public void printClass(){
		System.out.println("[" + this.getClass().getSimpleName() + "]\n");
	}	
}
class Child1 extends Parent{
	
}
class Child2 extends Parent{
	
}


