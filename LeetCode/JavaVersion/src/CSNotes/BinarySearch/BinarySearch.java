package CSNotes.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] nums, int key) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == key) return mid;
            else if (nums[mid] > key) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
