
/**
 * Purpose: To play the 99 point game with the user
 * 
 * @author Emily Jewik 
 * @version 12/14/17
 */
import java.util.Scanner;
public class CardGame99
{
   public static int askPoints()
   {
       int totalPoints = 0;
       Scanner in = new Scanner(System.in);
       System.out.println("What is the initial point value?");
       totalPoints = in.nextInt();
       return totalPoints;
   }
   
   public static String askCard()
   {
       String card = "";
       Scanner in = new Scanner(System.in);
       System.out.println("Please input one card: " );
       card = in.next();
       return card;
   }
   
   public static String askDealer()
   {
       String card = "";
       Scanner in = new Scanner(System.in);
       System.out.println("What does dealer deal? " );
       card = in.next();
       return card;
   }
   
   public static int wantContinue()
   {
       int counter = 0;
       Scanner in = new Scanner(System.in);
       System.out.println("Would you like to continue? ( Y or N )");
       String answer = in.next();
       if( answer.equalsIgnoreCase( "Y" ) )
       {
       }
       else if( answer.equalsIgnoreCase( "N" ) )
       {
           counter++;
       }
       else
       {
           System.out.println("That is not an option. Please try again.");
           counter++;
       }
       return counter;
   }
    
   public static void main(String[] args)
   {
       
       
       int[] numbers = { 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 };
       String[] lettersAndNumbers = { "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "T" , "J" , "Q" , "K" , "A" };
       int totalPoints = 0;
       int cardValue1 = 0;
       int cardValue2 = 0;
       int cardValue3 = 0;
       int dealerValue = 0;
       int counter = 0;
       boolean totalPtsOver99 = false;
       
       System.out.println("ACSL Ninety-Nine");
       
       while( counter == 0 )
       {
       totalPtsOver99 = false;
       totalPoints = askPoints();
       
       
       String stringCard1 = askCard();
       String stringCard2 = askCard();
       String stringCard3 = askCard(); 
       
       for( int i = 0; i < numbers.length; i++ )
       {
           if( stringCard1.equalsIgnoreCase( lettersAndNumbers[i] ) )
           {
               cardValue1 = numbers[i];
           }
            if( stringCard2.equalsIgnoreCase( lettersAndNumbers[i] ) )
           {
               cardValue2 = numbers[i];
           }
            if( stringCard3.equalsIgnoreCase( lettersAndNumbers[i] ) )
           {
               cardValue3 = numbers[i];
           }
       }
       
       while( totalPoints < 100 )
       {
          
          
           
           if( cardValue1 > cardValue2 && cardValue1 > cardValue3  )
           {
                 if( cardValue1 == 14 && cardValue1 + totalPoints > 99 )
            {
                  cardValue1 = 1;
            }
             if( cardValue1 == 10 )
            {
                   cardValue1 = -10;
            }
            if( cardValue1 != 9 )
            {
               totalPoints += cardValue1;
            }
               stringCard1 = askCard();
               for( int i = 0; i < numbers.length; i++ )
            {
               if( stringCard1.equalsIgnoreCase( lettersAndNumbers[i] ) )
              {
               cardValue1 = numbers[i];
              }
            }
              
            }
           else if( cardValue2 >= cardValue1 && cardValue2 > cardValue3  )
           {
               if( cardValue2 == 14 && cardValue2 + totalPoints > 99 )
               {
                   cardValue2 = 1;
               }
               if( cardValue2 == 10 )
               {
                   cardValue2 = -10;
               }
               if( cardValue2 != 9 )
               {
               totalPoints += cardValue2;
               }
               stringCard2 = askCard();
               
                  for( int i = 0; i < numbers.length; i++ )
            {
               if( stringCard2.equalsIgnoreCase( lettersAndNumbers[i] ) )
              {
               cardValue2 = numbers[i];
              }
            }
            
           }
           else 
           {
                
           if( cardValue3 == 14 && cardValue3 + totalPoints > 99 )
           {
               cardValue3 = 1;
           }
              
               if( cardValue3 == 10 )
               {
                   cardValue3 = -10;
               }
               if( cardValue3 != 9 )
               {
               totalPoints += cardValue3;
               }
              
               stringCard3 = askCard();
               
                  for( int i = 0; i < numbers.length; i++ )
            {
               if( stringCard3.equalsIgnoreCase( lettersAndNumbers[i] ) )
              {
               cardValue3 = numbers[i];
              }
            }
            
           }
           
           if( totalPoints > 99 )
           {
               totalPtsOver99 = true;
               break;
           }
         
           String dealerString = askDealer();
           
           for( int i = 0; i < numbers.length; i++ )
           {
               if( dealerString.equalsIgnoreCase( lettersAndNumbers[i] ) )
               {
                   dealerValue = numbers[i];
               }
           }
           if( dealerValue == 14 && totalPoints + dealerValue > 99 )
           {
               dealerValue = 1;
           }
           if( dealerValue == 10 )
           {
               dealerValue = -10;
           }
          // System.out.println(" d: " + dealerValue);
           if( dealerValue != 9 )
           {
               totalPoints += dealerValue;
           }
           
           
       }
       
       if( totalPtsOver99  )
       {
           System.out.println("The dealer has won! Point total: " + totalPoints );
           System.out.println();
       }
       else
       {
           System.out.println("The player has won! Point total: " + totalPoints );
           System.out.println();
       }
       
       counter = wantContinue();
       
    }
}
}
   