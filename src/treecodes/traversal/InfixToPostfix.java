package treecodes.traversal;
import java.util.*;
/*
* POSIX(STRING EXP)
* 1. Repeat steps 2 to for 5 char in EXP.
* 2. if char == operand then add it result
* 3. else if char == ( then push ( to stack
* 4. else if char == ) then
*           - pop all elements of stack and add it to result until ( is encountered or stack is empty
*           - remove ( from stack - st.pop
* 5. else if char == operator then
*      - pop from stack and add to result until precedence of top of stack >= char and stack is not empty
*      - push char on stack
* 6. if stack is not empty then pop from stack and add to result
* 7. end
* */

public class InfixToPostfix {
    public static int checkPrecedence(char ch){
        switch(ch){
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '^' :
                return 3;
            default:
                return -1;
        }
    }
    public static String POSIX(String exp){
        String result = "";
        Stack <Character>st = new Stack();
        for(int i=0; i<exp.length(); i++){
            char temp = exp.charAt(i);
            if(Character.isLetterOrDigit(temp))
                result += temp;

            else if(temp == '(')
                st.push(temp);

            else if(temp == ')'){
                while (!st.isEmpty() && st.peek()!='(')
                    result += st.pop();
                if (!st.isEmpty() && st.peek()!='(')
                    return "Invalid exp";
                else
                    st.pop();
            }
            else{
                while(!st.isEmpty() && checkPrecedence(temp) <= checkPrecedence(st.peek())){
                    if(st.peek()=='(')
                        return "Invalid exp";
                    result += st.pop();
                }
                st.push(temp);
            }
        }
        while(!st.isEmpty())
        {
            if(st.peek()=='(')
                return "Invalid exp";
            result += st.pop();
        }
        return result;
    }
    public static void main(String args[]){
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(POSIX(exp));
    }
}
