package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck3 {
    public static void main(String[] args) {
        List<Card2> deck = new ArrayList<Card2>(52);

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card2(r, s));
            }
        }
        System.out.println("*** Sorted Cards ***");
        Collections.sort(deck);
        for (Card2 card : deck) {
            System.out.println(card);
        }
        System.out.println("*** Shuffled Cards ***");
        Collections.shuffle(deck);
        for (Card2 card : deck) {
            System.out.println(card);
        }
    }
}
