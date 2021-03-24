package QuestionBank;

public class No7ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int flag = x < 0 ? -1 : 1;
        int abxs = Math.abs(x);
        while (abxs != 0) {
            if (result * 10 / 10 != result) return 0;
            result = result * 10 + abxs % 10;
            abxs /= 10;
        }
        return result * flag;
    }

    // LeetCode 参考代码
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
