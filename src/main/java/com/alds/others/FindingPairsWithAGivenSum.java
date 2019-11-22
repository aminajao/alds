/**
 * 
 */
package com.alds.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rohsi
 * 
 *         Input : arr[] = {1, 5, 7, -1}, sum = 6 
 *         Output : 2 Pairs with sum 6
 *         are (1, 5) and (7, -1)
 *
 */
public class FindingPairsWithAGivenSum {

	public static void findPairsB(int[] arr, int sum) {
		int i = 0;
		int n = arr.length;
		while (i < n - 1) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println("its a pair : " + "{" + arr[i] + "," + arr[j] + "}");
				}
			}
			i++;
		}
	}
	
	public static int findNumberOfPairsE(int[] arr, int sum) {
		int n = arr.length;
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			if(!data.containsKey(arr[i])) {
				data.put(arr[i], 0);
			} 
			data.put(arr[i], data.get(arr[i])+1);
		}
		
		int twiceCount = 0;
		for(int i=0; i<n; i++) {
			if(data.containsKey(sum-arr[i])) {
				twiceCount += data.get(sum-arr[i]);
				System.out.println("its a pair : " + "{" + arr[i] + "," + (sum-arr[i]) + "}");
			}
			if(sum-arr[i] == arr[i]) {
				twiceCount--;
			}
		}	
		return twiceCount / 2;
	}

	public static void main(String[] args) {
		int[] test ={10, 12, 10, 15, -1, 7, 6, 
                5, 4, 2, 1, 1, 1};
		System.out.println("Pairs : "+findNumberOfPairsE(test, 11));
	}
}
