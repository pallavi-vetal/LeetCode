package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 1239. Maximum Length of a Concatenated String with Unique Characters
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * Return the maximum possible length of s.
 * Example 1:
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * */
public class FindMaxLenghthOfUniqChar1239 {
    public static int findMaxLength(List<String> arr){
        int []result = new int[1];
        maxLength_(arr,0,"",result);
        return result[0];
    }

    private static void maxLength_(List<String> arr, int index, String current, int[] result) {
        if(index == arr.size() && getUniq(current)>=result[0]){
            result[0] = current.length();
            return;
        }
        if(index == arr.size())
            return;
        maxLength_(arr,index+1,current,result);
        maxLength_(arr,index+1,current+arr.get(index),result);
    }

    private static int getUniq(String current) {
        int count[] = new int[26];
        for(char ch:current.toCharArray()){
            if(count[ch-'a']++ >0)
                return -1;
        }
        return current.length();
    }


    public static void main(String args[]){
        List<String> list = new LinkedList<>();
        String input[] = {"un","iq","ue"};
        list.addAll(Arrays.asList(input));
        System.out.println(findMaxLength(list));

    }
}
