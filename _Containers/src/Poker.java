import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
	List<Card> cards = new ArrayList<>(); 
	int num = 52; 
	Poker(){
		for(int i=0; i<num; i++) {
			cards.add(new Card(suit(i), symbol(i)));
		}
	}
	String suit(int i) {
		int r=i+1; 
//		switch(r) {
//			case 0: return "S";
//			case 1: return "H";
//			case 2: return "D";
//			case 3: return "C";
//		}
		if(r<=13)         return "S";
		if(r>13 && r<=26) return "H";
		if(r>26 && r<=39) return "D";
		if(r>39 && r<=52) return "C";
		return "error";
	}
	String symbol(int i) {
		int r=i%13+1;
		switch(r) {
			case 1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
		}
		return String.valueOf(r);
	}
	void print() {
		for(Card c: cards) {
			System.out.println(c);
		}
	}
	void shuffle() {
		for(int i=0; i<num; i++) {
			int target = (int) (Math.random()*num) ;
			Collections.swap(cards, i, target);
		}
	}
	public static void main(String[] args) {
		Poker poker = new Poker();
		poker.print();
		poker.shuffle();
		System.out.println("===========");
		poker.print();
	}

}
class Card{
	String suit;
	String symbol; 
	Card(String suit, String symbol){
		this.suit = suit;
		this.symbol = symbol; 
	}
	public String toString() {
		return suit + " - " + symbol;
	}
}
