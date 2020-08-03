package leetcode.medium;

import java.util.*;

/** 17. Letter Combinations of a Phone Number (Tag: Microsoft)
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */
public class LetterCombinationPhone17 {
    public static List<String> letterCombination(String digits){
        List<String> result = new ArrayList<>();
        if(digits ==null || digits.length()==0)
            return result;
        Map<Character,String> mappings = new HashMap<>();
        mappings.put('0',"0");
        mappings.put('1',"1");
        mappings.put('2',"abc");
        mappings.put('3',"def");
        mappings.put('4',"ghi");
        mappings.put('5',"jkl");
        mappings.put('6',"mno");
        mappings.put('7',"pqrs");
        mappings.put('8',"tuv");
        mappings.put('9',"wxyz");
        letterCombination_(result,digits,mappings,"",0);
        return result;
    }
    private static void letterCombination_(List<String> result,String digits,Map<Character,String> mappings,String current,int index){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        String letters = mappings.get(digits.charAt(index));
        for(int i=0; i<letters.length(); i++){
            letterCombination_(result,digits,mappings,current+letters.charAt(i),index+1);
        }
    }
    public static void main(String args[]){
        System.out.println(Arrays.toString(letterCombination("23").toArray()));
    }
}
