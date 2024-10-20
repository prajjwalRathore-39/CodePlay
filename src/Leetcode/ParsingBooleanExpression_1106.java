package Leetcode;
// https://leetcode.com/problems/parsing-a-boolean-expression/?envType=daily-question&envId=2024-10-20
import java.util.Scanner;
import java.util.Stack;

public class ParsingBooleanExpression_1106 {
    char lastOperator = 'k';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the boolean Expression.");
        String expression = sc.nextLine();
        System.out.println("The expression evaluates to be : " + new ParsingBooleanExpression_1106().parseBoolExpr(expression));
    }

    public boolean parseBoolExpr(String expression) {
        boolean result = true;
        Stack<Character> stk = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stk.push(ch);
            } else if (ch == ')') {
                result = stk.peek() == 't';
                while (stk.peek() != '('){
                    if (stk.peek() == 't'){
                        if (operator.peek() == '&'){
                            result = result & true;
                        }else if (operator.peek() == '|'){
                            result = result | true;
                        }else{
                            result = !result;
                        }
                    }else{
                        if (operator.peek() == '&'){
                            result = result & false;
                        }else if (operator.peek() == '|'){
                            result = result | false;
                        }else{
                            result = !result;
                        }
                    }
                    stk.pop();
                }
                stk.pop();
                stk.pop();
                operator.pop();
                if (result){
                    stk.push('t');
                }else{
                    stk.push('f');
                }
            } else if (ch == ',') {
                continue;
            }else if (ch == 't'){
                stk.push('t');
            } else if (ch == 'f') {
                stk.push('f');
            } else {
                operator.push(ch);
                stk.push(ch);
            }
        }
        return result;
    }
}