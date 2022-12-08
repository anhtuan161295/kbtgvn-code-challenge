package com.task3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[][] A) {
        // write your code in Java SE 8
        int maxSum = Integer.MIN_VALUE;
        int maxRow = A.length;
        int maxCol = A[0].length;

        for (int leftCol = 0; leftCol < maxCol; leftCol++) {

            for (int rightCol = leftCol; rightCol < maxCol; rightCol++) {
                int sum = 0;
                for (int row = 0; row < maxRow; row++) {
                    sum += A[row][rightCol];

                    int tempSum = numSubmatrixSumTarget(A, sum);
                    maxSum = Math.max(tempSum, maxSum);
                }
            }
        }
        return maxSum - maxRow + maxCol;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrixCol_sum = new int[m][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                matrixCol_sum[i][j] = matrix[i][j];
                if (i > 0) {
                    matrixCol_sum[i][j] += matrixCol_sum[i - 1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int[] array = new int[n];
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    array[k] = matrixCol_sum[j][k] - (i > 0 ? matrixCol_sum[i - 1][k] : 0);
                    sum += array[k];
                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{5, -1}, {-3, 2}, {0, 4}});
        System.out.println(result); // 0
    }
}
