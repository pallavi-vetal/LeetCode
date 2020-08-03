package leetcode.easy;

import java.util.Arrays;

public class ReverseString344 {
    public static char[] reverse(char str[]){
        int ptr1 = 0;
        int ptr2 = str.length-1;
        while(ptr1<ptr2){
            char temp = str[ptr1];
            str[ptr1] = str[ptr2];
            str[ptr2] = temp;
            ptr1++;
            ptr2--;
        }
        return str;
    }
    public static void main(String args[]){
        System.out.println("Reverse of a b c d : "+ Arrays.toString(reverse("abcd".toCharArray())));
    }
}
