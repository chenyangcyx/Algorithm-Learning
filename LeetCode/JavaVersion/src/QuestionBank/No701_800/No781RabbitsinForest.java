package QuestionBank.No701_800;

import java.util.HashMap;
import java.util.Map;

public class No781RabbitsinForest {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int x = en.getValue(), y = en.getKey();
            result += ((int) Math.ceil(x * 1d / (y + 1))) * (y + 1);
        }
        return result;
    }
}


// LeetCode 参考代码1
/*
class Solution {
    public int numRabbits(int[] cs) {
        Arrays.sort(cs);
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = cs[i];
            ans += cnt + 1;
            // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」
            int k = cnt;
            while (k-- > 0 && i + 1 < n && cs[i] == cs[i + 1]) i++;
        }
        return ans;
    }
}
*/


// LeetCode 参考代码2
/*
class Solution {
    int N = 1009;
    int[] counts = new int[N];
    public int numRabbits(int[] cs) {
        // counts[x] = cnt 代表在 cs 中数值 x 的数量为 cnt
        for (int i : cs) counts[i]++;
        int ans = counts[0];
        for (int i = 1; i < N; i++) {
            int per = i + 1;
            int cnt = counts[i];
            int k = cnt / per;
            if (k * per < cnt) k++;
            ans += k * per;
        }
        return ans;
    }
}
*/