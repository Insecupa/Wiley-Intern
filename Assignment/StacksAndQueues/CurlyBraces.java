package Day13.Assignment.StacksAndQueues;

import java.util.Stack;

public class CurlyBraces {
    public static Boolean checkBalance(String str){
        if(str.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(stack.isEmpty() && (ch == '}' || ch == ']' || ch == ')'))
                return false;
            else if(stack.isEmpty())
                stack.push(ch);
            else{
                char stackCh = stack.peek();
                if(ch == '{' || ch == '[' || ch == '(')
                    stack.push(ch);
                else if((ch == '}' && stackCh == '{') || (ch == ']' && stackCh == '[') || (ch == ')' && stackCh == '(')){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }


        if(stack.isEmpty())
            return true;
        return false;
    }
    public static void main(String[] args) {
        String str = "[(])";
        System.out.println(checkBalance(str));
    }
}
