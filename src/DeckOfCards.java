
public class DeckOfCards
{

   public static void main(String[] args)
   {
      // TODO: QC delete all Card Class Tests
      // Card Class Tests
      Card card1, illegalCard, card3;
      card1 = new Card();
      System.out.println(card1.toString());
      illegalCard = new Card('U', Card.Suit.diamonds);
      System.out.println(illegalCard.toString());
      card3 = new Card('j', Card.Suit.clubs);
      System.out.println(card3.toString());

      // Card class equality check
      Card identicalCard3 = new Card('J', Card.Suit.clubs);
      System.out.println(card1.equals(identicalCard3));
      System.out.println(identicalCard3.equals(card3));
      // End Card Class Tests
   }

}

class Card {
   // enum storing card suits
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

      // Return true if value is a valid value else false
      return ((value >= '2' && value <= '9') ||
              value == 'A' ||
              value == 'K' ||
              value == 'J' ||
              value == 'T');
   }
}

