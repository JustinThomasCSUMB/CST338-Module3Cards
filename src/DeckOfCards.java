import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Group 4
 * Justin Thomas
 * Marcos Barrera
 * Cristian Vazquez
 * Michael Janes
 * CST338 Module
 */


public class DeckOfCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxPlayers = 0;
        int currentPlayer = 0;
        System.out.println("/* -------------------Phase 3----------------------------");
        System.out.println("-------------------Unshuffled 2 Packs----------------------------");
        Deck doubleDeckTest = new Deck(2);
        while (!doubleDeckTest.inspectCard(doubleDeckTest.getTopCard()).getErrorFlag()) {
            System.out.print(doubleDeckTest.dealCard() + " / ");
        }
        System.out.println("\n -------------------Shuffled 2 Packs----------------------------");
        doubleDeckTest.init(2);
        doubleDeckTest.shuffle();
        while (!doubleDeckTest.inspectCard(doubleDeckTest.getTopCard()).getErrorFlag()) {
            System.out.print(doubleDeckTest.dealCard() + " / ");
        }
        System.out.println("\n--------------------------------------------------------- */");
        System.out.println("-------------------Single Deck Unshuffled----------------------------");
        Deck singleDeckTest = new Deck(1);
        while (!singleDeckTest.inspectCard(singleDeckTest.getTopCard()).getErrorFlag()) {
            System.out.print(singleDeckTest.dealCard() + " / ");
        }
        System.out.println("\n -------------------Single Deck Shuffled----------------------------");
        singleDeckTest.init(1);
        singleDeckTest.shuffle();
        while (!singleDeckTest.inspectCard(singleDeckTest.getTopCard()).getErrorFlag()) {
            System.out.print(singleDeckTest.dealCard() + " / ");
        }
        System.out.println("\n--------------------------------------------------------- */");

        System.out.println("/* -------------------Phase 4----------------------------");
        Deck deck = new Deck();
        /*
        Confirms user input is an accepted value
        @userInput int between 1-10
        */
        try {
            System.out.println("Please select a number of players 1-10");
            maxPlayers = in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("This is not an accepted value!");
            in.nextLine();
        }

        //Value is a confirmed int, this confirms it is between 1-10


        while (maxPlayers <= 0 || maxPlayers >= 11) {
            try {
                System.out.println("Please select a number of players 1-10");
                maxPlayers = in.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("This is not an accepted value!");
                in.nextLine();
            }

            //Value is a confirmed int, this confirms it is between 1-10


        }


        Hand[] playerHands = new Hand[maxPlayers];
        //Populates the playerHands[]
        for (int i = 0; i < maxPlayers; i++) {
            playerHands[i] = new Hand();
        }

        //Deals out the entire deck
        while (!deck.inspectCard(deck.getTopCard()).getErrorFlag()) {

            //Places a card in each players hand
            playerHands[currentPlayer].takeCard(deck.dealCard());
            currentPlayer++;

            //makes sure we are staying within the given range of players
            if (currentPlayer >= maxPlayers) {
                currentPlayer = 0;
            }


        }

        //Prints out every players hand & then resets it
        System.out.println("Here are our hands, from the unshuffled deck:");
        for (int i = 0; i < playerHands.length; i++) {
            System.out.println((i + 1) + " " + playerHands[i].toString());
            System.out.println();
            playerHands[i].resetHand();
        }

        //Reset's the deck, operating under the assumption that there is only
        //one deck in play
        deck.init(1);
        deck.shuffle();
        currentPlayer = 0;


        while (!deck.inspectCard(deck.getTopCard()).getErrorFlag()) {


            playerHands[currentPlayer].takeCard(deck.dealCard());
            currentPlayer++;
            if (currentPlayer >= maxPlayers) {
                currentPlayer = 0;
            }


        }

        //Prints out every players hand & then resets it
        System.out.println("Here are our hands, from the shuffled deck:");
        for (int i = 0; i < playerHands.length; i++) {
            System.out.println((i + 1) + " " + playerHands[i].toString());
            System.out.println();
            playerHands[i].resetHand();
        }

        in.close();
        System.out.println("--------------------------------------------------------- */");
    }


}

