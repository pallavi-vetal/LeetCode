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
 * ] */
public class GroupAnagrams91 {
    public static List<List<String>> groupAnagrams(String strs[]){
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            if(!map.containsKey(sortedStr))
                map.put(sortedStr,new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        result.addAll(map.values());
        return result;
    }
    public static void main(String args[]){
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> out = groupAnagrams(arr);

        for(List<String> strs:out){
            System.out.println(Arrays.toString(strs.toArray()));
        }
    }
}
