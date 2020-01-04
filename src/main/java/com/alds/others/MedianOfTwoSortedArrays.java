package com.alds.others;

/**
 * @author rohsi
 *
 */
public class MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int len = nums1.length + nums2.length;

		int[] result = new int[len];

		int i = 0, j = 0, k = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				result[k] = nums1[i];
				i++;
			} else {
				result[k] = nums2[j];
				j++;
			}
			k++;
		}

		while (i < nums1.length) {
			result[k] = nums1[i];
			i++;
			k++;
		}

		while (j < nums2.length) {
			result[k] = nums2[j];
			j++;
			k++;
		}

		double d = 0.0d;

		int r = result.length;

		if (r % 2 == 0) {
			d = (Double.valueOf(result[r / 2]) + Double.valueOf(result[(r / 2) - 1])) / 2;
		} else {
			d = Double.valueOf(result[r / 2]);
		}
		return d;
	}
	
	// Binary search algorithm with O(1) space complexity
	public double findMedianSortedArraysE(int[] nums1, int[] nums2) {
		int a = nums1.length;
		int b = nums2.length;
		
		int min_index = 0;
		int max_index = a<b ? a : b;
		
		//pointers
		int i=0, j=0;
		
		double result = -1;
		
		while(min_index < max_index) {
			
			i = a%2 == 0 ? a/2 - 1 : a/2;
			j = b%2 == 0 ? b/2 - 1 : b/2;
			
			if(nums1[i] < nums2[j+1] && nums2[j] < nums1[i+1]) {
				if((a+b)%2 == 0) {
					result = (double) (nums2[j] + nums1[i+1]) / 2;
					break;
				} else {
					result = Math.max(nums2[j], nums1[i]);
					break;
				}
			} else {
				min_index++;
				i++;
			}
		}
		return result;
	}
	
	
	  
    public static void main(String[] args) {        
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4};
        MedianOfTwoSortedArrays r = new MedianOfTwoSortedArrays();
        System.out.println(r.findMedianSortedArraysE(nums1, nums2));
    }

}
