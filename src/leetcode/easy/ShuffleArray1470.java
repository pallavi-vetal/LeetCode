package leetcode.easy;

import java.util.Arrays;

/*
* 1470. Shuffle the Array
* Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
* Return the array in the form [x1,y1,x2,y2,...,xn,yn].
* Input: nums = [2,5,1,3,4,7], n = 3
* Output: [2,3,5,4,1,7]
* Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
* */
public class ShuffleArray1470 {

    public static int[] shuffleArraySolution(int nums[]){
        int a=0;
        int b=nums.length/2;
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                res[i]=nums[a];
                a++;
            }
            else
            {
                res[i]=nums[b];
                b++;
            }
        }
        return res;
    }
    public static void main(String args[]){
        int input[] = {2,5,1,3,4,7};
        int res[] = shuffleArraySolution(input);
        System.out.print(Arrays.toString(res));
    }
}
