package CSNotes.Greedy;

import java.util.Arrays;

public class No455AssignCookies {
    // 自己写的
    public int findContentChildren1(int[] g, int[] s) {
        int res = 0;
        int g_index = 0, s_index = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (g_index < g.length && s_index < s.length) {
            if (s[s_index] >= g[g_index]) {
                res++;
                g_index++;
                s_index++;
            } else {
                s_index++;
            }
        }
        return res;
    }

    // CS-Notes参考代码
    public int findContentChildren2(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