class Card {
    // enum storing card suits (Method made static)
    public enum Suit {clubs, diamonds, hearts, spades}

    // Private Statics for Card Class
    private static final char DEFAULT_VALUE = 'A';
    private static final Suit DEFAULT_SUIT = Suit.spades;

    // Private Card class members
    private char value;
    private Suit suit;
    private boolean errorFlag;

    // Constructor with no parameters
    public Card() {
        this(DEFAULT_VALUE, DEFAULT_SUIT);
    }

    // Constructor with both parameters
    public Card(char value, Suit suit) {
        set(value, suit);
    }

    // Accessors and Mutators (getters and setters)
    public char getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean getErrorFlag() {
        return errorFlag;
    }

    public boolean set(char value, Suit suit) {
        // Set value to upperCase
        char upperValue = Character.toUpperCase(value);

        // Check validity of the value and update members and errorFlag
        if (isValid(upperValue, suit)) {
            this.value = upperValue;
            this.suit = suit;
            errorFlag = false;
            return true;
        } else {
            this.value = upperValue;
            this.suit = suit;
            errorFlag = true;
            return false;
        }
    }

    @Override
    public String toString() {
        if (errorFlag)
            return "** illegal **";
        else
            return value + " of " + suit;
    }

    // Check if passed card is equal to current card
    public boolean equals(Card card) {
        return getValue() == card.getValue() && getSuit() == card.getSuit();
    }

    // Private Methods
    private boolean isValid(char value, Suit suit) {
        // Although suit is passed it is not checked

        // Return true if value is a valid value else false (added 'Q')
        return ((value >= '2' && value <= '9') ||
                value == 'A' ||
                value == 'K' ||
                value == 'Q' ||
                value == 'J' ||
                value == 'T');
    }
}

class Hand {
    // max number of cards in a deck, 1 person hand
    public static final int MAX_CARDS = 52;

    Card[] myCards;
    int numCards; //this could be a function that returns myCards.length()

    public int getNumCards() {
        return numCards;
    }

    Hand() {
        myCards = new Card[0];
        numCards = 0;
    }

    /**
     * removes all cards from the hand (simplest way possible)
     */
    public void resetHand() {
        myCards = new Card[0];
        numCards = 0;
    }

    /**
     * adds a card to the next available position in myCards
     * provides object copy not a reference copy
     *
     * @param card - the card to be stored in the array
     * @return - t/f if card take was successful
     */
    public boolean takeCard(Card card) {

        // case for not adding a cards
        if (card.getErrorFlag() || numCards == MAX_CARDS) {
            return false;
        }

        // since we haven't learned about enummerated lists or vectors yet,
        // we have to create the array again with an additional space
        int currentLength = myCards.length;
        int newLength = currentLength + 1;
        Card[] currentHand = myCards.clone();
        myCards = new Card[newLength];

        // copy all cards, no references, the list can be deleted
        for (int i = 0; i < currentLength; i++) {
            myCards[i] =
                    new Card(currentHand[i].getValue(), currentHand[i].getSuit());
        }

        // add the new card
        myCards[newLength - 1] = new Card(card.getValue(), card.getSuit());
        numCards++;

        return true;
    }

    /**
     * returns and removes the top occupied position of the array (last element)
     *
     * @return - the card that was removed from the myCards
     */
    public Card playCard() {
        // what if there are no cards to play, for now return new card with error
        int length = myCards.length;
        if (length < 1) {
            return new Card('*', Card.Suit.spades);
        }

        int newLength = length - 1;
        Card playedCard = new Card(myCards[newLength].getValue(),
                myCards[newLength].getSuit());
        Card[] oldHand = myCards.clone();

        //remove the card from the array, recreate the array
        myCards = new Card[newLength];
        for (int i = 0; i < newLength; i++) {
            myCards[i] = new Card(oldHand[i].getValue(), oldHand[i].getSuit());
        }

        // decrement the hand count
        numCards--;

        return playedCard;
    }


