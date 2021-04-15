package sampleCode.Chapter10;

import java.util.ArrayList;

public class todoList {
    public static void main(String[] args) {
    
      //Initialize the ArrayList
      ArrayList <String> toDos = new ArrayList<String>();
      System.out.println(toDos);
      
      //Add todos to the list
      
      toDos.add ("Get Groceries");
      toDos.add ("Finish Lesson Plan");
      toDos.add ("Do Yoga");
      toDos.add ("Cut the Lawn");
      toDos.add ("Pay Visa");
      
      System.out.println(toDos);
      
      System.out.println("Size of the ArrayList: " + toDos.size());
      
      System.out.println("Item in the Zero Index: " + toDos.get(0));
      
      toDos.set(0,"Get More Groceries");
      
      System.out.println(toDos.get(0));
      
      toDos.remove(4);
      System.out.println(toDos);
      
      toDos.clear();
      System.out.println(toDos);
    }
}