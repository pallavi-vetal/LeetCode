package leetcode.medium;
/** 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * */
public class ContainerWithMostWater11 {

    /** Complexity O(n^2) **/
    public static int maxAreaSol1(int heights[]){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<heights.length; i++){
                for(int j= i+1;j<heights.length;j++){
                    int min = Math.min(heights[i],heights[j]);
                    max = Math.max(max,min*(j-i));
                }
            }
            return max;
    }
    /** Complexity O(n) **/
    public static int maxAreaSol2(int heights[]){
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length -1;
        while (i<j){
            int min = Math.min(heights[i],heights[j]);
            max = Math.max(max,min*(j-i));
            if(min==heights[i])
                i++;
            else
                j--;
        }
        return max;
    }
    public static void main(String args[]){
        int input[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaSol1(input)); //Expected 49
        System.out.println(maxAreaSol2(input)); //Expected 49
    }
}
