package com.task2;

// https://leetcode.com/discuss/interview-question/2890446/Prepare-a-notification-message-(cropping-words-with-three-dots)
public class Solution {

    public String solutionV2(String message, int K) {
        if (K > message.length()) return message;

        char[] chars = message.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < K; i++) {
            stringBuilder.append(chars[i]);
        }

        String temp = stringBuilder.toString().trim();
        if (temp.lastIndexOf(" ") == -1) {
            temp = "";
        } else {
            while (temp.length() + 4 > K) {
                temp = temp.substring(0, temp.lastIndexOf(" "));
            }
        }

        String result = temp + " ...";
        result = result.trim();
        return result;
    }

    public String solution(String message, int K) {
        if (K > message.length()) return message;

        //trim the string to the maximum length
        String trimmedString = message.substring(0, K);

        if (trimmedString.lastIndexOf(" ") == -1) {
            trimmedString = "";
        } else {
            trimmedString = trimmedString.substring(0, Math.min(trimmedString.length(), trimmedString.lastIndexOf(" ")));
        }
        String trimmedString2 = trimmedString + " ...";

        if (trimmedString2.length() > K) {
            trimmedString = trimmedString.substring(0, trimmedString.lastIndexOf(" "));
            trimmedString2 = trimmedString + " ...";
        }

        trimmedString2 = trimmedString2.trim();
        return trimmedString2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solutionV2("And now here is my secret", 15);
        System.out.println(result); // And now ...
        String result2 = solution.solutionV2("There is an animal with four legs", 15);
        System.out.println(result2); // There is an ...
        String result3 = solution.solutionV2("super dog", 4);
        System.out.println(result3); // ...
        String result4 = solution.solutionV2("how are you", 20);
        System.out.println(result4); // how are you
    }
}
