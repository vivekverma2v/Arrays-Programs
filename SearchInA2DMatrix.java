package com.learning.array;

/*
 *  Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. 
 *  Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. 
 *  The designed algorithm should have linear time complexity. 
 *  
 *  Example: 
 *  	Input: mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
		Output: Found at (2, 1)
		Explanation: Element at (2,1) is 29
		
		
		Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
		Output : Element not found
		Explanation: Element 100 is not found
 * 
 */

public class SearchInA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length;
        int hi = n - 1;
        
        while(lo < n && hi > 0) {
        	if (matrix[lo][hi] == target) 
        		return true;
        	else if (matrix[lo][hi] > target)
        		hi--;
        	else
        		++lo;            
        }
        return false;
    }

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

		System.out.println(new SearchInA2DMatrix().searchMatrix(mat,  31));

	}

}
