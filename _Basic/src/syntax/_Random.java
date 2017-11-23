package syntax;

import java.util.Random;

public class _Random {

	public static void main(String[] args) {
		Random rand = new Random();
		for(int i=0; i<100; i++){
			System.out.println(rand.nextInt(3));  //0, 1, 2
		}
	}

}
