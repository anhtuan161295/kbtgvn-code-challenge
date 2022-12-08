package com.task2;

// https://leetcode.com/discuss/interview-question/2890446/Prepare-a-notification-message-(cropping-words-with-three-dots)
public class Solution {

    public String solution(String message, int K) {
        if (K > message.length()) return message;

        //trim the string to the maximum length
        String trimmedString = message.substring(0, K);

        if (trimmedString.lastIndexOf(" ") == -1){
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
        String result = solution.solution("And now here is my secret", 15);
        System.out.println(result); // And now ...
        String result2 = solution.solution("There is an animal with four legs", 15);
        System.out.println(result2); // There is an ...
        String result3 = solution.solution("super dog", 4);
        System.out.println(result3); // ...
        String result4 = solution.solution("how are you", 20);
        System.out.println(result4); // how are you
    }
}
