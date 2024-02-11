package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        Arrays.sort(points, Comparator.comparingInt(value -> value[0]));
        //System.out.println(Arrays.deepToString(points));
        int ans = 0;

        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] interval = points[i];
            if (interval[0] <= cur[1]) {
                cur[0] = Math.max(cur[0], interval[0]);
                cur[1] = Math.min(cur[1], interval[1]);
            } else {
                ans++;
                cur = interval;
            }
        }
        return ++ans;
    }

    public static void main(String[] args) {
        int ans = findMinArrowShots(new int[][] {
                {3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}
        });
        System.out.println(ans);
    }
}