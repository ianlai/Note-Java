import java.util.*;

public class Person{
	public int id;
	public String name;
	public char lastChar;
	public int randSeq; 
	
	Person(int i, String n){
		id = i;
		name = n;
		lastChar = n.charAt(n.length()-1);
		randSeq = (int) (Math.random()*100);
	}	
	public String toString(){
		String s = String.format("%-10s :    %-8s :  %s  :  %-3s", this.id, this.name, this.lastChar, this.randSeq);
		return s;
	}
}

