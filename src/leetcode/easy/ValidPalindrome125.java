package leetcode.easy;
/** 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man  a plan, a canal: Panama"
 * Output: true
 * Algo:
 * 1. Initialize 2 pointers i = 0 & j = S.length - 1
 * 2. Repeat steps 3 to 5 while i<j
 * 3. Repeat while i<j & CharAt(i) is not alphanum 
        i++
 * 4. Repeat while i<j & CharAt(j) is not alphanum
        j--
 * 5. if i<j & charAt(i) != charAt(j) then return false
 * 6. Return True
 * 7. End
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
