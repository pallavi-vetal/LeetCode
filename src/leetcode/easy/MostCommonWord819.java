package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedStrings = new HashSet<>();
        for(String ban:banned)
            bannedStrings.add(ban.toLowerCase());
        paragraph = paragraph.replaceAll("\\p{Punct}"," ");
        paragraph = paragraph.toLowerCase();
        String words[] = paragraph.split(" ");
        int max=Integer.MIN_VALUE;
        String mostCommonWord = "";
        Map <String,Integer> allowedWords= new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!bannedStrings.contains(words[i]) && !words[i].isEmpty()){
                allowedWords.put(words[i],allowedWords.getOrDefault(words[i],0)+1);
                if(allowedWords.get(words[i])>max){
                    max = allowedWords.get(words[i]);
                    mostCommonWord = words[i];
                }
            }
        }

        return mostCommonWord;

    }
    public static void main(String args[]){
        String para="Bob. hIt, baLl";
        String banned[] = {"bob", "hit"};
        System.out.println(mostCommonWord(para,banned));
    }
}
