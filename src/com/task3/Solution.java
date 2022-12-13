package com.task3;

// https://leetcode.com/discuss/interview-question/2890453/Number-of-non-empty-rectangular-areas
public class Solution {

    public int solution(int[][] A) {
        // write your code in Java SE 8
        int result = matches(A);
        return result;
    }

    // get sum of the area by selecting row and column
    // start array will have first element as start row, second element as end row
    // end array will have first element as start column, second element as end column
    public int calculateAreaSum(int[][] arr, int[] start, int[] end) {
        int sum = 0;
        for (int row = start[0]; row <= end[0]; row++)
            for (int col = start[1]; col <= end[1]; col++)
                sum += arr[row][col];
        return sum;
    }

    //
    public int matches(int[][] arr) {
        int maxRow = arr.length - 1;
        int maxCol = arr[maxRow].length - 1;
        int total = calculateAreaSum(arr, new int[]{0, 0}, new int[]{maxRow, maxCol});

        // Impossible to have same inside and outside count
        if (total % 2 != 0)
            return 0;

        int target = total / 2;
        int matches = 0;

        for (int rowEnd = 0; rowEnd < arr.length; rowEnd++) {

            for (int colEnd = 0; colEnd < arr[rowEnd].length; colEnd++) {

                for (int rowStart = 0; rowStart < arr.length; rowStart++) {

                    for (int colStart = 0; colStart < arr[rowEnd].length; colStart++) {
                        if (calculateAreaSum(arr, new int[]{rowStart, colStart}, new int[]{rowEnd, colEnd}) == target)
                            matches++;
                    }
                }
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{
                {1, 1, -2},
                {3, 2, 4},
                {-1, -2, -2}
        });
        System.out.println(result); // 7

        int result2 = solution.solution(new int[][]{
                {1, 1, 2},
                {2, 0, 0},
        });
        System.out.println(result2); // 3

        int result3 = solution.solution(new int[][]{
                {5, -1},
                {-3, 2},
                {0, 4}
        });
        System.out.println(result3); // 0
    }
}
