package QuestionBank.华为;

import java.util.Scanner;

public class HJ16购物单 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if (money <= 0 || n <= 0) {
            System.out.println(0);
        }

        good[] gs = new good[n + 1];
        for (int i = 1; i <= n; i++) {
            gs[i] = new good(0, 0, 0);
        }
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            gs[i].setdata(v, p, q);
            // 附件
            if (q > 0) {
                if (gs[q].a1 == 0) {
                    gs[q].setA1(i);
                } else {
                    gs[q].setA2(i);
                }
            }
        }
        int[][] dp = new int[n + 1][money + 1];
        for (int i = 1; i <= n; i++) {
            int v = 0, v1 = 0, v2 = 0, v3 = 0, tempdp = 0, tempdp1 = 0, tempdp2 = 0, tempdp3 = 0;
            v = gs[i].v;
            tempdp = gs[i].p * v;
            // 只有附件1
            if (gs[i].a1 != 0) {
                v1 = gs[gs[i].a1].v + v;
                tempdp1 = tempdp + gs[gs[i].a1].v * gs[gs[i].a1].p;
            }
            if (gs[i].a2 != 0) {
                v2 = gs[gs[i].a2].v + v;
                tempdp2 = tempdp + gs[gs[i].a2].v * gs[gs[i].a2].p;
            }
            if (gs[i].a1 != 0 && gs[i].a2 != 0) {
                v3 = gs[gs[i].a1].v + gs[gs[i].a2].v + v;
                tempdp3 = tempdp + gs[gs[i].a1].v * gs[gs[i].a1].p + gs[gs[i].a2].v * gs[gs[i].a2].p;
            }

            for (int j = 1; j <= money; j++) {
                if (gs[i].q > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + tempdp);
                    }
                    if (j >= v1 && v1 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tempdp1);
                    }
                    if (j >= v2 && v2 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tempdp2);
                    }
                    if (j >= v3 && v3 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tempdp3);
                    }
                }
            }
        }
        System.out.println(dp[n][money]);
    }

    static class good {
        int v = 0;
        int p = 0;
        int q = 0;
        int a1 = 0;
        int a2 = 0;

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setdata(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
