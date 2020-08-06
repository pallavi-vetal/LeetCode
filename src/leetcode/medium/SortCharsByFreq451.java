package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/** 451. Sort Characters By Frequency
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * **/
public class SortCharsByFreq451 {
    public static String sortStringUsing2Maps(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        StringBuilder result = new StringBuilder();
        Map<Character,Integer> sortedMap = map.entrySet()
                                                .stream()
                                                .sorted((a,b)->b.getValue()-a.getValue())
                                                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
        for(Map.Entry<Character,Integer> entry : sortedMap.entrySet()){
            char temp = entry.getKey();
            for(int i=0;i<entry.getValue();i++)
                result.append(temp);
        }
        return result.toString();
    }
    public static String sortStringUsingMaxHeap(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()){
            char temp = maxHeap.remove();
            for(int i=0;i<map.get(temp);i++)
                result.append(temp);
        }
        return result.toString();
    }
    public static void main(String args[]){
        System.out.println(sortStringUsing2Maps("erte"));
        System.out.println(sortStringUsingMaxHeap("erte"));
    }
}
