import java.util.*;

public class main
{
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int userInput = 0;
      
      //Confirms user input is an accepted value
      //@userInput int between 1-10
      while(true) 
      {
         try 
         {
            System.out.println("Please select a number of players 1-10");
            userInput=in.nextInt();
         }
         catch(InputMismatchException exception) 
         {
            System.out.println("This is not an accepted value!");
         }
         
         //Value is a confirmed int, this confirms it is between 1-10
         if(userInput > 0 && userInput < 11) 
         {
            break;
         }
         
         
      }
   }
}
 /*     
      //Initilize a Deck object
      //Initilize an array of Hand objects
      Deck deck = new Deck();
      Hand[] playerHands = new Hand[userInput];
      
      //Populates the playerHands[]
      for(int i = 0; i < userInput; i++)
      {
         playerHands[i] = new Hand();
      }
      
      //Deals out the entire deck putting 1 card in each hand before cont.
      //How do you check to make sure there are cards left in the deck?
      while(Deck.dealCard()) 
      {
         
         
         for(int i = 0; i < playerHands.length; i++) 
         {
            playerHands[i].takeCard(Deck.dealCard());
         }
         
         
         
      }
      
      //Prints out every players hand & then resets it
      for(int i = 0; i < playerHands.length; i++) 
      {
         System.out.println(playerHands[i].toString());
         playerHands[i].resetHand();
      }
     
      //HOW DO YOU RESET THE DECK????
   }
}
*/