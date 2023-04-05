package computingModels;

import java.util.Stack;
import java.lang.StringBuilder;

public class Converter {

    public static String converteToPostfix(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> op = new Stack<Character>();
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                while (Character.isDigit(chars[i])) {
                    sb.append(chars[i]);
                    if (i < chars.length - 1) {
                        i++;
                    } else {
                        break;
                    }
                }
                sb.append(' ');
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    sb.append(op.pop()).append(' ');
                }
                op.pop();
            } else if (isOperator(ch)) {
                while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                    sb.append(op.pop()).append(' ');
                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()) {
            sb.append(op.pop()).append(' ');
        }
        return sb.toString();
    }

    private static boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    private static int priority(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 0;
    }

}
