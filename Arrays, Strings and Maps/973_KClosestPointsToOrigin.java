/***********************************************
Time Complexity : O(n + K)logn
Space Complexity : O(n)
https://leetcode.com/problems/k-closest-points-to-origin/
***********************************************/

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0) {
            return new int[0][0];
        }
        
        if(points.length == 1 && K == 1) {
            return points;
        }
        
        Map<Double, List<Point>> distanceMap = new TreeMap<>();
        int[][] output = new int[K][2];
        
        for(int[] point : points) {
            double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            List<Point> values = distanceMap.get(distance);
            if(values == null) {
                values = new ArrayList<Point>();
            }
            values.add(new Point(point[0], point[1]));
            distanceMap.put(distance, values);
        }
        
        for(Map.Entry<Double, List<Point>> entry : distanceMap.entrySet()) {
            for(Point values : entry.getValue()) {
                if(K <= 0) {
                    break;
                }
                output[K-1][0] = values.x;
                output[K-1][1] = values.y;
                K--;
            }
        }
        return output;
    }
}