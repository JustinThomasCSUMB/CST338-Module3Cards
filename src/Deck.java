// Name: Cristian Vazquez, Justin Thomas, Marcos Barrera, Michael Janes
// Class: CST 338 - Module 3
// Assignment: Decks of Cards
// Date: 22 March 2020

import java.util.Random;

// Phase 3: The Deck Class
public class Deck
{
   public static void main(String[] args)
   {
      // Test of Class Deck (from phase 3)
      
      System.out.println("----------- 2 Decks (Unshuffled) ------------------");
      Deck doubleDeck = new Deck(2);
      
      int i = 0;
      while (i < doubleDeck.cards.length)
      {
         System.out.println( doubleDeck.cards[i].toString() );
         i += 1;
      }
      System.out.println("----------- 2 Decks (Shuffled) --------------------");
      
      i = 0;
      doubleDeck.init(2);
      doubleDeck.shuffle();
      
      while (i < doubleDeck.cards.length)
      {
         System.out.println( doubleDeck.cards[i].toString() );
         i += 1;
      }
      System.out.println("-------------------------------------------------\n");
      
      System.out.println("----------- 1 Deck (Unshuffled) -------------------");
      
      Deck singleDeck = new Deck();
      
      i = 0;
      
      while (i < singleDeck.cards.length)
      {
         System.out.println( singleDeck.cards[i].toString() );
         i += 1;
      }
      System.out.println("----------- 1 Deck (Shuffled) ---------------------");
      
      i = 0;
      singleDeck.init(1);
      singleDeck.shuffle();
      
      while (i < singleDeck.cards.length)
      {
         System.out.println( singleDeck.cards[i].toString() );
         i += 1;
      }
      System.out.println("-------------------------------------------------\n");
      
   }
   

   public final int MAX_CARDS = 312;
   private static Card[] masterPack = new Card[52];
   private Card[] cards;
   private int topCard;
   
   // Constructors
   public Deck(int numPacks)
   {  
      allocateMasterPack();
      init(numPacks);
      topCard = 0;
   }
   
   public Deck()
   {
      allocateMasterPack();
      cards = masterPack;
   }
   
   // Re-populates the cards[] with new cards. Resetting it to its original,
   //unshuffled state.
   // Methods
   public void init(int numPacks)
   {
      cards = new Card[numPacks * 52];
      int index = 0;
      
      while (numPacks > 0)
      {
         for (int i = 0; i < masterPack.length; i++)
         {
            cards[index] = masterPack[i];
            index++;
         }
         
         numPacks -= 1;
      }     
   }
  
   // Shuffles the cards[] by iterating through the cards[] and placing the
   // card in each index in a random index.
   public void shuffle()
   {
      Random rand = new Random();
      int num;
      Card tempCard;
      
      for (int i = 0; i < cards.length; i++)
      {
         num = rand.nextInt(52);
         tempCard = cards[num];
         cards[num] = cards[i];
         cards[i] = tempCard;
      }
   }
   
   // Returns the card at the 'topCard' position of the deck and simulates the
   // removal from the deck by incrementing topCard by 1. Also, throws an
   // exception if the 'topCard' index exceeds the number of cards in the deck.
   public Card dealCard()
   {
      if (topCard == cards.length)
      {
         throw new NullPointerException("NO MORE CARDS LEFT TO DEAL!");
      }
      
      int temp = topCard;
      topCard += 1;
      return cards[temp];
   }

   public int getTopCard()
   {
      return topCard;
   }

   // Returns the card in index k of the cards[]. If cards[k] is out of bounds,
   // then it returns a card with errorFlag set to true.
   public Card inspectCard(int k)
   {
      try
      {
         return cards[k];
      }
      catch (Exception e)
      {
         return new Card('f', Card.Suit.spades);
      }     
   }
   
