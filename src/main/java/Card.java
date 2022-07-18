import enums.Rank;
import enums.Suit;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final Rank rank;

    Card(String cardData) {
        this.rank = Rank.getRank(cardData.trim().substring(0, 1));
        this.suit = Suit.valueOf(cardData.trim().substring(1, 2));
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(rank.ordinal(), o.getRank().ordinal());
    }
}
