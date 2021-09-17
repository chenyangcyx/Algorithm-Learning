package 秋招真题.美团;

import java.util.Scanner;

public class mt10_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            String[] input_split1 = input1.split(" ");
            String[] input_split2 = input2.split(" ");
            int n = Integer.parseInt(input_split1[0]);
//            ArrayList<Integer> input_list=new ArrayList<>(n);
            long sum = 0L;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(input_split2[i]);
//                input_list.add(num);
                sum += num;
            }
            System.out.println(Math.abs(sum - (n + 1) * n / 2));
        }
    }
}
