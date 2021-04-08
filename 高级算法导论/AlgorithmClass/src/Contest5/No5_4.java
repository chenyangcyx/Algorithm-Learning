package Contest5;

import java.util.Arrays;
import java.util.Scanner;

public class No5_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] nums = new int[N][2];
            int max_deadline = -1;
            for (int i = 0; i < N; i++) {
                int no = sc.nextInt();
                nums[no - 1][0] = sc.nextInt();
                nums[no - 1][1] = sc.nextInt();
                max_deadline = Math.max(max_deadline, nums[no - 1][0]);
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[1] == o2[1]) return o2[0] - o1[0];
                else return o2[1] - o1[1];
            });
            int[] deadline = new int[max_deadline + 1];
            int count = 0, result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = nums[i][0]; j >= 1; j--) {
                    if (deadline[j] == 0) {
//                        System.out.println("成功放置："+nums[i][1]+"在"+j);
                        count++;
                        result += nums[i][1];
                        deadline[j] = 1;
                        break;
                    }
                }
            }
            System.out.println(count + " " + result);
        }
    }
}


/*
// https://raw.githubusercontent.com/njuselw/AdvancedAlgorithm/master/src/FifthExercise/Problem0504.java
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem0504 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][2];
            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                tasks[x - 1][0] = scanner.nextInt();
                tasks[x - 1][1] = scanner.nextInt();
            }
            int[] res = getMaxProfitAndTaskNum(tasks);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    public static int[] getMaxProfitAndTaskNum(int[][] tasks) {
        //按照profit进行排序，相同的profit按ddl逆序排序
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        int n = tasks.length;
        int maxDDL = 0;
        for (int i = 0; i < n; i++) {
            maxDDL = Math.max(maxDDL, tasks[i][0]);
        }
        //从最大利润任务开始，将其安排在ddl位置，如果已被占用，则往前放
        int[] days = new int[maxDDL + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = tasks[i][0]; j > 0; j--) {
                if (days[j] == 0) {
                    days[j] = tasks[i][1];
                    cnt++;
                    break;
                }
            }
        }
        int profit = 0;
        for (int i = 0; i < days.length; i++) {
            profit += days[i];
        }
        return new int[]{cnt, profit};
    }
}
*/