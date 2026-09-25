import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length());
        
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        
        return answer;
    }

    private Set<String> parse(String s, int start, int end) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = start;

        while (i < end) {

            char ch = s.charAt(i);

            // Union: {a,b,c}
            if (ch == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') {
                        count++;
                    } else if (s.charAt(j) == '}') {
                        count--;
                    }
                    j++;
                }

                // Parse inside braces
                Set<String> inside = parse(s, i + 1, j - 1);

                // Concatenate with current result
                current = concatenate(current, inside);

                i = j;
            }

            // Comma means UNION
            else if (ch == ',') {
                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;
            }

            // Normal lowercase letter
            else {
                Set<String> letter = new HashSet<>();
                letter.add(String.valueOf(ch));

                current = concatenate(current, letter);

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> concatenate(Set<String> first, Set<String> second) {
        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}