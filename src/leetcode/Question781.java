package leetcode;

/**
 * 781. 森林中的兔子
 */
public class Question781 {

    public static void main(String[] args) {
        int[] answers1 = {1, 1, 2};//5
        int[] answers2 = {1, 0, 1, 0, 0};//5
        int[] answers3 = {10, 10, 10};//11
        int[] answers4 = null;//0
        int[] answers5 = {0, 0, 1, 1, 1};//6
        System.out.println(numRabbits(answers1));
        System.out.println(numRabbits(answers2));
        System.out.println(numRabbits(answers3));
        System.out.println(numRabbits(answers4));
        System.out.println(numRabbits(answers5));


    }

    public static int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        int max = answers[0];
        int min = answers[0];
        for (int i = 1; i < answers.length; i++) {
            if (max < answers[i]) {
                max = answers[i];
            }
            if (min > answers[i]) {
                min = answers[i];
            }
        }
        int[] counter = new int[max + 1];
        for (int i = 0; i < answers.length; i++) {
            counter[answers[i]]++;
        }

        int result = 0;
        if (min == 0) {
            result += counter[0];
            min++;
        }
        for (int i = min; i < counter.length; i++) {
            result += counter[i] == 0 ? 0 : counter[i] <= i + 1 ? i + 1 : Math.ceil(counter[i] * 1.f / (i + 1)) * (i + 1);
        }

        return result;

    }

}
