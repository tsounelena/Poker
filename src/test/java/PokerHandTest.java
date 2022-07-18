import enums.HandRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokerHandTest {

    private static final PokerHand HIGH_CARD = new PokerHand("KC 2H 5D 6C TS");
    private static final PokerHand HIGH_CARD2 = new PokerHand("2C 5S KH JC TC");
    private static final PokerHand PAIR = new PokerHand("2S 2H 3C 4S KD");
    private static final PokerHand PAIR2 = new PokerHand("JS JH 5C 7D 4D");
    private static final PokerHand TWO_PAIRS = new PokerHand("2S 2H 5C 5D TD");
    private static final PokerHand TWO_PAIRS2 = new PokerHand("2S 2H TC 5D TD");
    private static final PokerHand TWO_PAIRS3 = new PokerHand("2S 2H TC 6D TD");
    private static final PokerHand SET = new PokerHand("2S 2H 2C 6D TD");
    private static final PokerHand SET2 = new PokerHand("3S 3H 3C 5D TD");
    private static final PokerHand SET3 = new PokerHand("3S 3H 3C TD JD");
    private static final PokerHand STRAIGHT = new PokerHand("6S 4H 5C 3D 7D");
    private static final PokerHand STRAIGHT2 = new PokerHand("4S 6H 5C 7D 8D");
    private static final PokerHand FLUSH = new PokerHand("KS 2S 5S 6S TS");
    private static final PokerHand FLUSH2 = new PokerHand("KS 2S 3S 6S JS");
    private static final PokerHand FULL_HOUSE = new PokerHand("2C 2S 5S 5H 5D");
    private static final PokerHand FULL_HOUSE2 = new PokerHand("2S 2H 6S 6H 6D");
    private static final PokerHand FULL_HOUSE3 = new PokerHand("KS KH 6S 6H 6D");
    private static final PokerHand FULL_HOUSE4 = new PokerHand("3D 3H JS JH JD");
    private static final PokerHand QUADS = new PokerHand("3D JD JS JH JC");
    private static final PokerHand QUADS2 = new PokerHand("3D KD KS KH KC");
    private static final PokerHand QUADS3 = new PokerHand("4D KD KS KH KC");
    private static final PokerHand STRAIGHT_FLUSH = new PokerHand("4S 5S 6S 7S 8S");
    private static final PokerHand STRAIGHT_FLUSH2 = new PokerHand("9S TS JS QS KS");
    private static final PokerHand ROYAL_FLUSH = new PokerHand("TS JS QS KS AS");

    @Test
    void creation() {
        Assertions.assertEquals(HandRank.HIGH_CARD, HIGH_CARD.getHandRank());
        Assertions.assertEquals(HandRank.PAIR, PAIR2.getHandRank());
        Assertions.assertEquals(HandRank.TWO_PAIRS, TWO_PAIRS2.getHandRank());
        Assertions.assertEquals(HandRank.SET, SET.getHandRank());
        Assertions.assertEquals(HandRank.STRAIGHT, STRAIGHT.getHandRank());
        Assertions.assertEquals(HandRank.FLUSH, FLUSH2.getHandRank());
        Assertions.assertEquals(HandRank.FULL_HOUSE, FULL_HOUSE3.getHandRank());
        Assertions.assertEquals(HandRank.QUADS, QUADS.getHandRank());
        Assertions.assertEquals(HandRank.STRAIGHT_FLUSH, STRAIGHT_FLUSH.getHandRank());
        Assertions.assertEquals(HandRank.ROYAL_FLUSH, ROYAL_FLUSH.getHandRank());
    }

    @Test
    void compareTo() {
        Assertions.assertEquals(0, HIGH_CARD.compareTo(HIGH_CARD));
        Assertions.assertEquals(-1, HIGH_CARD.compareTo(HIGH_CARD2));
        Assertions.assertEquals(1, HIGH_CARD2.compareTo(HIGH_CARD));
        Assertions.assertEquals(-1, PAIR.compareTo(PAIR2));
        Assertions.assertEquals(-1, TWO_PAIRS.compareTo(TWO_PAIRS2));
        Assertions.assertEquals(-1, TWO_PAIRS2.compareTo(TWO_PAIRS3));
        Assertions.assertEquals(-1, SET.compareTo(SET2));
        Assertions.assertEquals(-1, SET2.compareTo(SET3));
        Assertions.assertEquals(-1, STRAIGHT.compareTo(STRAIGHT2));
        Assertions.assertEquals(-1, FLUSH.compareTo(FLUSH2));
        Assertions.assertEquals(-1, FULL_HOUSE.compareTo(FULL_HOUSE2));
        Assertions.assertEquals(-1, FULL_HOUSE2.compareTo(FULL_HOUSE3));
        Assertions.assertEquals(-1, FULL_HOUSE3.compareTo(FULL_HOUSE4));
        Assertions.assertEquals(-1, QUADS.compareTo(QUADS2));
        Assertions.assertEquals(-1, QUADS2.compareTo(QUADS3));
        Assertions.assertEquals(-1, STRAIGHT_FLUSH.compareTo(STRAIGHT_FLUSH2));

        Assertions.assertEquals(1, ROYAL_FLUSH.compareTo(STRAIGHT_FLUSH2));
        Assertions.assertEquals(1, ROYAL_FLUSH.compareTo(QUADS3));
        Assertions.assertEquals(1, STRAIGHT_FLUSH.compareTo(QUADS2));
        Assertions.assertEquals(1, STRAIGHT_FLUSH.compareTo(HIGH_CARD2));
        Assertions.assertEquals(1, QUADS.compareTo(FULL_HOUSE2));
        Assertions.assertEquals(1, QUADS.compareTo(FLUSH));
        Assertions.assertEquals(1, FULL_HOUSE.compareTo(FLUSH));
        Assertions.assertEquals(1, FULL_HOUSE.compareTo(PAIR2));
        Assertions.assertEquals(1, FLUSH.compareTo(STRAIGHT));
        Assertions.assertEquals(1, FLUSH.compareTo(SET3));
        Assertions.assertEquals(1, STRAIGHT.compareTo(SET));
        Assertions.assertEquals(1, STRAIGHT.compareTo(HIGH_CARD2));
        Assertions.assertEquals(1, SET.compareTo(PAIR2));
        Assertions.assertEquals(1, PAIR.compareTo(HIGH_CARD2));
    }
}