package Arrays;

/*
 * Set Matrix Zero
 * Problem Statement: Given a matrix if an element in the matrix is 0 then you
 * will have to set its entire column and row to 0 and then return the matrix.
 */

import java.util.*;
class TUF{
static void setZeroes(int [][] matrix) {

//  int rows = matrix.length, cols = matrix[0].length;
//
//  int[] dummy1 =new int[rows];
//  int[] dummy2 =new int[cols];
//
//  Arrays.fill(dummy1,-1);
//  Arrays.fill(dummy2,-1);
//
//  for (int i = 0; i < rows; i++) {
//    for (int j = 0; j < cols; j++) {
//      if (matrix[i][j] == 0) {
//        dummy1[i] = 0;
//        dummy2[j] = 0;
//      }
//    }
//
//  }
//
//  for (int i = 0; i < rows; i++) {
//    for (int j = 0; j < cols; j++) {
//      if (dummy1[i] == 0 || dummy2[j]==0) {
//        matrix[i][j] = 0;
//      }
//    }
//  }


    // optimized approach TC - O(2*(M*N)) and SC - O(1)
    boolean col0 = true;
    int rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) col0 = false;
        for (int j = 1; j < cols; j++)
            if (matrix[i][j] == 0)
                matrix[i][0] = matrix[0][j] = 0;
    }

    for (int i = rows - 1; i >= 0; i--) {
        for (int j = cols - 1; j >= 1; j--)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        if (col0 == false) matrix[i][0] = 0;
    }
}

public static void main(String[] args) {
        int[][] arr = {{0, 1, 2,}, {3, 4, 5}, {1, 3, 1},{0,2,3}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");

    for (int[] ints : arr) {
        for (int j = 0; j < arr[0].length; j++) {
            System.out.print(ints[j] + " ");
        }
        System.out.println();
    }
}
}