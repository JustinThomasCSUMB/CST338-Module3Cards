
public class Hand
{
   // max number of cards in a deck, 1 person hand
   public static final int MAX_CARDS = 52;
   
   Card[] myCards;
   int numCards; //this could be a function that returns myCards.length()
   
   public int getNumCards()
   {
      return numCards;
   }

   Hand(){
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
    * @param card - the card to be stored in the array 
    * @return - t/f if card take was successful
    */
   public boolean takeCard(Card card) {
      
      // case for not adding a cards
      if(card.getErrorFlag() || numCards == MAX_CARDS) {
         return false; 
      }
      
      // since we haven't learned about enummerated lists or vectors yet,
      // we have to create the array again with an additional space
      int currentLength = myCards.length;
      int newLength = currentLength + 1;
      Card[] currentHand = myCards.clone();
      myCards = new Card[newLength];
      
      // copy all cards, no references, the list can be deleted
      for(int i = 0; i < currentLength; i++) {
         myCards[i] = new Card(currentHand[i].getValue(), currentHand[i].getSuit());         
      }
      
      // add the new card
      myCards[newLength - 1] = new Card(card.getValue(), card.getSuit());
      numCards++;
      
      return true;
   }
   
   /**
    * returns and removes the top occupied position of the array (last element)
    * @return - the card that was removed from the myCards
    */
   public Card playCard() {
      // what if there are no cards to play, for now return new card with error
      // TODO: implement this better or have error check before this is called
      int length = myCards.length;
      if(length < 1) {
         return new Card('*', Card.Suit.spades);
      }
      
      int newLength = length - 1;
      Card playedCard = new Card(myCards[newLength].getValue(), myCards[newLength].getSuit());
      Card[] oldHand = myCards.clone();
      
      //remove the card from the array, recreate the array      
      myCards = new Card[newLength];
      for(int i = 0; i < newLength; i++){
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
      String hand = "Hand = ( ";
      ;
      
      for(int i = 0; i < numCards; i++) {
         hand += myCards[i].toString();
         if(i != numCards - 1) {
            hand += ", ";
         }
      }
      
      hand += " )";
      
      return hand;
   }
   
   /**
    * returns a copy of the card in myArray based on the parameter position
    * if the card is not found, return a new card with errorFlag = true
    * @param k - position in the array to search
    * @return - copy of the found card, or card with errorFlag
    */
   public Card inspectCard(int k) {
      try {
         return myCards[k];
      }catch(Exception ex) {
         // expect out of bounds or invalid parameter exception
         // return card with invalid data to set error flag (per instructions)
         // There is no other way to set the error flag
         return new Card('*', Card.Suit.spades);     
      }   
   }   
   
}// end Hand class

/**
 * Test output phase 2
Filling Hand
HandFull
Testing inspectCard()
A of spades
** illegal **
Printing full hand
Hand = ( A of spades, J of clubs, A of spades, J of clubs, A of spades, J of clu
bs, A of spades, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A
 of spades, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A of s
pades, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A of spades
, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A of spades, J o
f clubs, A of spades, J of clubs, A of spades, J of clubs, A of spades, J of clu
bs, A of spades, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A
 of spades, J of clubs, A of spades, J of clubs, A of spades, J of clubs, A of s
pades, J of clubs )
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
J of clubs
A of spades
Printing empty hand
Hand = (  )

 */
