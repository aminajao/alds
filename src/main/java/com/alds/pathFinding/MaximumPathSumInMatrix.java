package com.alds.pathFinding;

/**
 * @author rohsingh
 * 
 * Given a matrix of N * M. Find the maximum path sum in matrix. 
 * The maximum path is sum of all elements from first row to last 
 * row where you are allowed to move only down or diagonally to left 
 * or right. You can start from any element in first row.
 * 
 * 
 * 	Input : mat[][] = 	1 2 3
                  		9 8 7
                  		4 5 6
	Output : 17
	The maximum sum path is 3-8-6.
 *
 */
public class MaximumPathSumInMatrix {
	
	public static int R =3, C =3;
	
	public static int findMaximumPathSum(int[][] M) {
		int res = 0;
		
		for(int i=0; i<R; i++) {
			res = Math.max(res, M[i][0]);
		}
		
		for(int i=1; i<R; i++) {		
			for(int j=0; j<C; j++) {
				
				// extreme left, no diagonal left
				if(j < C-1) {
					res += Math.max(M[i][j], M[i+1][j]);
				}
				
				// middle
				if(j > 0 && j < C-1) {
					res += Math.max(M[i-1][i], Math.max(M[i][j], M[i+1][j]));
				}
				
				// extreme right, no diagonal right
				if(j > 0) {
					res += Math.max(M[i-1][j], M[i+1][j]);
				}
			}
		}
		return res;
	}

	
	public static void main(String[] args) {
		 int mat[][] = { 
				 	{1, 2, 3},
				 	{9, 8, 7},
				 	{4, 5, 6} 
             }; 

		 System.out.println(findMaximumPathSum(mat)); 
	}
}
