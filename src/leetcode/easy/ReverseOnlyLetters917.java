package leetcode.easy;
/** 917. Reverse Only Letters
 Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 and all letters reverse their positions.

 Example 1:
 Input: "ab-cd"
 Output: "dc-ba"

 Example 2:
 Input: "a-bC-dEf-ghIj"
 Output: "j-Ih-gfE-dCba"

 Example 3:
 Input: "Test1ng-Leet=code-Q!"
 Output: "Qedo1ct-eeLg=ntse-T!"

 **/
public class ReverseOnlyLetters917 {
    public static String reverse(String str){
        int i = 0;
        int j = str.length() - 1;
        StringBuilder res = new StringBuilder(str);
        while (i<j){
            if(Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j))){
                res.setCharAt(i,str.charAt(j));
                res.setCharAt(j,str.charAt(i));
                i++;
                j--;
            }
            else if(!Character.isLetter(str.charAt(i)))
                i++;
            else
                j--;
        }
        return res.toString();
    }
    public static void main(String args[]){
        System.out.println(reverse("a-bC-dEf-ghIj"));
    }
}
