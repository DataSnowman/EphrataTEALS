package sampleCode.Games;

import java.util.Scanner; 

public class DenverGame {
    public static void sleep(int amt) // In milliseconds
{
    long a = System.currentTimeMillis();
    long b = System.currentTimeMillis();
    while ((b - a) <= amt)
    {
        b = System.currentTimeMillis();
    }
}
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in); 
        boolean inTurn = false;
        boolean inGame = false;
 
        
        
        while (inGame == false){
        
        System.out.println("BlackJack by Denver Wilson");
        System.out.println("What would you like to do?");
        System.out.println("Input a 1 to start the game.");
        System.out.println("Input a 2 to view the rules.");
        
        int lobbyInput = console.nextInt();
        
        if (lobbyInput == 1){
        inGame = true;
        }
        
        else if (lobbyInput == 2){
        System.out.println("The dealer deals 2 cards, one to each of you.");
        
        System.out.println("Standard 52 card deck.");
        System.out.println("Dealer will always draw to surpass you.");
        System.out.println("Successfully drawing 5 times without going over will result in a win.");
        System.out.println("An ace will have a value of 11 until you bust, resulting in the value becoming 1.");
        sleep(5000);
        }
        
        }
        
        while (inGame == true){
     
        
        inTurn = true;
        
        int max = 13; 
        int min = 1; 
        int range = max - min + 1; 
        int value = 0;
        int DealerValue = 0;
        int turnTotal = 1;
        int dealerTurnTotal = 1;
        int dealerAce = 0;
        int ace = 0;
        boolean DealerTurn = false;
        String cardName = "name";
        
                System.out.println("The dealer deals 2 cards, one to each of you.");
         for (int i = 0; i < 1; i++) { 
            int cardValue = (int)(Math.random() * range) + min; 
            if (cardValue == 1) {
             cardName="ace";
             ace+=1;
             value+=10;
             } 
             else if (cardValue == 11){
             cardName="Jack";
             value-=1;
             }
             else if (cardValue == 12){
             cardName="Queen";
             value-=2;
             }
             else if (cardValue == 13){
             cardName="King";
             value-=3;
             }
             else {
             cardName = String.valueOf(cardValue);
             }
            System.out.println("You start with a "+cardName+"!");
            value += cardValue;
            sleep(1000);
            }
             for (int i = 0; i < 1; i++) { 
            int cardValue = (int)(Math.random() * range) + min; 
            if (cardValue == 1) {
             cardName="ace";
             dealerAce+=1;
             DealerValue+=10;
             } 
             else if (cardValue == 11){
             cardName="Jack";
             DealerValue-=1;
             }
             else if (cardValue == 12){
             cardName="Queen";
             DealerValue-=2;
             }
             else if (cardValue == 13){
             cardName="King";
             DealerValue-=3;
             }
             else {
             cardName = String.valueOf(cardValue);
             }
            DealerValue += cardValue;
            System.out.println("The dealer starts with a "+cardName+"!");
            }
            sleep(1000);
                
        while (inTurn == true){            
        System.out.println("Card Value: "+value+" with "+ace+" aces");
        System.out.println("Dealer's Card Value: "+DealerValue+" with "+dealerAce+" aces");
        System.out.println("What would you like to do?");
        System.out.println("Please input a 1 to hit or a 2 to stand");
        
         
               
        int hitorstand = console.nextInt();
        if (hitorstand == 1){ 
 
        for (int i = 0; i < 1; i++) { 
            int cardValue = (int)(Math.random() * range) + min;
             value += cardValue;
             if (cardValue == 1) {
             cardName="ace";
             ace+=1;
             value+=10;
             } 
             else if (cardValue == 11){
             cardName="Jack";
             value-=1;
             }
             else if (cardValue == 12){
             cardName="Queen";
             value-=2;
             }
             else if (cardValue == 13){
             cardName="King";
             value-=3;
             }
             else {
             cardName = String.valueOf(cardValue);
             }
            System.out.println("Alright, you drew a "+cardName+"!");
            
        } 
        System.out.println("Your new total card value is "+value+"!");
        sleep(2000);
         if (value>21 && ace == 0){
        System.out.println("Your total card value went over 21, bust!");
        sleep(2500);
        inTurn=false;
        }
        else if (value>33){
        System.out.println("Your total card value went over 21, bust!");
        sleep(2500);
        inTurn=false;
        }
        else if (value>21 && ace>0 && value<33){
        value-=10;
        ace-=1;
        System.out.println("Your ace was converted to a 1!");
        sleep(2500);
        }


        }
        else if (hitorstand == 2){
        System.out.println("Alright, you will stand for the rest of this game.");
        DealerTurn = true;
       }
     while (DealerTurn == true){
        while (DealerValue<=value && DealerValue<22){
              for (int i = 0; i < 1; i++) { 
            int cardValue = (int)(Math.random() * range) + min; 
            DealerValue += cardValue;
              if (cardValue == 1) {
             cardName="ace";
             dealerAce+=1;
             DealerValue+=10;
             } 
             else if (cardValue == 11){
             cardName="Jack";
             DealerValue-=1;
             }
             else if (cardValue == 12){
             cardName="Queen";
             DealerValue-=2;
             }
             else if (cardValue == 13){
             cardName="King";
             DealerValue-=3;
             }
             else {
             cardName = String.valueOf(cardValue);
             }
            System.out.println("The dealer drew a "+cardName+"! Their new total is "+DealerValue+"!");
            sleep(1000);
            }
         }   
        if (value>DealerValue && value<22){
        System.out.println("You win against the dealer with a score of "+value+" to a score of "+DealerValue+"!");
        sleep(2000);
        inTurn = false;
        DealerTurn = false;
        }
        if (value<DealerValue && DealerValue<=21){
        System.out.println("You lose against the dealer with a score of "+value+" to a score of "+DealerValue+"!");
        sleep(2000);
        inTurn = false;
        DealerTurn = false;
        }
         if (DealerValue>21 && dealerAce == 0){
        System.out.println("You win against the dealer with a score of "+value+" to a score of "+DealerValue+"!");
        sleep(2000);
        inTurn = false;
        DealerTurn = false;
        }
        else if (DealerValue>33){
        System.out.println("You win against the dealer with a score of "+value+" to a score of "+DealerValue+"!");
        sleep(2500);
        inTurn=false;
        DealerTurn = false;
        }
        else if (DealerValue>21 && dealerAce>0 && DealerValue<33){
        DealerValue-=10;
        dealerAce-=1;
        System.out.println("The dealer's ace was converted to a 1!");
        sleep(2000);
        }
         if (DealerValue==21 && value==21){
        System.out.println("Both you and the dealer have a score of 21, DRAW!");
        sleep(2000);
        inTurn = false;
        DealerTurn = false;
        }
       }
       }
       }
   }
}

   
    


