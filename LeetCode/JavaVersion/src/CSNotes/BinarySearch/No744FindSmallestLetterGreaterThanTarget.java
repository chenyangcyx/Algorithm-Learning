package CSNotes.BinarySearch;

public class No744FindSmallestLetterGreaterThanTarget {
    // 自己写的代码
    public char nextGreatestLetter1(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l>=letters.length?letters[0]:letters[l];
    }

    // CS-Note参考代码
    public char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
