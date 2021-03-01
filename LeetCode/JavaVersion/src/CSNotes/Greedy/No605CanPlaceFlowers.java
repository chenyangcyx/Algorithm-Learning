package CSNotes.Greedy;

public class No605CanPlaceFlowers {
    // 自己写的代码
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count0 = 1;
        int result = 0;
        for (int flower_num : flowerbed) {
            if (flower_num == 1) {
                result += (count0 - 1) / 2;
                count0 = 0;
            } else {
                count0++;
            }
        }
        // 数组的结尾
        result += count0 / 2;
        return result >= n;
    }

    // CS-Note参考代码
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
