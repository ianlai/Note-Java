import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortObject implements Comparator<Person> {

	public static void main(String args[]){
		//=================================
		//=============== Use Comparator 
		//=================================
		List<Person> team = new ArrayList<>();
		team.add(new Person(1,"Lara"));
		team.add(new Person(5,"Pon"));
		team.add(new Person(3,"Kin"));
		team.add(new Person(4,"Apple"));
		team.add(new Person(17,"Zoo"));
		team.add(new Person(29,"Puppy"));	
		team.add(new Person(8,"Barry"));	
		
		//Create Comparator with id 
		Comparator<Person> idComp = new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.id-p2.id;
			}
		};
		
		//Create Comparator with name
		Comparator<Person> nameComp = new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.name.compareTo(p2.name);
			}
		};
		
		System.out.println("----------- Original List1 -----------");
		for(Person p : team){
			System.out.println(p);
		}
		
		System.out.println("----------- Sorted by Comparator (id) -----------");
		Collections.sort(team, idComp);
		for(Person p : team){
			System.out.println(p);
		}
		
		System.out.println("----------- Sorted by Comparator (name) -----------");
		Collections.sort(team, nameComp);
		for(Person p : team){
			System.out.println(p);
		}
		
		System.out.println("----------- Sorted by Comparator (id), implements Comparator -----------");
		SortObject so = new SortObject();
		Collections.sort(team, so);
		for(Person p : team){
			System.out.println(p);
		}
		
		//=================================
		//=============== Use Comparable 
		//=================================
		List<PersonComparable> team2 = new ArrayList<>();
		team2.add(new PersonComparable(151,"Lara"));
		team2.add(new PersonComparable(555,"Pon"));
		team2.add(new PersonComparable(378,"Kin"));
		team2.add(new PersonComparable(422,"Apple"));
		team2.add(new PersonComparable(1752,"Zoo"));
		team2.add(new PersonComparable(295,"Puppy"));	
		team2.add(new PersonComparable(842,"Barry"));
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("----------- Original List2 -----------");
		for(Person p : team2){
			System.out.println(p);
		}
		
		System.out.println("----------- Sorted by Comparable (id) -----------");
		Collections.sort(team2);
		for(Person p : team2){
			System.out.println(p);
		}
	}

	@Override
	public int compare(Person p1, Person p2) {  //because this class implements Comparator 
		return p1.id-p2.id;
	}
}
