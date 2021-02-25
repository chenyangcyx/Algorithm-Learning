package CSNotes.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No435NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
//        // 方式1，使用comparingInt函数
//        // t->t[1]，t为传入的一个一维数组，取t[1]为传递给comparingInt函数的int值
//        Arrays.sort(intervals, Comparator.comparingInt(t->t[1]));
        // 方式2，重写覆盖Comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) continue;
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
