/*
* Copyright (C) 2019 BlackRock.
*
* Created on Nov 22, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.twoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * @author rohsingh
 * 
 *         Given an array of distinct elements. The task is to find triplets in
 *         array whose sum is zero.
 * 
 *         Input : arr[] = {0, -1, 2, -3, 1} 
 *         Output : 0 -1 1 2 -3 1
 *         Input : arr[] = {1, -2, 1, 0, 5} 
 *         Output : 1 -2 1
 *
 */
public class TripletsWithZeroSum {

    public static void findB(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("Triplet : {" + arr[i] + "," + arr[j] + "," + arr[k] + "}");
                    }
                }
            }
        }
    }

    public static void findE(int[] arr) {
        int n = arr.length;  
        for(int i=0; i<n-1; i++) {    
            Map<Integer, Integer> data = new HashMap<>();
            for(int j=i+1; j<n; j++) {
                int x = -(arr[i] + arr[j]);
                if(data.containsKey(x)) {
                    System.out.println("Triplet : {" + x + "," + arr[i] + "," + arr[j] + "}");
                } else {
                    data.put(arr[j], arr[j]);
                }
            }
        } 
    }

    public static void main(String[] args) {
        int[] test = {1, -2, 1, 0, 5};
        findE(test);
    }

}
