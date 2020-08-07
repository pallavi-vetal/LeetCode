package leetcode.medium;

import java.util.*;

/** 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * **/
public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> result = new ArrayList<>();
       if(strs == null || strs.length == 0)
           return result;

       Map<String,List<String>> map = new HashMap<>();
       for(String str: strs){
           char[] temp = str.toCharArray();
           Arrays.sort(temp);
           String sorted = new String(temp);
           if(!map.containsKey(sorted)){
               map.put(sorted,new ArrayList<>());
           }
           map.get(sorted).add(str);
       }
       result.addAll(map.values());
       return result;
    }
    public static void main(String args[]){
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(arr);
        for(List<String> temp : res){
            System.out.println(Arrays.toString(temp.toArray()));
        }

    }
}
