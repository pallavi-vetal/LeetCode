package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCandies1431 {
    public static List<Boolean> countKids(int[] candies,int extraCandies){
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();

        for(int i=0;i<candies.length;i++){
            if((candies[i]+extraCandies)>=(max))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public static void main(String args[]){
        int input[]= {2,3,5,1,3};
        int extra = 3;
        System.out.println(countKids(input,extra));;
    }
}
