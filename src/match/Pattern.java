package match;

public class Pattern {
    private final char[] pattern;
    private final int plen;
    private boolean matched = false;

    public static void main(String[] args) {
        final Pattern pattern = new Pattern("1*3".toCharArray(), 3);
        System.out.println(pattern.match("123".toCharArray(), 3));
    }


    Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pi, char[] text, int tlen) {

        if (matched) return;
        if (pi == plen) {
            if (ti == tlen) matched = true;
            return;
        }
        if (pattern[pi] == '*') {
            for (int k = 0; k <= tlen - ti; k++) {
                rmatch(ti + k, pi + 1, text, tlen);
            }

        } else if (pattern[pi] == '?') {
            rmatch(ti, pi + 1, text, tlen);
            rmatch(ti + 1, pi + 1, text, tlen);


        } else if (ti < tlen && pattern[pi] == text[ti]) {
            rmatch(ti + 1, pi + 1, text, tlen);
        }

    }
}
