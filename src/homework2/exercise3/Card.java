package homework2.exercise3;

public class Card implements Comparable {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new NullPointerException();

        if (o instanceof Card) {
            Card otherCard = (Card) o;

            return converScores(this) - converScores(otherCard);
        }

        throw new ClassCastException();
    }


    private int converScores(Card card) {
        int scores = 0;
        switch (card.getRank()) {
            case "3" -> scores += 1;
            case "4" -> scores += 2;
            case "5" -> scores += 3;
            case "6" -> scores += 4;
            case "7" -> scores += 5;
            case "8" -> scores += 6;
            case "9" -> scores += 7;
            case "10" -> scores += 8;
            case "J" -> scores += 9;
            case "Q" -> scores += 10;
            case "K" -> scores += 11;
            case "A" -> scores += 12;
            case "2" -> scores += 13;
        }
        scores *= 10;

        switch (card.getSuit()) {
            case "Cơ" -> scores += 4;
            case "Rô" -> scores += 3;
            case "Tép" -> scores += 2;
            case "Bích" -> scores += 1;
        }

        return scores;
    }
}
