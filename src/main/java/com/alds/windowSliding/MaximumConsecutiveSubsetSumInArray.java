/*
* Copyright (C) 2019 BlackRock.
*
* Created on Nov 21, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.windowSliding;

/**
 * @author rohsingh
 * 
 *  Given an array of integers of size ‘n’.
    Our aim is to calculate the maximum sum of ‘k’ 
    consecutive elements in the array.
    
    
    Input  : arr[] = {100, 200, 300, 400}
         k = 2
    Output : 700

    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
    Output : 39
    We get maximum sum by adding subarray {4, 2, 10, 23}
    of size 4.

    Input  : arr[] = {2, 3}
         k = 3
    Output : Invalid
 *
 */
public class MaximumConsecutiveSubsetSumInArray {
    
    public void calculate(int[] input, int k) {
        
       if(input.length == 0 || k > input.length) {
           return;
       }

       for(int i=0; i<input.length; i++) {
           
       }
    }

}
