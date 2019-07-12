package leetcode;

public class Question824 {

    public static void main(String[] args) {
        System.out.println("UXc".matches("[aeiouAEIOU][a-z_A-Z]*"));
    }

    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        String[] split = S.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            switch (split[i].charAt(0)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    sb.append(split[i]).append("ma");
                    break;
                default:
                    sb.append(split[i], 1, split[i].length())
                            .append(split[i], 0, 1).append("ma");
                    break;

            }

            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
