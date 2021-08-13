package QuestionBank.No1_100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        if (N == 1) return intervals;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < N; ) {
            int x = intervals[i][0], y = intervals[i][1];
            int j = i + 1;
            for (; j < N; j++) {
                if (intervals[j][0] <= y) {
                    x = Integer.min(x, intervals[j][0]);
                    y = Integer.max(y, intervals[j][1]);
                } else break;
            }
            result.add(new Pair<>(x, y));
            i = j;
        }
        // 转换为结果数组
        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            res[i] = new int[]{result.get(i).getKey(), result.get(i).getValue()};
        }
        return res;
    }

    // LeetCode 参考代码
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
