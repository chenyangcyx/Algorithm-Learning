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
