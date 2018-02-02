package containers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Poker {
	List<Card> cards = new ArrayList<>(); 
	final int total = 52;
	int num = 0;
	Poker(){
		for(int i=0; i<total; i++) {
			cards.add(new Card(i));
			num++;
		}		
	}

	void print() {
		for(Card c: cards) {
			System.out.println(c);
		}
	}
	void shuffle() {
		for(int i=0; i<total; i++) {
			int target = (int) (Math.random()*total) ;
			Collections.swap(cards, i, target);
		}
	}
	void deal(Deck d, int n) {
		for(int i=0; i<n; i++) {
			d.addCard(cards.remove(0));
			num--;
		}
	}
	 
	public static void main(String[] args) {
		Poker poker = new Poker();
		poker.print();   //original 
		poker.shuffle();
		System.out.println("====== Original Deck ======");
		poker.print();   //shuffle
		System.out.println("====== Shuffle  Deck ======");

		int num = 13;
		
		/*Initialize the players*/
		Deck[] player = new Deck[4];
		for(int i=0; i<4; i++) {
			player[i] = new Deck(); 
		}
		
		/*Deal the cards to players*/
		for(int i=0; i<4; i++) {
			poker.deal(player[i], num);
		}

		System.out.println("Left:" + poker.num);
		
		/*Print the cards of players*/
//		for(int i=0; i<4; i++) {
//			System.out.println("Play-" +i);
//			player[i].print();
//			System.out.println("===========");
//		}
		System.out.println("====== Players ======");
		/*Sort and print the cards of players*/
		for(int i=0; i<4; i++) {
			player[i].sort();
			System.out.println("Play-" +i);
			player[i].print();
			System.out.println("----------");
		}
		
	}
}
class Card{
	String suit;
	String symbol; 
	int point;
	Card(int point){
		this.suit = suit(point);
		this.symbol = symbol(point); 
		this.point = point;
	}
	String suit(int i) {
		int r = i%4; 
		switch(r) {
			case 0: return "\u2663";  //club (small)
			case 1: return "\u2666";  //diamond
			case 2: return "\u2665";  //heart
			case 3: return "\u2660";  //spade (large)
		}
		return "error";
	}
	String symbol(int i) {
		int r= i/4 +1;
		switch(r) {
			case 1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
		}
		return String.valueOf(r);
	}
	public String toString() {
		String str=String.format(suit + "" + "%1$2s", symbol);  
		return str;
	}
}
class Deck{
	List<Card> cards = new ArrayList<>(); 
	int num = 0;
	void addCard(Card c) {
		cards.add(c);
		num++;
	}
	void print() {
		for(Card c: cards) {
			System.out.println(c);
		}
	}
	void sort() {
		Comparator<Card> cardComp = new Comparator<Card>(){
			public int compare(Card c1, Card c2){
				return c1.point-c2.point;
			}
		};
		Collections.sort(cards, cardComp);
	}
}
