package QuestionBank.No101_200;

public class No169MajorityElement {
    public int majorityElement1(int[] nums) {
        for(int i= nums.length/2;i>=0;i--){
            adjustHeap(nums,i, nums.length);
        }
        for(int i= nums.length-1;i>0;i--){
            nums[0]=nums[0]^nums[i];
            nums[i]=nums[0]^nums[i];
            nums[0]=nums[0]^nums[i];
            adjustHeap(nums,0,i);
        }
        return nums[nums.length/2];
    }

    private void adjustHeap(int[] nums,int parent_index,int length){
        int temp=nums[parent_index];
        int child=2*parent_index+1;
        while (child<length){
            if(child+1<length&&nums[child+1]>nums[child]) child++;
            if(temp>=nums[child]) break;
            nums[parent_index]=nums[child];
            parent_index=child;
            child=2*child+1;
        }
        nums[parent_index]=temp;
    }

    public int majorityElement2(int[] nums) {
        int now_num=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                now_num=num;
            }
            if(now_num==num) count++;
            else count--;
        }
        return now_num;
    }
}

// LeetCode 代码1，哈希表
/*
class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}
 */


// LeetCode 代码2，排序
/*
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
 */

// LeetCode 代码3，随机化
/*
class Solution {
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}
 */

// LeetCode 代码4，分治
/*
class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
}
 */

// LeetCode 代码5，Boyer-Moore 投票算法
/*
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
 */