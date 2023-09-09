package com.litway.aishu;

/**
 * @author Litway_
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeCount = new HashMap<Double, Integer>();
            int duplicatePoints = 0;

            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 == x2 && y1 == y2) {
                    duplicatePoints++;
                    continue;
                }

                double slope = (x1 == x2) ? Double.POSITIVE_INFINITY : (double) (y2 - y1) / (double) (x2 - x1);

                slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
            }

            int currentMax = duplicatePoints + 1;

            for (int count : slopeCount.values()) {
                currentMax = Math.max(currentMax, count + duplicatePoints);
            }

            maxPoints = Math.max(maxPoints, currentMax);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int maxPointsOnLine = maxPoints(points);
        System.out.println(maxPointsOnLine);
    }
}

