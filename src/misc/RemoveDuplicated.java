/** Microsoft*/
package misc;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class RemoveDuplicated {
    public static String removeDupsSol1(String str){
        Set<Character> set = new HashSet<>();
        for(char ch:str.toCharArray()){
            set.add(ch);
        }
        AtomicReference<String> res= new AtomicReference<>("");
        set.forEach((s)-> res.updateAndGet(v -> v + s));
        return res.get();
    }
    public static String removeDupsSol2(String str){
        String res= new String();
        for(char ch: str.toCharArray()){
            if(res.indexOf(ch)==-1)
                res+=ch;
        }
        return res;
    }
    public static void main(String args[]){
        String str = "aabbc";
        System.out.print("After removing dups: \n"+removeDupsSol1(str));
        System.out.print("\nAfter removing dups: \n"+removeDupsSol2(str));
    }
}
