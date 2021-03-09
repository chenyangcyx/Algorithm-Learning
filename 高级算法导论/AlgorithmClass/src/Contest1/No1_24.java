package Contest1;

import java.util.*;

public class No1_24 {
    class Point {
        double x, y;

        public Point() {
            this.x = 0d;
            this.y = 0d;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    public void No1_24() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String str = sc.nextLine();
            String[] split = str.split(",");
            Point[] allpoint = new Point[split.length];
            int add_index = 0;
            for (String _str : split) {
                String[] _split = _str.split(" ");
                double _x = Double.parseDouble(_split[0]);
                double _y = Double.parseDouble(_split[1]);
                allpoint[add_index++] = new Point(_x, _y);
            }
            // 对点的集合进行排序
            Arrays.sort(allpoint, (o1, o2) -> {
                if (o1.getX() < o2.getX()) return -1;
                else if (o1.getX() == o2.getX()) {
                    if (o1.getY() <= o1.getY()) return -1;
                    else return 1;
                }
                return 1;
            });
            // 获取计算结果
            List<Point[]> result = getNearest(allpoint, 0, allpoint.length - 1);
            // 将结果排序
            Collections.sort(result, (o1, o2) -> {
                if (o1[0].getX() < o2[0].getX()) {
                    return -1;
                } else if (o1[0].getX() > o2[0].getX()) {
                    return 1;
                }
                return 0;
            });
            // 输出结果
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(",");
                System.out.print(formatPoint(result.get(i)[0]) + "," + formatPoint(result.get(i)[1]));
            }
        }
    }

    private String formatPoint(Point p) {
        StringBuilder sb = new StringBuilder();
        double x = p.getX();
        double y = p.getY();
        if (x == (int) x) sb.append((int) x);
        else sb.append(x);
        sb.append(" ");
        if (y == (int) y) sb.append((int) y);
        else sb.append(y);
        return sb.toString();
    }

    private double calDis(Point a, Point b) {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    public List<Point[]> getNearest(Point[] points, int left, int right) {
        //若只有一个点，则不存在最近点对的情况
        if (left == right) return new ArrayList<>();
        //若只有两个点，则它们就是最近点
        if (right == left + 1) {
            Point[] nearest = new Point[]{points[left], points[right]};
            List<Point[]> res = new ArrayList<>();
            res.add(nearest);
            return res;
        }
        //不止两个点的情况下，划分左右区间，分别取左右区间的最近点对集合
        int mid = (left + right) / 2;
        List<Point[]> leftNearest = getNearest(points, left, mid);
        List<Point[]> rightNearest = getNearest(points, mid + 1, right);
        double leftMinDistance = leftNearest.size() == 0 ? Double.MAX_VALUE : calDis(leftNearest.get(0)[0], leftNearest.get(0)[1]);
        double rightMinDistance = rightNearest.size() == 0 ? Double.MAX_VALUE : calDis(rightNearest.get(0)[0], rightNearest.get(0)[1]);
        //比较左右区间的最近点距离，更新当前区间的最近点距离以及最近点集合
        double minDistance = 0.0;
        List<Point[]> nearest = new ArrayList<>();
        if (leftMinDistance < rightMinDistance) {
            minDistance = leftMinDistance;
            nearest.addAll(leftNearest);
        } else if (leftMinDistance > rightMinDistance) {
            minDistance = rightMinDistance;
            nearest.addAll(rightNearest);
        } else {
            minDistance = leftMinDistance;
            nearest.addAll(leftNearest);
            nearest.addAll(rightNearest);
        }
        //处理最近点对一个点在左区间，另一个点在右区间的情况
        //在左区间检索到中间线距离<= minDistance的点，在右区间检索到中间线距离>= minDistance的点
        //记录检索到的点的索引
        List<Integer> leftIndex = new ArrayList<>();
        List<Integer> rightIndex = new ArrayList<>();
        for (int i = mid; i >= 0; i--) {
            if (points[mid].getX() - points[i].getX() <= minDistance) {
                leftIndex.add(i);
            } else {
                break;
            }
        }
        for (int i = mid + 1; i <= right; i++) {
            if (points[i].getX() - points[mid].getX() <= minDistance) {
                rightIndex.add(i);
            } else {
                break;
            }
        }
        for (int i = 0; i < leftIndex.size(); i++) {
            for (int j = 0; j < rightIndex.size(); j++) {
                Point leftPoint = points[leftIndex.get(i)];
                Point rightPoint = points[rightIndex.get(j)];
                //若两个点在y轴方向上的距离> minDistance，则跳过距离计算
                if (Math.abs(leftPoint.getY() - rightPoint.getY()) > minDistance) {
                    continue;
                }
                double tempDistance = calDis(leftPoint, rightPoint);
                if (tempDistance < minDistance) {
                    //若距离小于当前最小距离，更新minDistance，并删除原有最近点对集合，将该点对插入
                    minDistance = tempDistance;
                    nearest = new ArrayList<>();
                    nearest.add(new Point[]{leftPoint, rightPoint});
                } else if (tempDistance == minDistance) {
                    //若距离等于当前最小距离，将点对插入最近点对集合
                    nearest.add(new Point[]{leftPoint, rightPoint});
                }
            }
        }
        return nearest;
    }
}
