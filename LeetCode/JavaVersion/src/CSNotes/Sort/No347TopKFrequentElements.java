package CSNotes.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numFrequencyMap=new HashMap<>();
        // 利用map统计每一个数字的出现次数
        for(int num:nums){
            numFrequencyMap.put(num,numFrequencyMap.getOrDefault(num,0)+1);
        }
        // 定义桶list并按照出现频率向里面添加元素
        List<Integer>[] buckets=new ArrayList[nums.length+1];
        for(int key:numFrequencyMap.keySet()){
            int frequency=numFrequencyMap.get(key);
            if(buckets[frequency]==null){
                buckets[frequency]=new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        // 从大到小遍历数组，选择出现频率第k大的数加入
        List<Integer> topK=new ArrayList<>();
        for(int i=buckets.length-1;i>=0 && topK.size()<k;i--){
            if(buckets[i]==null)    continue;
            if(buckets[i].size()<=(k- topK.size())) topK.addAll(buckets[i]);
            else    topK.addAll(buckets[i].subList(0,k-topK.size()));
        }
        // 还原为数组，返回
        int []res=new int[k];
        for(int i=0;i<k;i++)    res[i]=topK.get(i);

        return res;
    }
}
