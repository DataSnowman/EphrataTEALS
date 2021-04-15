package sampleCode.Chapter10;

import java.util.ArrayList;

public class integerList {
    public static void main(String[] args) {
    
      //Initialize the ArrayList
      ArrayList <Integer> numList = new ArrayList<Integer>();
      System.out.println(numList);
      
      //Add todos to the list
      
      numList.add (3);
      numList.add (8);
      numList.add (92);
      numList.add (4);
      numList.add (2);
      numList.add (17);
      numList.add (9);
      
      System.out.println(numList);
      
      
      //Call getMin
      getMin(numList);

      //Call minToFront
      //minToFront(numList);
      
      }
      
      public static void getMin (ArrayList<Integer> list) {
      
         int min = list.get(0);
         for (int i = 1; i < list.size(); i++) {
            int next = list.get(i);
            if (next < min) {
               min = next;
            }
         }
         System.out.println("min = " + min);
      }
      
      
      public static void minToFront (ArrayList<Integer> list) {
      
         int min = list.get(0);
         int listIndex = 0;
         for (int i = 1; i < list.size(); i++) {
            int next = list.get(i);
            int index = i;
            if (next < min) {
               min = next;
               listIndex = index;
            }
         }
         System.out.println("min = " + min);
         System.out.println("minListIndex = " + listIndex);
         list.remove(listIndex);
         System.out.println(list);
         list.add(0, min);
         System.out.println(list);
      }

 }     
