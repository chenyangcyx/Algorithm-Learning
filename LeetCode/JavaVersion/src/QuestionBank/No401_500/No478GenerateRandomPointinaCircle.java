package QuestionBank.No401_500;

public class No478GenerateRandomPointinaCircle {
    double o_x, o_y, r;

    public No478GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.o_x = x_center;
        this.o_y = y_center;
        this.r = radius;
    }

    public double[] randPoint() {
        double a = Math.random() * 2 * r - r;
        double _b = Math.sqrt(r * r - a * a);
        double b = Math.random() * 2 * _b - _b;
        return new double[]{o_x + a, o_y + b};
    }
}

// LeetCode 代码1
/*
class Solution {
    double rad, xc, yc;
    public Solution(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;

        while(true) {
            double xg = x0 + Math.random() * rad * 2;
            double yg = y0 + Math.random() * rad * 2;
            if (Math.sqrt(Math.pow((xg - xc) , 2) + Math.pow((yg - yc), 2)) <= rad)
                return new double[]{xg, yg};
        }
    }
}
 */

// LeetCode 代码2
/*
class Solution {
    double rad, xc, yc;
    public Solution(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double d = rad * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + xc, d * Math.sin(theta) + yc};
    }
}
 */