package 秋招在线笔试2021.HuaWei20210915;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String[] sp1 = input1.split(" ");
        String[] sp2 = input2.split(" ");
        int aver = Integer.parseInt(sp1[0]);
        int n = Integer.parseInt(sp1[1]);
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>(2 * n);
        for (int i = 0; i < 2 * n; i++) {
            int _num = Integer.parseInt(sp2[i]);
            list.add(_num);
            sum += _num;
        }

        if (sum % aver != 0) {
            System.out.println(0);
        } else if (sum % aver == 0 && aver == 1) {
            list.sort(((o1, o2) -> o2 - o1));
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        else {
            list.sort(((o1, o2) -> o2 - o1));
            int[] arr=new int[list.size()];
            int pos=0;
            for (int item:list){
                arr[pos++]=item;
            }
            while (true){
                if(checkOK(arr,aver)){
                    for(int j=0;j<arr.length;j++){
                        if(j!= arr.length-1){
                            System.out.print(arr[j]+" ");
                        }
                        else {
                            System.out.println(arr[j]);
                        }
                    }
                    break;
                }
                else {
                    nextper(arr);
                }
            }
        }
    }

    static void nextper(int[] nums){
        int length= nums.length;
        if(length==1) return;
        int index=length-2;
        while (index>=0&&nums[index]>=nums[index+1]){
            index--;
        }
        if(index>=0){
            int j=length-1;
            while (j>=index&&nums[j]<=nums[index]){
                j--;
            }
            nums[index]=nums[index]^nums[j];
            nums[j]=nums[index]^nums[j];
            nums[index]=nums[index]^nums[j];
        }
        int left=index+1,right=length-1;
        while (left<right){
            nums[left]=nums[left]^nums[right];
            nums[right]=nums[left]^nums[right];
            nums[left]=nums[left]^nums[right];
            left++;
            right--;
        }
    }

    static boolean checkOK(int[] nums,int aver){
        for(int i=0;i< nums.length;i+=2){
            if((nums[i]+nums[i+1])%aver!=0){
                return false;
            }
        }
        return true;
    }
}
