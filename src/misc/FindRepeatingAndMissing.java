package misc;
import java.util.Vector;

public class FindRepeatingAndMissing {
    public static Vector<Integer> findNumbers(int nums[]){
        int n = nums.length;
        int sum_n = n*(n+1)/2;
        int sum_sq = n*(n+1)*(2*n+1)/6;
        for(int i:nums){
            sum_n-=i;
            sum_sq-=i*i;
        }
        int repeating = (sum_n+sum_sq/sum_n)/2;
        int missing = repeating-sum_n;
        Vector<Integer> res = new Vector<>();
        res.add(repeating);
        res.add(missing);
        return res;
    }
    public static void main(String args[]){
        int input[]={1,2,3,4,3};
        Vector<Integer> res = findNumbers(input);
        System.out.println("Missing: "+res.get(0));
        System.out.println("Repeating: "+res.get(1));

    }
}
