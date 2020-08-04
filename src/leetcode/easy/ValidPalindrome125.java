package leetcode.easy;
/** 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man  a plan, a canal: Panama"
 * Output: true
 * */
public class ValidPalindrome125 {
    public static boolean isValidPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while (i<j){
            while (i<j && !Character.isLetterOrDigit(str.charAt(i)))
                i++;
            while (i<j && !Character.isLetterOrDigit(str.charAt(j)))
                j--;
            if(i<j && Character.toLowerCase(str.charAt(i++))!=Character.toLowerCase(str.charAt(j--)))
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println("Input String race a car is palindrome : "+isValidPalindrome("race a car"));
    }
}
