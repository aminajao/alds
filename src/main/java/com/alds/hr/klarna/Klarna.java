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

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author rohsingh
 * 
 * 
1. You're given a number and you should write the multiples of 3 and 5 up to that number. Using a set is straightforward.

2. You're given a String consisting of positive integers delimited by whitespace. You must get these integers and weight sort them. 
	Sort first according to the sum of digits in each integer, if the sums are equal, the smaller one comes first. Use Java8 Comparator.comparing

3. Typical BraceChecker question. See if left parentheses match right parentheses. Use stack!  
 *
 */
public class Klarna {
      
	public static void mutipleOf3And5(int n) {
		Set<Integer> out = IntStream.range(3, n).filter(i -> (i % 3 == 0) || (i % 5 == 0)).boxed()
				.collect(Collectors.toSet());
		System.out.println(out);
	}
    
	public static void weightSorting(String in) {
		List<Integer> out = Stream.of(in.split(" ")).map(Integer::valueOf).sorted((i1, i2) -> i1.compareTo(i2))
				.collect(Collectors.toList());
		System.out.println(out);
	}
    
	public static boolean braceChecker(String in) {
		Stack<Character> s = new Stack<Character>();
		// Iterating over the entire string.
		for (char st : in.toCharArray()) {
			// If the input string contains an opening parenthesis,
			// push in on to the stack.
			if (st == '(' || st == '{' || st == '[') {
				s.push(st);
			} else {
				// In the case of valid parentheses, the stack cannot be
				// be empty if a closing parenthesis is encountered.
				if (s.empty()) {
					return false;
				}
				// If the input string contains a closing bracket,
				// then pop the corresponding opening parenthesis if present.
				char top = (Character) s.peek();
				if (st == ')' && top == '(' || st == '}' && top == '{' || st == ']' && top == '[') {
					s.pop();
				}
			}
		}
		if(!s.empty()) {
			return false;
		} 
		return true;
	}
    
    public static void main(String[] args) {
        
    }
}
