/*
* Copyright (C) 2020 BlackRock.
*
* Created on Feb 22, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.hr.klarna;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rohsingh
 * 
 * 
1. You're given a number and you should write the multiples of 3 and 5 up to that number. Using a set is straightforward.

2. You're given a String consisting of positive integers delimited by whitespace. You must get these integers and weight sort them. Sort first according to the sum of digits in each integer, if the sums are equal, the smaller one comes first. Use Java8 Comparator. comparing

3. Typical BraceChecker question. See if left parentheses match right parentheses. Use stack!  
 *
 */
public class Klarna {
      
    public static void mutipleOf3And5(int n) {
        Set<Integer> out = 
           IntStream.range(3, n)
            .filter(i -> (i%3==0) || (i%5==0))
            .boxed()
            .collect(Collectors.toSet());
        
        System.out.println(out);
    }
    
    public static void weightSorting(String in) {
        
    }
    
    public static void braceChecker(String in) {
        
    }
    
    public static void main(String[] args) {
        
    }
}
