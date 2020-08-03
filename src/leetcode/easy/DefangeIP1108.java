package leetcode.easy;
/* 1108. Defanging an IP Address
* Given a valid (IPv4) IP address, return a defanged version of that IP address.
* A defanged IP address replaces every period "." with "[.]".
* Input: address = "1.1.1.1"
* Output: "1[.]1[.]1[.]1"
*/
public class DefangeIP1108 {
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public static void main(String args[]){
        System.out.print(defangIPaddr("1.1.1.1"));
    }
}
