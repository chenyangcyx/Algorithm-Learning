package 秋招在线笔试2021.HuaWei20210915;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String[] sp1 = input1.split(" ");
        String[] sp2 = input2.split(" ");
        ArrayList<Integer> works = new ArrayList<>();
        ArrayList<Integer> ster = new ArrayList<>();
        for (int i = 0; i < sp1.length; i++) {
            works.add(Integer.parseInt(sp1[i]));
        }
        for (int i = 0; i < sp2.length; i++) {
            ster.add(Integer.parseInt(sp2[i]));
        }
        works.sort(Comparator.comparingInt(o -> o));
        ster.sort(Comparator.comparingInt(o -> o));

        int _a = Math.abs(works.get(0) - ster.get(0));
        int _b = Math.abs(ster.get(0) - works.get(works.size() - 1));
        int min_dis = Math.min(_a, _b);
        int max_dis = Math.max(_a, _b);

        for (int dis = min_dis; dis <= max_dis; dis++) {
            if (ifGetAll2(dis, works, ster)) {
                System.out.println(dis);
                break;
            }
        }
    }

    static boolean ifGetAll1(int dis, ArrayList<Integer> works, ArrayList<Integer> ster) {
        HashSet<Integer> allwork = new HashSet<>();
        for (int ster_item : ster) {
            allwork.clear();
            allwork.addAll(works);
            int st = ster_item - dis;
            int en = ster_item + dis;
            deleteFanwei(st, en, allwork);
            if (allwork.size() == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean ifGetAll2(int dis, ArrayList<Integer> works, ArrayList<Integer> ster) {
        ArrayList<Integer> st = new ArrayList<>();
        ArrayList<Integer> en = new ArrayList<>();
        for (int ster_item : ster) {
            st.add(ster_item - dis);
            en.add(ster_item + dis);
        }
        for (int work_item : works) {
            int flag=0;
            for (int i = 0; i < st.size(); i++) {
                int ss = st.get(i);
                int ee = en.get(i);
                if(work_item>=ss&&work_item<=ee){
                    flag++;
                    break;
                }
            }
            if(flag==0){
                return false;
            }
        }
        return true;
    }

    static void deleteFanwei(int st, int en, HashSet<Integer> set) {
        for (int i = st; i <= en; i++) {
            set.remove(i);
        }
    }
}
