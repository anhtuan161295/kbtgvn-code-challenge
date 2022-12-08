package com.task1;

// https://leetcode.com/discuss/interview-question/2890437/Minimum-moves-to-build-a-palindrome
public class Solution {

    public int solutionV2(String S) {
        int[] freq = new int[26];

        for (char c : S.toCharArray()) {
            freq[c - 'a']++;
        }

        int min = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0){
                min++;
            }
        }

        return min;
    }

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
        int result = solution.solutionV2("ervervige");
        System.out.println(result); // 2
        int result2 = solution.solutionV2("aaabab");
        System.out.println(result2); // 0

        int result3 = solution.solutionV2("x");
        System.out.println(result3); // 0
    }


}
