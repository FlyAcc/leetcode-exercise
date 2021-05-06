package stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * tags: #HashMap, #Stack
 */
public class ValidParentheses20 {
    private static final Map<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put('(', ')');
        mappings.put('[', ']');
        mappings.put('{', '}');
    }

    public static void main(String[] args) {
        ValidParentheses20 vp = new ValidParentheses20();
        String s = "]";
        System.out.println(vp.isValid(s));
    }

    /*
    使用stack的基本思路是见到左括号push，见到右括号pop，判断pop出来的符号和当前符号是否匹配。
    由于题目要求顺序也需要正确，因此很适合用stack。
    注意一些特殊情况：左括号多于右括号，此时一次循环后栈不为空；右括号多于左括号，此时出栈操作会引发异常。
    该题常用的一些操作是判断两个符号是否匹配，因此我们可以用map实现这些映射关系
     */
    public boolean isValid_Map(String s) {
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // contain即该符号为左括号，压入
            if (mappings.containsKey(c)) {
                parenthesis.push(mappings.get(c));
            } else if (mappings.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }

    /*
    不费事但是太繁琐了
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeftBracket(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char lc = stack.pop();
                if (!isMatched(lc, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

    private boolean isMatched(char left, char right) {
        switch (left) {
            case '(':
                return right == ')';
            case '[':
                return right == ']';
            case '{':
                return right == '}';
            default:
                return false;
        }
    }
}
