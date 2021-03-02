package CSNotes.BinarySearch;

public class No34FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int first = searchFirst(nums, target);
        int last = searchFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        else return new int[]{first, Integer.max(first, last)};
    }

    private int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
