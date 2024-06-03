package leetcode.string;

import java.util.Stack;

public class SimplifyPath_LC71 {
    public String simplifyPath(final String path) {
        final StringBuilder sb = new StringBuilder();
        final Stack<String> stack = new Stack<>();

        for(int i = 0; i < path.length() + 1; ++i) {
            //Case1: Not get'/' or get the end yet
            if (i < path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                continue;
            }
            //case2: handing multiple //
            if (sb.length() == 0) {
                continue;
            }

            //case3: handing the path in string builder
            final String current = sb.toString();
            if (current.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!current.equals("..") && !current.equals("."))
                stack.push(current);
            sb.setLength(0);

        }

        String result = "";
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        return result.length() == 0 ? "/" : result;
    }
}
