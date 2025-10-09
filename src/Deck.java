import java.util.*;

public class Deck {
    List<Card> cardList;

    public Deck(){
        cardList = new ArrayList<>();

        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                Card card = new Card(suit, rank);
                cardList.add(card);
            }
        }
    }

    // to add a card in the deck

    public int addCard(Card card){
        cardList.add(card);
        return cardList.size();
    }


    //to remove a card from the deck by matching rank and suit

    public void removeCard(Suit suit, Rank rank){

        Iterator<Card> iterator = cardList.iterator();
        while(iterator.hasNext()){
            Card card = iterator.next();
            if(card.getRank().equals(rank) && card.getSuit().equals(suit)){
                iterator.remove();
                System.out.println("the card is removed" + card.getSuit()+  card.getRank());
            }
        }
    }

    //to shuffle the card from the deck

    public void shuffleCard(){
        Collections.shuffle(cardList);
    }

    //to draw the top card from the deck

    public void drawTopCard(){
        Card card = cardList.get(0);
        System.out.println("the card which is removed is " + card.getSuit() + card.getRank());
        cardList.remove(0);
    }
}
