import java.util.Objects;

public class Card implements Comparable<Card>
{
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Card otherCard)
    {
        this.rank = otherCard.rank;
        this.suit = otherCard.suit;
    }

    public Rank getRank()
    {
        return rank;
    }

    public Suit getSuit()
    {
        return suit;
    }

    @Override
    public int compareTo(Card otherCard)
    {
        int suitComparison = this.suit.compareTo(otherCard.suit);
        if (suitComparison != 0) {
            return suitComparison;
        }
        else
        {
            return this.rank.compareTo(otherCard.rank);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(rank, suit);
    }

    @Override
    public String toString()
    {
        return rank.toString() + " of " + suit.toString();
    }
}
