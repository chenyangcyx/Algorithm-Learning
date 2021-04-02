package QuestionBank;

public class 面试题17_21_VolumeofHistogramLCCI {
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) return 0;
        int[] left_max = new int[length], right_max = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) left_max[i] = height[i];
            else left_max[i] = Integer.max(left_max[i - 1], height[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) right_max[i] = height[i];
            else right_max[i] = Integer.max(right_max[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Integer.min(left_max[i], right_max[i]) - height[i];
        }
        return result;
    }
}


// LeetCode 参考代码1
// 动态规划
/*
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
*/


// LeetCode 参考代码2
// 单调栈
/*
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
*/


// LeetCode 参考代码
// 双指针
/*
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
*/