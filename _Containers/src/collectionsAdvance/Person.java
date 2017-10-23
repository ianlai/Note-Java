package collectionsAdvance;

import java.util.Arrays;
import java.util.Objects;

/* This modification is for 
 * HashMap (equals and hashCode) and for
 * TreeMap (Comparable) */
public class Person implements Comparable<Person> {
	int id;
	String name;

	Person(int i, String s) {
		id = i;
		name = s;
	}

	public String toString() {
		return id + "-" + name;
	}

	/*
	 * Determine two object are the same or not: Step1: hashCode() to find the
	 * bucket Step2: equals() to compare the two in the same bucket Because the
	 * default hashCode() might put different references (but actually same object
	 * in our definition) into different buckets, it cannot find it even we override
	 * equals() function.
	 */
	public boolean equals(Object o) {
		Person target = (Person) o;
		return target.name.equals(this.name) && target.id == this.id;
	}

	public int hashCode() {
		/*
		 * All of the element will be put in the same bucket. It works fine, but slow.
		 */
		// return 1;

		/*
		 * This means distributing the object according to the name's length It works
		 * fine too, but it might also have many hash collision
		 */
		return name.length();
	}

	@Override
	public int compareTo(Person p) {
		// return p.id - this.id; //large to small
		return this.id - p.id;
	}
}

/* This modification is for HashMap (equals and hashCode) */
// public class Person{
// int id;
// String name;
// Person(int i, String s){
// id = i;
// name = s;
// }
// public String toString() {
// return id + "-" + name;
// }
//
// /* Determine two object are the same or not:
// * Step1: hashCode() to find the bucket
// * Step2: equals() to compare the two in the same bucket
// * Because the default hashCode() might put different references
// * (but actually same object in our definition) into different buckets,
// * it cannot find it even we override equals() function.
// * */
// public boolean equals(Object o) {
// Person target = (Person)o;
// return target.name.equals(this.name) && target.id == this.id;
// }
// public int hashCode() {
// /* All of the element will be put in the same bucket.
// * It works fine, but slow. */
// //return 1;
//
// /* This means distributing the object according to the name's length
// * It works fine too, but it might also have many hash collision */
// return name.length();
// }
// }



/* This modification is for TreeMap (Comparable) */
// public class Person implements Comparable<Person>{
// int id;
// String name;
// Person(int i, String s){
// id = i;
// name = s;
// }
// public String toString() {
// return id + "-" + name;
// }
// @Override
// public int compareTo(Person p) {
// //return p.id - this.id; //large to small
// return this.id - p.id;
// }
// }



/* Original Class (not work) */
// public class Person{
// int id;
// String name;
// Person(int i, String s){
// id = i;
// name = s;
// }
// public String toString() {
// return id + "-" + name;
// }
// }
