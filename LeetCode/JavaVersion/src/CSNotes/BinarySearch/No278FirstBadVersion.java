package CSNotes.BinarySearch;

public class No278FirstBadVersion {
    public boolean isBadVersion(int version){
        return true;
    }

    // 自己写的代码
    public int firstBadVersion1(int n) {
        int l=0,r=n-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(isBadVersion(mid)) r=mid-1;
            else l=mid+1;
        }
        return l;
    }

    //CS-Note参考代码
    // 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；
    // 否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1
    // 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h
    public int firstBadVersion2(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