   // Populates the masterPack[] with cards.
   private static void allocateMasterPack()
   {
      // Checks to see if masterPack[] has already been filled
      if (masterPack[0] != null)
      {
         return;
      }
      
      // These four blocks fill the masterPack with Cards
      masterPack[0] = new Card('A', Card.Suit.clubs);
      masterPack[1] = new Card('K', Card.Suit.hearts);
      masterPack[2] = new Card('2', Card.Suit.clubs);
      masterPack[3] = new Card('3', Card.Suit.clubs);
      masterPack[4] = new Card('4', Card.Suit.clubs);
      masterPack[5] = new Card('5', Card.Suit.clubs);
      masterPack[6] = new Card('6', Card.Suit.clubs);
      masterPack[7] = new Card('7', Card.Suit.clubs);
      masterPack[8] = new Card('8', Card.Suit.clubs);
      masterPack[9] = new Card('9', Card.Suit.clubs);
      masterPack[10] = new Card('T', Card.Suit.clubs);
      masterPack[11] = new Card('Q', Card.Suit.clubs);
      masterPack[12] = new Card('K', Card.Suit.clubs);
      
      masterPack[13] = new Card('A', Card.Suit.spades);
      masterPack[14] = new Card('Q', Card.Suit.hearts);
      masterPack[15] = new Card('2', Card.Suit.spades);
      masterPack[16] = new Card('3', Card.Suit.spades);
      masterPack[17] = new Card('4', Card.Suit.spades);
      masterPack[18] = new Card('5', Card.Suit.spades);
      masterPack[19] = new Card('6', Card.Suit.spades);
      masterPack[20] = new Card('7', Card.Suit.spades);
      masterPack[21] = new Card('8', Card.Suit.spades);
      masterPack[22] = new Card('9', Card.Suit.spades);
      masterPack[23] = new Card('T', Card.Suit.spades);
      masterPack[24] = new Card('Q', Card.Suit.spades);
      masterPack[25] = new Card('K', Card.Suit.spades);
      
      masterPack[26] = new Card('A', Card.Suit.diamonds);
      masterPack[27] = new Card('T', Card.Suit.hearts);
      masterPack[28] = new Card('2', Card.Suit.diamonds);
      masterPack[29] = new Card('3', Card.Suit.diamonds);
      masterPack[30] = new Card('4', Card.Suit.diamonds);
      masterPack[31] = new Card('5', Card.Suit.diamonds);
      masterPack[32] = new Card('6', Card.Suit.diamonds);
      masterPack[33] = new Card('7', Card.Suit.diamonds);
      masterPack[34] = new Card('8', Card.Suit.diamonds);
      masterPack[35] = new Card('9', Card.Suit.diamonds);
      masterPack[36] = new Card('T', Card.Suit.diamonds);
      masterPack[37] = new Card('Q', Card.Suit.diamonds);
      masterPack[38] = new Card('K', Card.Suit.diamonds);
      
      masterPack[39] = new Card('A', Card.Suit.hearts);
      masterPack[40] = new Card('9', Card.Suit.hearts);
      masterPack[41] = new Card('2', Card.Suit.hearts);
      masterPack[42] = new Card('3', Card.Suit.hearts);
      masterPack[43] = new Card('4', Card.Suit.hearts);
      masterPack[44] = new Card('5', Card.Suit.hearts);
      masterPack[45] = new Card('6', Card.Suit.hearts);
      masterPack[46] = new Card('7', Card.Suit.hearts);
      masterPack[47] = new Card('8', Card.Suit.hearts);      
      
      masterPack[48] = new Card('J', Card.Suit.hearts);
      masterPack[49] = new Card('J', Card.Suit.diamonds);
      masterPack[50] = new Card('J', Card.Suit.spades);
      masterPack[51] = new Card('J', Card.Suit.clubs);
   }
}
/*********************** OUTPUT ***********************************************
----------- 2 Decks (Unshuffled) ------------------
A of clubs
K of hearts
2 of clubs
3 of clubs
4 of clubs
5 of clubs
6 of clubs
7 of clubs
8 of clubs
9 of clubs
T of clubs
Q of clubs
K of clubs
A of spades
Q of hearts
2 of spades
3 of spades
4 of spades
5 of spades
6 of spades
7 of spades
8 of spades
9 of spades
T of spades
Q of spades
K of spades
A of diamonds
T of hearts
2 of diamonds
3 of diamonds
4 of diamonds
5 of diamonds
6 of diamonds
7 of diamonds
8 of diamonds
9 of diamonds
T of diamonds
Q of diamonds
K of diamonds
A of hearts
9 of hearts
2 of hearts
3 of hearts
4 of hearts
5 of hearts
6 of hearts
7 of hearts
8 of hearts
J of hearts
J of diamonds
J of spades
J of clubs
A of clubs
K of hearts
2 of clubs
3 of clubs
4 of clubs
5 of clubs
6 of clubs
7 of clubs
8 of clubs
9 of clubs
T of clubs
Q of clubs
K of clubs
A of spades
Q of hearts
2 of spades
3 of spades
4 of spades
5 of spades
6 of spades
7 of spades
8 of spades
9 of spades
T of spades
Q of spades
K of spades
A of diamonds
T of hearts
2 of diamonds
3 of diamonds
4 of diamonds
5 of diamonds
6 of diamonds
7 of diamonds
8 of diamonds
9 of diamonds
T of diamonds
Q of diamonds
K of diamonds
A of hearts
9 of hearts
2 of hearts
3 of hearts
4 of hearts
5 of hearts
6 of hearts
7 of hearts
8 of hearts
J of hearts
J of diamonds
J of spades
J of clubs
----------- 2 Decks (Shuffled) --------------------
K of spades
6 of diamonds
A of diamonds
3 of diamonds
2 of spades
9 of diamonds
5 of diamonds
Q of diamonds
9 of clubs
6 of spades
A of diamonds
7 of clubs
9 of spades
K of diamonds
9 of hearts
8 of hearts
5 of spades
8 of diamonds
Q of clubs
J of spades
9 of diamonds
3 of spades
J of hearts
4 of diamonds
7 of diamonds
6 of hearts
4 of clubs
8 of hearts
Q of spades
A of clubs
J of clubs
2 of diamonds
2 of spades
T of diamonds
A of spades
2 of hearts
J of diamonds
6 of spades
5 of hearts
7 of clubs
J of clubs
8 of clubs
4 of hearts
5 of spades
7 of hearts
5 of diamonds
3 of hearts
Q of spades
T of diamonds
5 of clubs
3 of clubs
8 of clubs
6 of clubs
K of hearts
K of hearts
3 of hearts
A of spades
2 of diamonds
J of diamonds
8 of spades
6 of hearts
K of spades
2 of clubs
T of spades
Q of hearts
A of clubs
4 of diamonds
8 of diamonds
Q of diamonds
6 of clubs
7 of diamonds
4 of clubs
Q of clubs
Q of hearts
K of clubs
T of clubs
3 of clubs
4 of spades
T of clubs
2 of clubs
7 of spades
T of hearts
4 of hearts
7 of hearts
2 of hearts
5 of hearts
7 of spades
9 of clubs
3 of spades
K of clubs
5 of clubs
K of diamonds
9 of spades
J of hearts
J of spades
A of hearts
6 of diamonds
4 of spades
T of spades
3 of diamonds
A of hearts
T of hearts
8 of spades
9 of hearts
-------------------------------------------------

----------- 1 Deck (Unshuffled) -------------------
A of clubs
K of hearts
2 of clubs
3 of clubs
4 of clubs
5 of clubs
6 of clubs
7 of clubs
8 of clubs
9 of clubs
T of clubs
Q of clubs
K of clubs
A of spades
Q of hearts
2 of spades
3 of spades
4 of spades
5 of spades
6 of spades
7 of spades
8 of spades
9 of spades
T of spades
Q of spades
K of spades
A of diamonds
T of hearts
2 of diamonds
3 of diamonds
4 of diamonds
5 of diamonds
6 of diamonds
7 of diamonds
8 of diamonds
9 of diamonds
T of diamonds
Q of diamonds
K of diamonds
A of hearts
9 of hearts
2 of hearts
3 of hearts
4 of hearts
5 of hearts
6 of hearts
7 of hearts
8 of hearts
J of hearts
J of diamonds
J of spades
J of clubs
----------- 1 Deck (Shuffled) ---------------------
6 of spades
6 of clubs
T of spades
2 of spades
5 of hearts
K of diamonds
5 of clubs
9 of diamonds
6 of hearts
K of clubs
Q of spades
8 of spades
3 of hearts
J of spades
T of diamonds
2 of clubs
Q of hearts
J of clubs
J of hearts
A of diamonds
5 of spades
K of hearts
8 of diamonds
A of clubs
7 of hearts
T of hearts
4 of hearts
9 of hearts
9 of clubs
2 of diamonds
5 of diamonds
7 of spades
Q of clubs
A of spades
A of hearts
9 of spades
4 of diamonds
4 of spades
6 of diamonds
3 of clubs
T of clubs
4 of clubs
7 of diamonds
2 of hearts
8 of hearts
J of diamonds
3 of spades
8 of clubs
Q of diamonds
3 of diamonds
K of spades
7 of clubs
-------------------------------------------------
******************************************************************************/