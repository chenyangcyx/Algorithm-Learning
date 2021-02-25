package CSNotes.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(int[] nums){
        // 计算该数组的最大值和最小值
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        // 计算桶的数量
        int bucket_num=(max-min)/nums.length+1;
        ArrayList<ArrayList<Integer>> bucketArr=new ArrayList<>(bucket_num);
        for(int i=0;i<bucket_num;i++){
            bucketArr.add((new ArrayList<Integer>()));
        }
        // 将每个数组元素放入对应的桶中
        for(int i=0;i<nums.length;i++){
            int in_bucket_num=(nums[i]-min)/nums.length;
            bucketArr.get(in_bucket_num).add(nums[i]);
        }
        // 使用系统自带的排序算法对桶内元素进行排序
        for(ArrayList<Integer> list:bucketArr){
            Collections.sort(list);
        }
        // 将桶内元素还原到原来的序列
        int index=0;
        for(ArrayList<Integer> list:bucketArr){
            for(int num:list){
                nums[index++]=num;
            }
        }
    }
}
