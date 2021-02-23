package CSNotes.TwoPointers;

public class No633SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int res = i * i + j * j;
            if (res == c) return true;
            else if (res < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean judgeSquareSum_binarySearch1(int c) {
        if (c < 0) return false;
        for (long res1 = 0; res1 * res1 <= c; res1++) {
            long res2 = c - res1 * res1;
            if (binarysearch1(0, res2, res2)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarysearch1(long left, long right, long target) {
        if (left > right) return false;
        long mid = left + (right - left) / 2;
        long res = mid * mid;
        if (res == target) return true;
        else if (res < target) {
            return binarysearch1(mid + 1, right, target);
        } else {
            return binarysearch1(left, mid - 1, target);
        }
    }

    public boolean judgeSquareSum_binarySearch2(int c) {
        if (c < 0) return false;
        for (long res1 = 0; res1 * res1 <= c; res1++) {
            long res2 = c - res1 * res1;
            if (binarySearch2(0, (long) Math.sqrt(res2), res2)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch2(long left, long right, long target) {
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid * mid;
            if (res == target) return true;
            else if (res < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
