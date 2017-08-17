package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck2 {
    public static void main(String[] args) {
        List<Card2> deck = new ArrayList<>(52);

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card2(r, s));
            }
        }
        Collections.sort(deck);

        for (Card2 card : deck) {
            System.out.println(card);
        }
    }
}