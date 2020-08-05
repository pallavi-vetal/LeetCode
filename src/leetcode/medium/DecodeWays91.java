package leetcode.medium;
/** 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * */
public class DecodeWays91 {
    public static int decodeWays(String message){
        int dp[] = new int[message.length()+1];
        dp[0] = 1;
        dp[1] = message.charAt(0)=='0'?0:1;
        for(int i=2;i<=message.length();i++){
            int oneDigit = Integer.parseInt(message.substring(i-1,i));
            int twoDigit = Integer.parseInt(message.substring(i-2,i));
            if(oneDigit>=1)
                dp[i] += dp[i-1];
            if(twoDigit>=10 && twoDigit<=26)
                dp[i] += dp[i-2];
        }
        return dp[message.length()];
    }
    public static void main(String args[]){
        System.out.println(decodeWays("223")); //Expected ans : 2
    }
}
