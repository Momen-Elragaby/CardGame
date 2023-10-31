public enum Rank
{
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString()
    {
        return this.name().toLowerCase();
    }
}
