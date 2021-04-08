package QuestionBank.No101_200;

public class No190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int start = 0, end = 31;
        int result = n;
        while (start < end) {
            result = exchangeBitValue(result, start, end);
            start++;
            end--;
        }
        return result;
    }

    private int exchangeBitValue(int num, int p1, int p2) {
        int p1_value = num >>> p1 & 1;
        int p2_value = num >>> p2 & 1;
        num = p1_value == 1 ? num | (1 << p2) : num & (~(1 << p2));
        return p2_value == 1 ? num | (1 << p1) : num & (~(1 << p1));
    }
}

// LeetCode 参考代码1
/*
class Solution {
    public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t rev = 0;
        for (int i = 0; i < 32 && n > 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return rev;
    }
}
*/

// LeetCode 参考代码2
/*
public class Solution {
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }
}
*/