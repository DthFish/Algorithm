package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1024. 视频拼接
 */
public class Question1024 {

    public static void main(String[] args) {
        int[][] arr = {{0, 4}, {2, 8}};
        System.out.println(videoStitching(arr, 5));
        System.out.println(videoStitching2(arr, 5));

        int[][] arr2 = {{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}};
        System.out.println(videoStitching(arr2, 5));
        System.out.println(videoStitching2(arr2, 5));
    }

    // 很傻的动态规划，哎，效率不高
    public static int videoStitching(int[][] clips, int T) {

        int[] status = new int[T + 1];
        for (int i = 0; i < T + 1; i++) {
            status[i] = -1;
        }
        status[0] = 0;

        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < clips.length; i++) {

            int[] clip = clips[i];

            if (T >= clip[0]) {

                int end = Math.min(T, clip[1]);

                if (clip[0] == 0) {
                    for (int j = end; j >= clip[0]; j--) {
                        status[j] = 1;
                    }
                } else if (status[clip[0]] > 0) {
                    if (status[end] > 0) {
                        status[end] = Math.min(status[end], status[clip[0]] + 1);
                    } else if (end == 0) {
                        status[end] = 1;
                    } else {
                        status[end] = status[clip[0]] + 1;
                    }

                    for (int j = end - 1; j > clip[0]; j--) {
                        if (status[j] > 0) {
                            status[j] = Math.min(status[j], status[end]);
                        } else {
                            status[j] = status[end];
                        }
                    }
                }


            }
        }

        return status[T];
    }

    public static int videoStitching2(int[][] clips, int T) {
        int count = 0;
        int max = 0;
        while (max < T) {
            int slice = 0;

            for (int[] clip : clips) {
                if (clip[0] <= max && clip[1] >= max) {
                    slice = Math.max(clip[1], slice);
                }
            }
            if (slice <= max) {
                return -1;
            }
            max = slice;
            count++;
        }
        return count;

    }


}
