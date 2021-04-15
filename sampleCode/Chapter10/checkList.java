package sampleCode.Chapter10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class checkList {

   public static void main(String[] args) {
    
      //Initialize the ArrayList
      ArrayList <String> checkList = new ArrayList<String>();
      
      System.out.println("Enter items you would like to add to the Checklist");
      
      Scanner inputScanner = new Scanner(System.in);
      String inputLine = inputScanner.nextLine();
      checkList.add(inputLine);
        
        while (!inputLine.equals("quit"))
        {
            System.out.println(checkList);
            inputLine = inputScanner.nextLine();
            checkList.add(inputLine);
            
            /* Show list before and after Sorting of arraylist using Collections.sort*/
            System.out.println("Before sort, items = " + checkList);
            Collections.sort(checkList);
            System.out.println("After sort, items = " + checkList);

            // What parameters do you need to pass?
            //sortCheckList(?, ?);
        }
    }

      
      
    //Sort the Checklist items
      
   public static void sortCheckList (ArrayList<String> list, String item) {
      
	   /* Write a for loop or for each loop that prints the sorted list with one item per row  */
	   


   }   
}