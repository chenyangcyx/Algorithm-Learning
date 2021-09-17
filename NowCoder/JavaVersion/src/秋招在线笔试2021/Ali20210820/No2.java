package 秋招在线笔试2021.Ali20210820;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[m][2];
        for (int i = 0; i < m; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        int max_number = 0;
        HashMap<Integer, Integer> people_saidao = new HashMap<>();
        HashMap<Integer, Integer> saidao_renshu = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            people_saidao.put(i, i);
            saidao_renshu.put(i, 1);
        }
        LinkedList<Integer> result = new LinkedList<>();
        for (int zl = 0; zl < m; zl++) {
            int a = data[zl][0];
            int b = data[zl][1];
            int a_saidao = people_saidao.get(a);
            int b_saidao = people_saidao.get(b);
//            System.out.println("此时a="+a+"赛道"+a_saidao+"，b="+b+"赛道"+b_saidao);
            // 指令前已经在同一赛道
            if (a_saidao == b_saidao) {
                result.addLast(max_number - saidao_renshu.get(a_saidao));
//                System.out.println("记录值："+(max_number - saidao_renshu.get(a_saidao)));
//                System.out.println("max number："+max_number);
            }
            // 合并到a赛道上
            else if (a_saidao > b_saidao) {
                people_saidao.put(b, a_saidao);
                saidao_renshu.put(a_saidao, saidao_renshu.get(a_saidao) + 1);
                saidao_renshu.put(b_saidao, saidao_renshu.get(b_saidao) - 1);
                // 更新max_number
                int flag = saidao_renshu.get(1);
                for (int k = 2; k <= n; k++) {
                    flag = Math.max(saidao_renshu.get(k), flag);
                }
                max_number = flag;
//                System.out.println("更新后的max number："+max_number);
            }
            // 合并到b赛道上
            else {
                people_saidao.put(a, b_saidao);
                saidao_renshu.put(b_saidao, saidao_renshu.get(b_saidao) + 1);
                saidao_renshu.put(a_saidao, saidao_renshu.get(a_saidao) - 1);
                // 更新max_number
                int flag = saidao_renshu.get(1);
                for (int k = 2; k <= n; k++) {
                    flag = Math.max(saidao_renshu.get(k), flag);
                }
                max_number = flag;
//                System.out.println("更新后的max number："+max_number);
            }
        }
        // 输出
        result.forEach(System.out::println);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(people_saidao.get(i));
            } else {
                System.out.print(" " + people_saidao.get(i));
            }
        }
        System.out.println();
    }
}