    /**
     * returns all cards in the hand as a string
     */
    @Override
    public String toString() {
        StringBuilder hand = new StringBuilder("Hand = ( ");

        for (int i = 0; i < numCards; i++) {
            hand.append(myCards[i].toString());
            if (i != numCards - 1) {
                hand.append(", ");
            }
        }

        hand.append(" )");

        return hand.toString();
    }

    /**
     * returns a copy of the card in myArray based on the parameter position
     * if the card is not found, return a new card with errorFlag = true
     *
     * @param k - position in the array to search
     * @return - copy of the found card, or card with errorFlag
     */
    public Card inspectCard(int k) {
        try {
            return myCards[k];
        } catch (Exception ex) {
            // expect out of bounds or invalid parameter exception
            // return card with invalid data to set error flag (per instructions)
            // There is no other way to set the error flag
            return new Card('*', Card.Suit.spades);
        }
    }

}// end Hand class

// Phase 3: The Deck Class
class Deck {
    public static void main(String[] args) {
        // Test of Class Deck (from phase 3)

        System.out.println("----------- 2 Decks (Unshuffled) ------------------");
        Deck doubleDeck = new Deck(2);

        int i = 0;
        while (i < doubleDeck.cards.length) {
            System.out.println(doubleDeck.cards[i].toString());
            i += 1;
        }
        System.out.println("----------- 2 Decks (Shuffled) --------------------");

        i = 0;
        doubleDeck.init(2);
        doubleDeck.shuffle();

        while (i < doubleDeck.cards.length) {
            System.out.println(doubleDeck.cards[i].toString());
            i += 1;
        }
        System.out.println("-------------------------------------------------\n");

        System.out.println("----------- 1 Deck (Unshuffled) -------------------");

        Deck singleDeck = new Deck();

        i = 0;

        while (i < singleDeck.cards.length) {
            System.out.println(singleDeck.cards[i].toString());
            i += 1;
        }
        System.out.println("----------- 1 Deck (Shuffled) ---------------------");

        i = 0;
        singleDeck.init(1);
        singleDeck.shuffle();

        while (i < singleDeck.cards.length) {
            System.out.println(singleDeck.cards[i].toString());
            i += 1;
        }
        System.out.println("-------------------------------------------------\n");

    }


    public final int MAX_CARDS = 312;
    private static Card[] masterPack = new Card[52];
    private Card[] cards;
    private int topCard;

    // Constructors
    public Deck(int numPacks) {
        allocateMasterPack();
        init(numPacks);
        topCard = 0;
    }

    public Deck() {
        allocateMasterPack();
        cards = masterPack;
    }

    // Re-populates the cards[] with new cards. Resetting it to its original,
    //unshuffled state.
    // Methods
    public void init(int numPacks) {
        cards = new Card[numPacks * 52];
        int index = 0;

        while (numPacks > 0) {
            for (Card card : masterPack) {
                cards[index] = card;
                index++;
            }
            topCard = 0;
            numPacks -= 1;
        }
    }

    // Shuffles the cards[] by iterating through the cards[] and placing the
    // card in each index in a random index.
    public void shuffle() {
        Random rand = new Random();
        int num;
        Card tempCard;

        for (int i = 0; i < cards.length; i++) {
            num = rand.nextInt(52);
            tempCard = cards[num];
            cards[num] = cards[i];
            cards[i] = tempCard;
        }
    }

    // Returns the card at the 'topCard' position of the deck and simulates the
    // removal from the deck by incrementing topCard by 1. Also, returns
    // null if there are no more cards left.
    public Card dealCard() {
        if (topCard == cards.length) {
            return null;
        }

        int temp = topCard;
        topCard += 1;
        return cards[temp];
    }

    public int getTopCard() {
        return topCard;
    }

