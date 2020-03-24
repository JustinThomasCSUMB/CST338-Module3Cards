/**
 * Group 4
 * Justin Thomas
 * Marcos Barrera
 * Cristian Vazquez
 * Michael Janes
 * CST338 Module
 */


public class DeckOfCards
{

   public static void main(String[] args)
   {
      // TODO: QC delete all Card Class Tests
      // Card Class Tests
      Card card1, illegalCard, card3;
      card1 = new Card();
//      System.out.println(card1.toString());
//      illegalCard = new Card('U', Card.Suit.diamonds);
//      System.out.println(illegalCard.toString());
      card3 = new Card('j', Card.Suit.clubs);
//      System.out.println(card3.toString());


      // Hand class debug code (phase 2)
      // TODO: remove when finished
      Hand myHand = new Hand();
      boolean success = true;

      System.out.println("Filling Hand");
      for(int i = 0; i < 100; i++) {
         success = myHand.takeCard(card1);
         success = myHand.takeCard(card3);

         if(!success) {
            System.out.println("HandFull");
            break;
         }
      }

      System.out.println("Testing inspectCard()");
      Card inspect1 = myHand.inspectCard(10);
      Card inspect2 = myHand.inspectCard(-1);

      System.out.println(inspect1.toString());
      System.out.println(inspect2.toString());

      System.out.println("Printing full hand");
      System.out.println(myHand.toString());

      for(int i = 0; i < 52; i++) {
         System.out.println(myHand.playCard().toString());
      }

      System.out.println("Printing empty hand");
      System.out.println(myHand.toString());
       // end phase 2 test code


      // Card class equality check
      /*
       * Card identicalCard3 = new Card('J', Card.Suit.clubs);
       * System.out.println(card1.equals(identicalCard3));
       * System.out.println(identicalCard3.equals(card3));
       */
      // End Card Class Tests
   }

}

class Card {
   // enum storing card suits (Method made static)
   public static enum Suit {clubs, diamonds, hearts, spades}

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
   public Card(char value , Suit suit) {
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
      if (isValid(upperValue,suit)) {
         this.value = upperValue;
         this.suit = suit;
         errorFlag = false;
         return true;
      }
      else {
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
