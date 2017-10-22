package comparator;

/* A "Comparable" Person class*/
public class PersonComparable extends Person implements Comparable<Person>{	
	PersonComparable(int i, String n) {
		super(i, n);
	}

	@Override
	public int compareTo(Person p) {
		return this.id - p.id;
	}
}
