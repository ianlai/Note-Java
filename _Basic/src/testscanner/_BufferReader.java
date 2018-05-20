package testscanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * Input Format: 
 * 
 * L1: String
 * L2: Fixed length integer
 * L3: Fixed length integer
 * L3: Dynamic length integer
 * 
 * Input: 
   
   name       
   1 2 
   3 4  
   2 4 8 3 5 7 9
   
 */

public class _BufferReader {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Read:"); //We need print out to read the line 
		String name = br.readLine();

		String line = "";
		/* Read input to build the graph */
		while ((line = br.readLine()) != null) {
			String[] sarr = line.split(" ");
			if(sarr.length==2){ /* Fixed length */
				int num1 = Integer.valueOf(line.split(" ")[0]);
				int num2 = Integer.valueOf(line.split(" ")[1]);
				System.out.println("Fixed: " + num1 + " -- " + num2);
			}else{              /* Dynamic length */
		        StringTokenizer st = new StringTokenizer(line);
		        
		        /* Store the input into an arraylist */
		        List<Integer> list = new ArrayList<>();
		        while(st.hasMoreTokens()){
		          list.add(Integer.parseInt(st.nextToken()));
		        }
		        System.out.println("Dynamic: " + list);
			}
		}
	}
}
