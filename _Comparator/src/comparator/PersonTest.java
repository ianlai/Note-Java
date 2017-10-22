package comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonTest implements Comparator<Person> {

	public static void main(String args[]){
		useComparable();
		useComparator();
	}
	public static void useComparable(){
		System.out.println("=================================");
		System.out.println("=============== Use Comparable ");
		System.out.println("=================================");
		
		/* The object in the list must be the Comparable person but not original person */
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
		
		System.out.println("----------- Original List -----------");
		for(Person p : team2){
			System.out.println(p);
		}
		
		System.out.println("----------- Sorted by Comparable (id) -----------");
		Collections.sort(team2);
		for(Person p : team2){
			System.out.println(p);
		}
		
		System.out.println();
	}
	
	public static void useComparator(){
		
		System.out.println("=================================");
		System.out.println("=============== Use Comparator ");
		System.out.println("=================================");

		/* Use comparator might be general 
		 * because we don't need to modify the original class 
		 * (inherit the PersonComparable).
		 * And also we can implement any kind of comparator as we want when creating the comparator. */
		
		List<Person> team = new ArrayList<Person>(){
			@Override
			public String toString(){
				StringBuilder sb = new StringBuilder();
				for(Person p : this){
					sb.append(p);
					sb.append("\n");	
				}
				return sb.toString();
			}
		};
		team.add(new Person(1,"Lara"));
		team.add(new Person(5,"Pon"));
		team.add(new Person(3,"Kin"));
		team.add(new Person(4,"Apple"));
		team.add(new Person(17,"Zoo"));
		team.add(new Person(29,"Puppy"));	
		team.add(new Person(8,"Barry"));	
		
		//Comparator of id 
		Comparator<Person> idComp = new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.id-p2.id;
			}
		};
		
		//Comparator of name
		Comparator<Person> nameComp = new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.name.compareTo(p2.name);
			}
		};
		
		System.out.println("----------- Original List -----------");
		System.out.println(team);
		
		System.out.println("----------- Sorted by Comparator (id) -----------");
		Collections.sort(team, idComp);
		System.out.println(team);
		
		System.out.println("----------- Sorted by Comparator (name) -----------");
		Collections.sort(team, nameComp);
		System.out.println(team);
		
		System.out.println("----------- Sorted by Comparator (lastChar), created an anonymous class -----------");
		Collections.sort(team, new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.lastChar - p2.lastChar;
			}
		});
		System.out.println(team);
		
		System.out.println("----------- Sorted by Comparator (id), implements Comparator -----------");
		PersonTest so = new PersonTest();   //This class implements Comparator too, looks irrelevant though
		Collections.sort(team, so);
		System.out.println(team);
		
		System.out.println("----------- Sorted by Comparator (randSeq), Java8 Lambdas -----------");
		Collections.sort(team, (Person p1, Person p2) -> p1.randSeq - p2.randSeq);
		System.out.println(team);

		
		System.out.println();
	}

	/* Because this test class also implements Comparator interface, it needs to implment the compare function */ 
	@Override
	public int compare(Person p1, Person p2) {  //because this class implements Comparator 
		return p1.id-p2.id;
	}
}
