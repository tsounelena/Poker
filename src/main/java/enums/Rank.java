package enums;

public enum Rank {

    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    T,
    J,
    Q,
    K,
    A;

    public static Rank getRank(String rankSymbol) {
        switch (rankSymbol) {
            case "2":
                return Rank.TWO;
            case "3":
                return Rank.THREE;
            case "4":
                return Rank.FOUR;
            case "5":
                return Rank.FIVE;
            case "6":
                return Rank.SIX;
            case "7":
                return Rank.SEVEN;
            case "8":
                return Rank.EIGHT;
            case "9":
                return Rank.NINE;
        }
        return Rank.valueOf(rankSymbol);
    }
}
