package Contest1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1_9 {
    static class Point {
        private int x = 0;
        private int y = 0;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public void No1_9() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            if (N == 0) {
                System.out.println(-1);
                continue;
            }
            Point[] allpoint = new Point[N];
            for (int i = 0; i < N; i++) {
                int _x = sc.nextInt();
                int _y = sc.nextInt();
                Point _point = new Point(_x, _y);
                allpoint[i] = _point;
            }
            PriorityQueue<Point> result = new PriorityQueue<>((o1, o2) -> {
                if (o1.getX() == o2.getX()) return o1.getY() - o2.getY();
                else return o1.getX() - o2.getX();
            });
            int len = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    int[] judge = new int[N];
                    for (int k = 0; k < N; k++) {
                        int a = allpoint[j].getY() - allpoint[i].getY();
                        int b = allpoint[i].getX() - allpoint[j].getX();
                        int c = allpoint[i].getX() * allpoint[j].getY() - allpoint[i].getY() * allpoint[j].getX();
                        judge[k] = a * (allpoint[k].getX()) + b * (allpoint[k].getY()) - c;
                    }
                    if (judgeArray(judge)) {
                        result.add(allpoint[i]);
                        break;
                    }
                }
            }
            if (result.size() == 0) {
                System.out.println(-1);
                continue;
            }
            boolean if_first = true;
            while (!result.isEmpty()) {
                Point p = result.poll();
                if (if_first) {
                    System.out.print(p.getX() + " " + p.getY());
                    if_first = false;
                } else System.out.print(", " + p.getX() + " " + p.getY());
            }
            System.out.println();
        }
    }

    private boolean judgeArray(int[] array) {
        boolean judge = false;
        int len1 = 0, len2 = 0;
        for (int i : array) {
            if (i >= 0)
                len1++;
        }
        for (int i : array) {
            if (i <= 0)
                len2++;
        }
        if (len1 == array.length || len2 == array.length)
            judge = true;
        return judge;
    }

    public double calculateBearingToPoint(double currentBearing, int currentX, int currentY, int targetX, int targetY) {
        double angle;
        int x = targetX - currentX;
        int y = targetY - currentY;
        angle = Math.atan2(x, y) * 180.0 / Math.PI - currentBearing;
        return angle < 0 ? angle + 360 : angle;
    }

    public PriorityQueue<Point> findPoint(Point[] points) {
        Point minPoint = null;
        double nowBearing;
        double nextBearing;
        double preBearing;
        double nextLength;
        Point nowPoint;
        Point nextPoint = null;
        PriorityQueue<Point> result = new PriorityQueue<>((o1, o2) -> {
            if (o1.getX() == o2.getX()) return o1.getY() - o2.getY();
            else return o1.getX() - o2.getX();
        });
        if (points.length > 0) {
            //元素小于3个时，必是凸包直接返回
            if (points.length <= 3) {
                Collections.addAll(result, points);
                return result;
            }
            //求最左下元素
            for (Point point : points) {
                if (minPoint == null) {
                    minPoint = point;
                    continue;
                }
                if (minPoint.getX() > point.getX())
                    minPoint = point;
                else if (minPoint.getX() == point.getX()) {
                    if (point.getY() < minPoint.getY())
                        minPoint = point;
                }
            }
            result.add(minPoint); //最左下元素定时凸包元素，加入集合
            nowPoint = minPoint;
            preBearing = 0; //之前凸包元素指向最近凸包元素的角度（相对与y轴顺时针）
            while (true) {
                nextBearing = 360;
                nextLength = Double.MAX_VALUE;
                for (Point point : points) {
                    if (point.equals(nowPoint))
                        continue;
                    nowBearing = calculateBearingToPoint(preBearing, nowPoint.getX(), nowPoint.getY(), point.getX(), point.getY());
                    if (nextBearing == nowBearing) {
                        if (nextLength < (Math.pow(point.getX() - nowPoint.getX(), 2) + Math.pow(point.getY() - nowPoint.getY(), 2))) {
                            nextLength = Math.pow(point.getX() - nowPoint.getX(), 2) + Math.pow(point.getY() - nowPoint.getY(), 2);
                            nextPoint = point;
                        }
                    } else if (nextBearing > nowBearing) {
                        nextLength = Math.pow(point.getX() - nowPoint.getX(), 2) + Math.pow(point.getY() - nowPoint.getY(), 2);
                        nextBearing = nowBearing;
                        nextPoint = point;
                    }
                }
                if (minPoint.equals(nextPoint)) {
                    break;
                }
                nowPoint = nextPoint;
                preBearing += nextBearing;
                result.add(nextPoint);
            }
        }
        return result;
    }

    public void No1_9_2() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            if(N==0){
                System.out.println(-1);
                continue;
            }
            Point[] allpoint = new Point[N];
            for (int i = 0; i < N; i++) {
                int _x = sc.nextInt();
                int _y = sc.nextInt();
                Point _point = new Point(_x, _y);
                allpoint[i] = _point;
            }
            PriorityQueue<Point> result = findPoint(allpoint);
            if(result.size()==0){
                System.out.println(-1);
                continue;
            }
            boolean if_first = true;
            while (!result.isEmpty()) {
                Point p = result.poll();
                if (if_first) {
                    System.out.print(p.getX() + " " + p.getY());
                    if_first = false;
                } else System.out.print(", " + p.getX() + " " + p.getY());
            }
            System.out.println();
        }
    }
}
