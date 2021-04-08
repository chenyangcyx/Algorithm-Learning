package QuestionBank.No201_300;

public class No215KthLargestElementinanArray {
    // 写法1，快速排序的方法
    public int findKthLargest1(int[] nums, int k) {
        return quicksort(nums, 0, nums.length - 1, k);
    }

    private int quicksort(int[] nums, int left, int right, int k) {
        int pos = Partation(nums, left, right);
        if (pos == nums.length - k) return nums[pos];
        return pos < nums.length - k ? quicksort(nums, pos + 1, right, k) : quicksort(nums, left, pos - 1, k);
    }

    private int Partation(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    // 写法2，堆排序的方法
    public int findKthLargest2(int[] nums, int k) {
        // 构建堆
        for (int i = nums.length / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        // 执行k-1次，取第倒数k大的值
        for (int i = 0; i < k - 1; i++) {
            int _t = nums[0];
            nums[0] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = _t;
            heapAdjust(nums, 0, nums.length - i - 1);
        }
        return nums[0];
    }

    private void heapAdjust(int[] nums, int parent_index, int length) {
        int temp = nums[parent_index];
        int child = parent_index * 2 + 1;
        while (child < length) {
            if (child + 1 < length && nums[child + 1] > nums[child]) child++;
            if (temp > nums[child]) break;
            nums[parent_index] = nums[child];
            parent_index = child;
            child = child * 2 + 1;
        }
        nums[parent_index] = temp;
    }
}

// LeetCode 参考代码1
/*
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
*/

// LeetCode 参考代码2
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
*/