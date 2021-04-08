package QuestionBank.No901_1000;

public class No912SortanArray {
    // 快速排序
    public int[] sortArray_1_quicksort(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums;
        quicksort(nums, 0, N - 1);
        return nums;
    }

    private void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = Partation(nums, left, right);
            quicksort(nums, left, pos - 1);
            quicksort(nums, pos + 1, right);
        }
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

    // 堆排序
    public int[] sortArray2_heapsort(int[] nums) {
        // 建立堆
        for (int i = nums.length / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        // 不断的将最大值移到最后，升序排序
        for (int i = nums.length - 1; i > 0; i--) {
            int _t = nums[0];
            nums[0] = nums[i];
            nums[i] = _t;
            heapAdjust(nums, 0, i);
        }
        return nums;
    }

    private void heapAdjust(int[] nums, int parent_index, int length) {
        int temp = nums[parent_index];
        int child = 2 * parent_index + 1;
        while (child < length) {
            // 如果右子树更大，则选择右子树
            if (child + 1 < length && nums[child + 1] > nums[child]) child++;
            // 如果父节点已经是最大了，则没有必要往下搜索了
            if (temp >= nums[child]) break;
            // 否则将最大的节点替换成父节点
            nums[parent_index] = nums[child];
            // 继续往下查找
            parent_index = child;
            child = 2 * child + 1;
        }
        nums[parent_index] = temp;
    }

    // 归并排序1
    public int[] sortArray3_mergesort1(int[] nums) {
        if (nums.length < 2) return nums;
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergesort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
//        int mid=(l+r)>>1;
        mergesort(nums, l, mid);
        mergesort(nums, mid + 1, r);
//        int i = l, j = mid + 1;
//        int[] tmp = new int[r - l + 1];
//        int count = 0;
//        while (i <= mid && j <= r) {
//            if (nums[i] <= nums[j]) tmp[count++] = nums[i++];
//            else tmp[count++] = nums[j++];
//        }
//        while (i <= mid) tmp[count++] = nums[i++];
//        while (j <= r) tmp[count++] = nums[j++];
//        // 最后一步，将tmp数组中的值复制到原数组中
//        for (int k = 0; k < r - l + 1; k++) {
//            nums[l + k] = tmp[k];
//        }
        merge(nums, l, mid, mid + 1, r);
    }

    private void merge(int[] nums, int L1, int R1, int L2, int R2) {
        int i = L1, j = L2;
        int[] tmp = new int[R2 - L1 + 1];
        int index = 0;
        while (i <= R1 && j <= R2) {
            if (nums[i] <= nums[j]) tmp[index++] = nums[i++];
            else tmp[index++] = nums[j++];
        }
        while (i <= R1) tmp[index++] = nums[i++];
        while (j <= R2) tmp[index++] = nums[j++];
        for (int k = 0; k < index; k++) nums[L1 + k] = tmp[k];
    }

    // 归并排序2
    public int[] sortArray3_mergesort2(int[] nums) {
        if (nums.length < 2) return nums;
        // 以step为步长，从2开始，一直到step/2<=n为止
        for (int step = 2; step / 2 <= nums.length; step *= 2) {
            // 每step个元素为一组，前step/2个元素和后step/2个元素进行合并
            for (int i = 0; i < nums.length; i += step) {
                int mid = i + step / 2;
                if (mid < nums.length) {
                    merge(nums, i, mid - 1, mid, Integer.min(i + step - 1, nums.length - 1));
                }
            }
        }
        return nums;
    }
}
