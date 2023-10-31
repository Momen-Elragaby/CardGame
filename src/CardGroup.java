import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Objects;

public class CardGroup {
    private final List<Card> cardList;

    public CardGroup() {
        this.cardList = new ArrayList<>();
    }

    public CardGroup(CardGroup otherGroup) {
        this.cardList = new ArrayList<>(otherGroup.cardList);
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    public Card removeLastCard() {
        return this.isEmpty() ? null : this.cardList.remove(this.cardList.size() - 1);
    }

    public Card removeCard(int index) {
        return this.cardList.remove(index);
    }

    public Card getCard(int index) {
        return this.cardList.get(index);
    }

    public Card getLastCard() {
        return this.isEmpty() ? null : this.cardList.get(this.cardList.size() - 1);
    }

    public boolean isEmpty() {
        return this.cardList.isEmpty();
    }

    public int size() {
        return this.cardList.size();
    }

    public void shuffle(Random random)
    {
        for (int i = 0; i < cardList.size(); i++)
        {
            int index = random.nextInt(cardList.size());
            // Simple swap
            Card a = cardList.get(index);
            cardList.set(index, cardList.get(i));
            cardList.set(i, a);
        }
    }


    public void sort()
    {
        Collections.sort(this.cardList);
    }

    public void clear()
    {
        this.cardList.clear();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardGroup that = (CardGroup) o;
        return Objects.equals(cardList, that.cardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardList);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Card card : cardList)
        {
            sb.append(card.toString());
            sb.append("\n"); // append new line
        }
        return sb.toString().trim(); // remove trailing new line
    }
}

