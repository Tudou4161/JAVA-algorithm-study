package chap04;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "(a)())()";
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.solve(s));
    }

    private List<String> solve(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                String str = q.poll();
                if (isValid(str)) {
                    res.add(str);
                    found = true;
                }
                if(found) continue;
                for (int j=0; j<str.length(); j++) {
                    //1
                    if(str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    //2
                    String newStr = str.substring(0,j)+str.substring(j+1);
                    if (!visited.contains(newStr)) {
                        q.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if ( c == ')') {
                cnt--;
                if(cnt < 0) return false;
            }
        }
        return cnt==0;
    }
}
