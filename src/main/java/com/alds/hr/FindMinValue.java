package com.alds.hr;

import java.util.Arrays;

public class FindMinValue {
    
    static int findMinValue(int arr[]) { 
        // sort the array to apply Binary search  
        Arrays.sort(arr); 
        
        int n = arr.length;
  
        // using log property add every logarithmic  
        // value of element to val  
        int val = 0; // where double is long double  
        for (int i = 0; i < n; i++) { 
            if(val == 0) {
                val = (-arr[i]) + 1;
            } else {
                val += (-arr[i]);
            }
            
            if(val < 1) {
               return 0;
            }
        } 
  
        // set left and right extremities to find  
        // min value  
       return val;
    } 
    
    public static void main(String[] args) {
        
        int [] test = {-2, 3, 1, -5};
        
        System.out.println(findMinValue(test));
    }

}
