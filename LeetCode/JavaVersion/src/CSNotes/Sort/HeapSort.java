package CSNotes.Sort;

public class HeapSort {
    // 调整以parent_index序号为父节点，最大长度为length序号的树的排列
    private void heapAdjust(int[] nums, int parent_index, int length) {
        int temp = nums[parent_index];
        int child = 2 * parent_index + 1;
        while (child < length) {
            // 如果存在右子树，且右子树的值大于左节点，则选取该右子树节点
            if (child + 1 < length && nums[child + 1] > nums[child]) child++;

            // 如果父节点的值已经是最大的，则直接结束
            // 为什么直接结束？
            // 因为数组的遍历顺序是从下到上，每次遍历完一层，都能够保证该父节点的值是最大的，直接退出循环即可
            if (temp >= nums[child]) break;

            // 将父节点替换为比较大值的节点的值
            nums[parent_index] = nums[child];

            // 继续向下遍历子节点
            parent_index = child;
            child = child * 2 + 1;
        }
        nums[parent_index] = temp;
    }

    // 堆排序
    public void heapSort(int[] nums) {
        // 循环建立初始堆栈
        for (int i = nums.length / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }

        // 再进行n-1次循环，完成排序
        for (int i = nums.length - 1; i > 0; i--) {
            // 第一个元素和第i个元素交换
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // 继续进行堆排序
            heapAdjust(nums, 0, i);
        }
    }
}
