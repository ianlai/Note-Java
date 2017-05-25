import java.util.*;

public class Person{
	public int id;
	public String name;
	Person(int i, String n){
		id = i;
		name = n;
	}	
	public String toString(){
		return this.id + " - " + this.name;
	}
}

