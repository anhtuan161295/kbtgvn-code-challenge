package com.task1;

// https://leetcode.com/discuss/interview-question/2890437/Minimum-moves-to-build-a-palindrome
public class Solution {

    // https://www.techiedelight.com/find-minimum-number-deletions-convert-string-into-palindrome/
    public int solution(String S) {
        int n = S.length();
        int min = minDeletions(S, 0, n - 1);
        if (min - 2 >= 0) min -= 2;
        return min;
    }

    // Function to find out the minimum number of deletions required to
    // convert a given string `X[i…j]` into a palindrome
    public static int minDeletions(String X, int i, int j) {
        // base condition
        if (i >= j) {
            return 0;
        }

        // if the last character of the string is the same as the first character
        if (X.charAt(i) == X.charAt(j)) {
            return minDeletions(X, i + 1, j - 1);
        }

        // otherwise, if the last character of the string is different from the
        // first character

        // 1. Remove the last character and recur for the remaining substring
        // 2. Remove the first character and recur for the remaining substring

        // return 1 (for remove operation) + minimum of the two values

        return 1 + Math.min(minDeletions(X, i, j - 1), minDeletions(X, i + 1, j));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("ervervige");
        System.out.println(result); // 2
        result = solution.solution("aaabab");
        System.out.println(result); // 0

        result = solution.solution("x");
        System.out.println(result); // 0
    }


}
