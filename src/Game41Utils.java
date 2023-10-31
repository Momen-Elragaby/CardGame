import java.util.HashMap;
import java.util.Map;

public class Game41Utils
{
    private static final Map<Rank, Integer> rankToPointMap = new HashMap<>();

    static
    {
        rankToPointMap.put(Rank.ACE, 11);
        rankToPointMap.put(Rank.TWO, 2);
        rankToPointMap.put(Rank.THREE, 3);
        rankToPointMap.put(Rank.FOUR, 4);
        rankToPointMap.put(Rank.FIVE, 5);
        rankToPointMap.put(Rank.SIX, 6);
        rankToPointMap.put(Rank.SEVEN, 7);
        rankToPointMap.put(Rank.EIGHT, 8);
        rankToPointMap.put(Rank.NINE, 9);
        rankToPointMap.put(Rank.TEN, 10);
        rankToPointMap.put(Rank.JACK, 10);
        rankToPointMap.put(Rank.QUEEN, 10);
        rankToPointMap.put(Rank.KING, 10);
    }

    public Game41Utils() { }

    public static int getPointValue(Rank rank)
    {
        return rankToPointMap.get(rank);
    }

    public static int calculateHandValue(CardGroup hand)
    {
        Map<Suit, Integer> suitToPointMap = new HashMap<>();

        for (int i = 0; i < hand.size(); i++)
        {
            Card card = hand.getCard(i);
            suitToPointMap.put(card.getSuit(), suitToPointMap.getOrDefault(card.getSuit(), 0) + getPointValue(card.getRank()));
        }

        int maxPoints = suitToPointMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        int totalPoints = suitToPointMap.values().stream().mapToInt(Integer::intValue).sum();

        return maxPoints - (totalPoints - maxPoints);
    }


    public static boolean isHandOver(CardGroup deck, int knockIndex, int currentTurnIndex)
    {
        return deck.isEmpty() || knockIndex == currentTurnIndex;
    }
}
