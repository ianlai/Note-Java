
// int : 32 bit

public class Max {
	public void run(){
		System.out.println(Integer.MAX_VALUE);  //2,147,483,647             (2^31-1 = 10^10)
		System.out.println(Long.MAX_VALUE);     //9,223,372,036,854,775,807 (2^63-1 = 10^19)
		
		System.out.println(Integer.MAX_VALUE+10);  //become negative (overflow)
		if(Integer.MAX_VALUE+10 > Integer.MAX_VALUE){
			System.out.println("Over");
		}else{
			System.out.println("NOT Over");  //cannot detect the overflow
		}
			
	}
}


  