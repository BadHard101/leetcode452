package org.example;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a, b)->a[1]-b[1]);
        int shots = 1;
        int cur = points[0][1];
        for(int i = 0; i < points.length; i++){
            if(!(cur >= points[i][0] && cur <= points[i][1])){
                shots++;
                cur = points[i][1];
            }
        }
        return shots;
    }
}