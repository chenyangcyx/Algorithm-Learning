package QuestionBank.No401_500;


public class No457CircularArrayLoop {
    public static void main(String[] args) {
        int[] num1 = new int[]{2, -1, 1, 2, 2};
        int[] num2 = new int[]{-1, 2};
        int[] num3 = new int[]{-2, 1, -1, -2, -2};
        int[] num4 = new int[]{-1, -1, -3};
        int[] num5 = new int[]{-1};
        int[] num6 = new int[]{-2, -17, -1, -2, -2};

        No457CircularArrayLoop no457_circularArrayLoop = new No457CircularArrayLoop();

        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num1));
        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num2));
        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num3));
        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num4));
        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num5));
        System.out.println(no457_circularArrayLoop.circularArrayLoop1(num6));

        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num1));
        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num2));
        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num3));
        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num4));
        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num5));
        System.out.println(no457_circularArrayLoop.circularArrayLoop2(num6));
    }

    public boolean circularArrayLoop1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int pre = i;
            int len = 1;
            boolean flag = nums[start] > 0;
            while (true) {
                int now = ((pre + nums[pre]) % nums.length + nums.length) % nums.length;
                if ((nums[now] > 0) != flag) {
                    break;
                }
                if (now == pre) {
                    break;
                } else if (now == start) {
                    return true;
                }
                pre = now;
                len++;
                if (len > nums.length + 1) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean circularArrayLoop2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = nextPos(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[nextPos(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != nextPos(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = nextPos(nums, slow);
                fast = nextPos(nums, nextPos(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[nextPos(nums, add)] > 0) {
                int temp = add;
                add = nextPos(nums, add);
                nums[temp] = 0;
            }
        }
        return false;
    }

    private int nextPos(int[] nums, int cur) {
        return ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
    }
}
