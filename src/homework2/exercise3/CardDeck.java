package homework2.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> deck;

    public CardDeck() {
        deck = new ArrayList<>();
        String[] ranks = {"2", "3", "4", "5", "6",  "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Cơ", "Rô", "Tép", "Bích"};

        for (String rank : ranks)
            for (String suit : suits)
                deck.add(new Card(rank, suit));
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void dao(){
        Collections.shuffle(deck);
    }

}
