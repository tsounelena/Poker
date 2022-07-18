import enums.HandRank;
import enums.Rank;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand>{

    private final List<Card> cards;
    private final HandRank handRank;
    private final List<Entry<Rank, Long>> groupedCards;

    PokerHand(String cards) {
        this.cards = Arrays.stream(cards.trim().split(" ")).map(Card::new).collect(Collectors.toList());
        if (this.cards.size() != 5) {
            throw new IllegalArgumentException("Check amount of cards and try again");
        }
        this.groupedCards = this.cards.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .entrySet().stream()
                .sorted(Entry.comparingByKey())
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toList());
        this.handRank = defineRank();
    }

    public HandRank getHandRank() {
        return handRank;
    }

    private List<Entry<Rank, Long>> getGroupedCards() {
        return groupedCards;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + groupedCards +
                "}\n";
    }

    private HandRank defineRank() {
        int uniqueSize = groupedCards.size();
        if (uniqueSize == 4) {
            return HandRank.PAIR;
        }
        if (uniqueSize == 3){
           boolean isSet = groupedCards.stream().anyMatch((entry -> entry.getValue() == 3L));
           return isSet ? HandRank.SET : HandRank.TWO_PAIRS;
        }
        if (uniqueSize == 5) {
            boolean isSequential = isSequential();
            boolean isOneSuit = cards.stream().map(Card::getSuit).distinct().count() == 1;
            if (isOneSuit && isSequential) {
                boolean isRoyal = cards.stream().anyMatch((card -> card.getRank() == Rank.A));
                return isRoyal ? HandRank.ROYAL_FLUSH : HandRank.STRAIGHT_FLUSH;
            }
            if (isSequential) {
                return HandRank.STRAIGHT;
            }
            if (isOneSuit) {
                return HandRank.FLUSH;
            }
        }
        if (uniqueSize == 2) {
            boolean iQuad = groupedCards.stream().anyMatch((entry -> entry.getValue() == 4L));
            return iQuad ? HandRank.QUADS : HandRank.FULL_HOUSE;
        }

        return HandRank.HIGH_CARD;
    }

    private boolean isSequential() {
        List<Rank> ranks = cards.stream().map(Card::getRank).sorted().collect(Collectors.toList());
        return ranks.get(cards.size()-1).ordinal() - ranks.get(0).ordinal() == cards.size()-1;
    }

    @Override
    public int compareTo(PokerHand o) {
        if (handRank == o.getHandRank()) {
            for (int i = groupedCards.size() - 1; i >=0; i--) {
                int firstOrdinal = groupedCards.get(i).getKey().ordinal();
                int secondOrdinal = o.getGroupedCards().get(i).getKey().ordinal();
                int comparison = Integer.compare(firstOrdinal, secondOrdinal);
                if (comparison != 0 || i == 0) {
                    return comparison;
                }
            }
        }
        return Integer.compare(handRank.ordinal(), o.getHandRank().ordinal());
    }
}
