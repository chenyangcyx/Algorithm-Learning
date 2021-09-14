package HuaWei;

import java.util.Scanner;

public class HJ97记负均正 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int zhengshu_num = 0;
            int fushu_num = 0;
            long sum = 0;
            for (int num : arr) {
                if (num < 0) {
                    fushu_num++;
                } else if (num > 0) {
                    zhengshu_num++;
                    sum += num;
                }
            }
            System.out.printf("%d %.1f\n", fushu_num, sum * 1.0 / zhengshu_num);
        }
    }
}
