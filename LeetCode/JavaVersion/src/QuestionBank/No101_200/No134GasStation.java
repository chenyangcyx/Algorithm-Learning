package QuestionBank.No101_200;

public class No134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int start_point = 0; start_point < length; start_point++) {
            if (gas[start_point] < cost[start_point]) continue;
            int sum = 0;
            for (int i = start_point; ; ) {
                sum = sum + gas[i] - cost[i];
                if (sum < 0) break;
                i = (i + 1) % length;
                if (i == start_point) return start_point;
            }
        }
        return -1;
    }
}

// LeetCode 代码
/*
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
 */