    // Returns the card in index k of the cards[]. If cards[k] is out of bounds,
    // then it returns a card with errorFlag set to true.
    public Card inspectCard(int k) {
        try {
            return cards[k];
        } catch (Exception e) {
            return new Card('f', Card.Suit.spades);
        }
    }

    // Populates the masterPack[] with cards.
    private static void allocateMasterPack() {
        // Checks to see if masterPack[] has already been filled
        if (masterPack[0] != null) {
            return;
        }

        // These four blocks fill the masterPack with Cards
        masterPack[0] = new Card('K', Card.Suit.spades);
        masterPack[1] = new Card('Q', Card.Suit.spades);
        masterPack[2] = new Card('J', Card.Suit.spades);
        masterPack[3] = new Card('T', Card.Suit.spades);
        masterPack[4] = new Card('9', Card.Suit.spades);
        masterPack[5] = new Card('8', Card.Suit.spades);
        masterPack[6] = new Card('7', Card.Suit.spades);
        masterPack[7] = new Card('6', Card.Suit.spades);
        masterPack[8] = new Card('5', Card.Suit.spades);
        masterPack[9] = new Card('4', Card.Suit.spades);
        masterPack[10] = new Card('3', Card.Suit.spades);
        masterPack[11] = new Card('2', Card.Suit.spades);
        masterPack[12] = new Card('A', Card.Suit.spades);

        masterPack[13] = new Card('K', Card.Suit.hearts);
        masterPack[14] = new Card('Q', Card.Suit.hearts);
        masterPack[15] = new Card('J', Card.Suit.hearts);
        masterPack[16] = new Card('T', Card.Suit.hearts);
        masterPack[17] = new Card('9', Card.Suit.hearts);
        masterPack[18] = new Card('8', Card.Suit.hearts);
        masterPack[19] = new Card('7', Card.Suit.hearts);
        masterPack[20] = new Card('6', Card.Suit.hearts);
        masterPack[21] = new Card('5', Card.Suit.hearts);
        masterPack[22] = new Card('4', Card.Suit.hearts);
        masterPack[23] = new Card('3', Card.Suit.hearts);
        masterPack[24] = new Card('2', Card.Suit.hearts);
        masterPack[25] = new Card('A', Card.Suit.hearts);

        masterPack[26] = new Card('K', Card.Suit.diamonds);
        masterPack[27] = new Card('Q', Card.Suit.diamonds);
        masterPack[28] = new Card('J', Card.Suit.diamonds);
        masterPack[29] = new Card('T', Card.Suit.diamonds);
        masterPack[30] = new Card('9', Card.Suit.diamonds);
        masterPack[31] = new Card('8', Card.Suit.diamonds);
        masterPack[32] = new Card('7', Card.Suit.diamonds);
        masterPack[33] = new Card('6', Card.Suit.diamonds);
        masterPack[34] = new Card('5', Card.Suit.diamonds);
        masterPack[35] = new Card('4', Card.Suit.diamonds);
        masterPack[36] = new Card('3', Card.Suit.diamonds);
        masterPack[37] = new Card('2', Card.Suit.diamonds);
        masterPack[38] = new Card('A', Card.Suit.diamonds);

        masterPack[39] = new Card('K', Card.Suit.clubs);
        masterPack[40] = new Card('Q', Card.Suit.clubs);
        masterPack[41] = new Card('J', Card.Suit.clubs);
        masterPack[42] = new Card('T', Card.Suit.clubs);
        masterPack[43] = new Card('9', Card.Suit.clubs);
        masterPack[44] = new Card('8', Card.Suit.clubs);
        masterPack[45] = new Card('7', Card.Suit.clubs);
        masterPack[46] = new Card('6', Card.Suit.clubs);
        masterPack[47] = new Card('5', Card.Suit.clubs);
        masterPack[48] = new Card('4', Card.Suit.clubs);
        masterPack[49] = new Card('3', Card.Suit.clubs);
        masterPack[50] = new Card('2', Card.Suit.clubs);
        masterPack[51] = new Card('A', Card.Suit.clubs);
    }
}
