package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/** 3. Longest Substring Without Repeating Characters

 Given a string, find the length of the longest substring without repeating characters.

 Example 1:
 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 */

public class LongestSubStr3 {
    public static int longestStr(String str){
        Character.toLowerCase(str.charAt(0));
        if(str.length() == 0)
            return 0;
        int i=0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(j<str.length()){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                max = Math.max(set.size(),max);

                j++;
            }
            else{

                set.remove(str.charAt(i));
                i++;
            }
        }

        return max;
    }
    public static void main(String args[]){
       // System.out.println(longestStr("abcabcbb"));
        Float f1 =new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println(x+b+d);

    }
}
