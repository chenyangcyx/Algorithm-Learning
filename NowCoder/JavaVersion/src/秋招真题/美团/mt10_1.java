package 秋招真题.美团;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class mt10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            String[] input_split1 = input1.split(" ");
            String[] input_split2 = input2.split(" ");
            int n = Integer.parseInt(input_split1[0]);
            int x = Integer.parseInt(input_split1[1]);
            int y = Integer.parseInt(input_split1[2]);
            ArrayList<Integer> scores = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                scores.add(Integer.parseInt(input_split2[i]));
            }
            TreeSet<Integer> data = new TreeSet<>(Comparator.comparingInt(o -> o));
            data.addAll(scores);
            boolean flag=false;
            for (int line=data.first();line<=data.last();line++) {
                int unpass = data.headSet(line, true).size();
                int pass = n - unpass;
                if (unpass >= x && unpass <= y && pass >= x && pass <= y) {
                    System.out.println(line);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }
        }
    }
}


// 参考代码
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * 美团校招 第10场 第1题
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int x = in.nextInt();
//        int y = in.nextInt();
//        int[] score = new int[n];
//        for (int i = 0; i < n; i++) {
//            score[i] = in.nextInt();
//        }
//        /**
//         * 符合条件的最低分数线 -> 过线的人多 -> 使用人数限制最大值 y作为过线人数 -> 判断剩下的人数 是否在[x,y]区间 ->
//         *      如果在 直接返回
//         *      如果不在
//         *          如果人数少于x 则直接找到分数最低的第x个人即可
//         *          如果人数大于y 则证明找不到一个分数线满足条件
//         */
//        // 对成绩排序
//        Arrays.sort(score);
//        // 没过线的人数
//        int notOk = n - y;
//        if (notOk > y){
//            System.out.println(-1);
//        }else if (notOk >= x && notOk <= y){
//            System.out.println(score[n-y-1]);
//        }else{
//            System.out.println(score[x-1]);
//        }
//    }
//}
