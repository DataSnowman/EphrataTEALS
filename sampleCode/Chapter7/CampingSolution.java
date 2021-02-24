package sampleCode.Chapter7;

import java.util.Arrays;

public class CampingSolution {
    public static void main(String[] args) {
    
      // dogNames array here
      String[] dogNames = new String[3];
      dogNames[0] = "Baby";
      dogNames[1] = "Harlow";
      dogNames[2] = "Hudson";
      
      // babyGrowls array here and call countBabyGrowls Method
      int[] babyGrowls = new int[43];
      int growlCount = countBabyGrowls(babyGrowls);
       
      // harlowNaps array here and call increaseNap Method as well as minHarlowNaps and maxHarlowNaps Methods
      double[] harlowNaps = {1.5, .75, 2.25, .5, 3, .25};
      increaseNap(.25, harlowNaps);
      double napMin = minHarlowNaps(harlowNaps);
      double napMax = maxHarlowNaps(harlowNaps);
      
      // holdHudson array here and call sumHudsonHold Method
      int[] holdHudson = new int[]{2,3,1};
      int sumHold = sumHudsonHold(holdHudson);
      
      // Keep to test arrays here
      System.out.println(Arrays.toString(dogNames));
      System.out.println(Arrays.toString(babyGrowls));
      System.out.println(Arrays.toString(harlowNaps)); 
      System.out.println(Arrays.toString(holdHudson));

      // Println statements here
      /* Should output
      Baby growled 43 times!
      Harlow napped Minimum: 0.5 Maximum: 3.25
      Hudson was held 6 times!
      */

      System.out.println(dogNames[0] + " growled " + growlCount + " times!");
      System.out.println(dogNames[1] + " napped Minimum: " + napMin + " Maximum: " + napMax);
      System.out.println(dogNames[2] + " was held " + sumHold + " times!");
      
    } //end of main method
    
    // countBabyGrowls static method here
    public static int countBabyGrowls(int[] arrayCount){
      
      // for loop to intialize array
      for (int i = 0; i < arrayCount.length; i++) {
            arrayCount[i] = 1;
      }
      
      int count = 0;
      
      //for each loop
      for(int num: arrayCount){    
         count = count + arrayCount[num];
      }
         return count;
    }
    
    // increaseNap static method here
    public static void increaseNap(double addHours, double[] arrayNap) {
    
      // for loop to increase hours in array  
      for (int i = 0; i < arrayNap.length; i++) {
         arrayNap[i] = arrayNap[i] + addHours;
      }  
    }
    
    // minHarlowNaps static method here     
    public static double minHarlowNaps(double[] arrayNap) {
    
      double minSoFar = arrayNap[0];
      
      // for each loop
      for (double num: arrayNap) {
         if(num < minSoFar)
         {
            minSoFar = num;
         }
      }
      return minSoFar;
    }
    
    // maxHarlowNaps static method here    
    public static double maxHarlowNaps(double[] arrayNap) {
      
      double maxSoFar = arrayNap[0];
      
      // for each loop
      for (double num: arrayNap) {
         if(num > maxSoFar)
         {
            maxSoFar = num;
         }
      }
      return maxSoFar;
    }
    
    // sumHudsonHold static method here  
    public static int sumHudsonHold(int[] arraySum) {
    
      int sumHold = 0;
      
      // for loop to calculate sum here
      for (int i = 0; i < arraySum.length; i++) {
         sumHold = sumHold + arraySum[i];
      }  
         return sumHold;
    }
}