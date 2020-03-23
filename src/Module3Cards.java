import java.util.*;

public class Module3Cards
{
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int maxPlayers = 0;
      int currentPlayer = 0;
      Deck deck = new Deck();

      
      //Confirms user input is an accepted value
      //@userInput int between 1-10
      while(true) 
      {
         try 
         {
            System.out.println("Please select a number of players 1-10");
            maxPlayers=in.nextInt();
         }
         catch(InputMismatchException exception) 
         {
            System.out.println("This is not an accepted value!");
            in.nextLine();
         }
         
         //Value is a confirmed int, this confirms it is between 1-10
         if(maxPlayers > 0 && maxPlayers < 11) 
         {
            break;
         }
         
         
      }
      
      
      Hand[] playerHands = new Hand[maxPlayers];      
      //Populates the playerHands[]
      for(int i = 0; i < maxPlayers; i++)
      {
         playerHands[i] = new Hand();
      }
      
      //Deals out the entire deck
      while(!deck.inspectCard(deck.getTopCard()).getErrorFlag()) 
      {
         
         //Places a card in each players hand
         playerHands[currentPlayer].takeCard(deck.dealCard());
         currentPlayer++;
         
         //makes sure we are staying within the given range of players
         if(currentPlayer >= maxPlayers) 
         {
            currentPlayer = 0;
         }
  
         
      }
      
      //Prints out every players hand & then resets it
      System.out.println("Here are our hands, from the unshuffled deck:");
      for(int i = 0; i < playerHands.length; i++) 
      {
         System.out.println((i+1) +" " + playerHands[i].toString());
         System.out.println();
         playerHands[i].resetHand();
      }
     
      //Reset's the deck, opperating under the assumption that there is only
      //one deck in play
      deck.init(1);
      deck.shuffle();
      currentPlayer = 0;
      

      while(!deck.inspectCard(deck.getTopCard()).getErrorFlag()) 
      {
         
         
         playerHands[currentPlayer].takeCard(deck.dealCard());
         currentPlayer++;
         if(currentPlayer >= maxPlayers) 
         {
            currentPlayer = 0;
         }

         
      }
      
      //Prints out every players hand & then resets it
      System.out.println("Here are our hands, from the shuffled deck:");
      for(int i = 0; i < playerHands.length; i++) 
      {
         System.out.println((i+1) +" "+playerHands[i].toString());
         System.out.println();
         playerHands[i].resetHand();
      }
      
      in.close();
   } 
   
}


/************** OUTPUT **************
Please select a number of players 1-10
19
Please select a number of players 1-10
a
This is not an accepted value!
Please select a number of players 1-10
11
Please select a number of players 1-10
10
Here are our hands, from the unshuffled deck:
1 Hand = ( K of spades, 3 of spades, 6 of hearts, 9 of diamonds, Q of clubs, 2 o
f clubs )

2 Hand = ( Q of spades, 2 of spades, 5 of hearts, 8 of diamonds, J of clubs, A o
f clubs )

3 Hand = ( J of spades, A of spades, 4 of hearts, 7 of diamonds, T of clubs )

4 Hand = ( T of spades, K of hearts, 3 of hearts, 6 of diamonds, 9 of clubs )

5 Hand = ( 9 of spades, Q of hearts, 2 of hearts, 5 of diamonds, 8 of clubs )

6 Hand = ( 8 of spades, J of hearts, A of hearts, 4 of diamonds, 7 of clubs )

7 Hand = ( 7 of spades, T of hearts, K of diamonds, 3 of diamonds, 6 of clubs )

8 Hand = ( 6 of spades, 9 of hearts, Q of diamonds, 2 of diamonds, 5 of clubs )

9 Hand = ( 5 of spades, 8 of hearts, J of diamonds, A of diamonds, 4 of clubs )

10 Hand = ( 4 of spades, 7 of hearts, T of diamonds, K of clubs, 3 of clubs )

Here are our hands, from the shuffled deck:
1 Hand = ( 6 of clubs, 4 of spades, T of diamonds, 4 of hearts, Q of clubs, 3 of
 clubs )

2 Hand = ( A of spades, 7 of diamonds, 8 of hearts, 5 of diamonds, K of clubs, K
 of hearts )

3 Hand = ( J of diamonds, K of spades, K of diamonds, J of spades, 6 of diamonds
 )

4 Hand = ( T of spades, 5 of spades, 3 of hearts, 2 of clubs, 8 of clubs )

5 Hand = ( 8 of spades, 3 of spades, Q of spades, 9 of diamonds, 6 of spades )

6 Hand = ( 7 of spades, 2 of spades, 8 of diamonds, 4 of clubs, 5 of clubs )

7 Hand = ( J of hearts, 9 of hearts, A of hearts, 3 of diamonds, 9 of spades )

8 Hand = ( J of clubs, T of hearts, 2 of diamonds, 5 of hearts, 2 of hearts )

9 Hand = ( T of clubs, 6 of hearts, 7 of clubs, A of clubs, A of diamonds )

10 Hand = ( 7 of hearts, Q of diamonds, Q of hearts, 9 of clubs, 4 of diamonds )

***********************************************************/
