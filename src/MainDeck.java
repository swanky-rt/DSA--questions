public class MainDeck {
    public static void main(String args[]){
        Deck deck = new Deck();
        deck.toString();

        deck.shuffleCard();
        deck.toString();

        deck.drawTopCard();

        deck.addCard(new Card(Suit.Club, Rank.Five));

        deck.removeCard(Suit.Heart, Rank.Ace);
        deck.toString();

        deck.drawTopCard();



    }
}
