package Contest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class No2_2 {
    public void No2_2(){
        Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(sc.nextLine());
        while (T-->0){
            String []str1=sc.nextLine().split(" ");
            int node_num=Integer.parseInt(str1[0]);
            int start_node=str1[1].charAt(0)-'a';
            HashMap<Character,Integer> char_num=new HashMap<>();
            String []str2=sc.nextLine().split(" ");
            for(int i=0;i< str2.length;i++){
                char_num.put(str2[i].charAt(0),i);
            }
            int [][]graph=new int[node_num][node_num];
            for(int i=0;i<node_num;i++){
                String []line=sc.nextLine().split(" ");
                for(int j=1;j<line.length;j++){
                    if(line[j].charAt(0)=='1') graph[i][j-1]=graph[j-1][i]=1;
                }
            }
//            // 输出graph
//            for(int i=0;i<node_num;i++){
//                for(int j=0;j<node_num;j++)
//                    System.out.print(graph[i][j]+" ");
//                System.out.println();
//            }
            LinkedList<Integer> queue=new LinkedList<>();
            queue.add(start_node);
            boolean []vis=new boolean[node_num];
            vis[start_node]=true;
            ArrayList<Character> result=new ArrayList<>();
            while (!queue.isEmpty()){
                int p=queue.pollFirst();
                result.add((char) (p+'a'));
                for(int i=0;i<node_num;i++){
                    if(graph[p][i]==1 && !vis[i]) {
                        queue.add(i);
                        vis[i]=true;
                    }
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<result.size();i++){
                if(i==0) sb.append(result.get(i));
                else sb.append(" ").append(result.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}
