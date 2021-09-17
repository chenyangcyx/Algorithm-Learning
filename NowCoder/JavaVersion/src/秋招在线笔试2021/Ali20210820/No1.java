package 秋招在线笔试2021.Ali20210820;

import java.util.HashSet;
import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
//        ArrayList<ArrayList<Integer>> data = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            data.add(new ArrayList<>());
//            data.get(i).add(sc.nextInt());
//            data.get(i).add(sc.nextInt());
//            data.get(i).add(sc.nextInt());
//        }
        int[][] data=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                data[i][j]=sc.nextInt();
            }
        }
        HashSet<Integer> already_in = new HashSet<>();
        int[] floor_num = new int[6];
        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> temp_data = data.get(i);
            int[] temp_data=data[i];
//            int a = temp_data.get(0), b = temp_data.get(1), c = temp_data.get(2);
            int a=temp_data[0],b=temp_data[1],c=temp_data[2];
            // 有人进入
            if (b == 1) {
                if (!already_in.contains(a) && floor_num[c] < K) {
                    floor_num[c]++;
                    already_in.add(a);
                }
            }
            // 有人出去
            else {
                floor_num[c]--;
            }
            // 输出
            for (int j = 1; j <= 5; j++) {
                if (j == 1) {
                    System.out.print(floor_num[j]);
                } else {
                    System.out.print(" " + floor_num[j]);
                }
            }
            System.out.println();
        }
    }
}
