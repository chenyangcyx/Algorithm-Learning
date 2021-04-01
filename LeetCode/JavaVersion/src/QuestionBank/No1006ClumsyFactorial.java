package QuestionBank;

import java.util.LinkedList;

public class No1006ClumsyFactorial {
    // 自己写的1
    // 4个一组 进行模拟
    public int clumsy_my1(int N) {
        int result = Integer.MIN_VALUE;
        for (int i = N; i - 4 >= 0; i -= 4) {
            if (i == N) {
                result = i * (i - 1) / (i - 2) + (i - 3);
            } else {
                result = result - i * (i - 1) / (i - 2) + (i - 3);
            }
        }
//        System.out.println(result);
        switch (N % 4) {
            case 1:
                result = (result == Integer.MIN_VALUE ? 1 : result - 1);
                break;
            case 2:
                result = (result == Integer.MIN_VALUE ? 2 : result - 2);
                break;
            case 3:
                result = (result == Integer.MIN_VALUE ? 6 : result - 6);
                break;
            default:
                break;
        }
        return result;
    }

    // 自己写的2
    // 栈的写法
    public int clumsy_my2(int N) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(N--);
        int op = 0;
        while (N > 0) {
//            System.out.println("当前stack的顶部："+stack.peekLast()+"，大小："+stack.size());
            if (op == 0) stack.addLast(stack.pollLast() * N);
            else if (op == 1) stack.addLast(stack.pollLast() / N);
            else if (op == 2) stack.addLast(N);
            else stack.addLast(-N);
            op = (op + 1) % 4;
            N--;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }
}


// LeetCode 参考代码1
/*
class Solution {
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
*/


// LeetCode 参考代码2
/*
class Solution {
    public int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }
}
*/