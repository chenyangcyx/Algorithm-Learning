package QuestionBank;

import java.util.HashMap;
import java.util.LinkedList;

public class No227BasicCalculatorII_2 {
    // 定义一个运算符的优先顺序表
    HashMap<Character, Integer> op_map = new HashMap<>();

    public int calculate(String s) {
        op_map.put('+', 1);
        op_map.put('-', 1);
        op_map.put('*', 2);
        op_map.put('/', 2);
        op_map.put('%', 3);
        op_map.put('^', 3);
        // 将s中的所有空格去掉
        // 将所有的(-形式转换成(0-的形式
        // 最后将s转换成数组
        char[] cs = s.replace(" ", "").replace("(-", "(0-").toCharArray();
        int n = cs.length;
        // 定义栈nums，用来存放所有的数字
        LinkedList<Integer> nums = new LinkedList<>();
        // 为了防止-开头的表达式，所以先加个0
        nums.addLast(0);
        // 定义栈ops，用来存放所有的操作
        LinkedList<Character> ops = new LinkedList<>();
        // 开始遍历数组cs
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            // 遇到左括号(
            if (c == '(') ops.addLast(c);
                // 遇到右括号
                // 计算值，直到遇到最近一个左括号(为止
            else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') calc(nums, ops);
                    else {
                        // 计算到了左括号(，则停止
                        // 同时将左括号弹出
                        ops.pollLast();
                        break;
                    }
                }
            }
            // 遇到数字或操作符
            // 空格此处不用考虑，因为已经在开始处理好了
            else {
                if (Character.isDigit(c)) {
                    // 将连续的字符串转换为数字
                    int u = 0;
                    // j从i开始计数
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) u = u * 10 + cs[j++] - '0';
                    nums.addLast(u);
                    // 更新i的位置
                    i = j - 1;
                }
                // 操作符入栈
                else {
                    // 在操作符入栈前，先把栈内能算的都算出来
                    // 停止条件为ops栈为空，或者遇到左括号(
                    // 左括号只有碰到右括号)时才可以处理
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        // 如果栈顶的操作符优先级更高
                        // 则需要先计算完
                        if (op_map.get(prev) >= op_map.get(c)) calc(nums, ops);
                            // 栈顶的优先级更低，不用处理
                            // 直接退出while循环
                        else break;
                    }
                    // 新的操作符入栈
                    ops.addLast(c);
                }
            }
        }
        // 字符串cs读取完毕后，栈内可能还有剩余的操作符没有处理
        // 处理剩下的操作符
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.peekLast();
    }

    private void calc(LinkedList<Integer> nums, LinkedList<Character> ops) {
        // 如果栈nums为空或者大小<2，直接返回
        if (nums.isEmpty() || nums.size() < 2) return;
        // 如果栈ops为空，直接返回
        if (ops.isEmpty()) return;
        // 从nums中弹出2个数值
        // 注意弹出的顺序，先弹出的是第2个操作数
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        // 存放结果的变量
        int ans = 0;
        switch (op) {
            case '+':
                ans = a + b;
                break;
            case '-':
                ans = a - b;
                break;
            case '*':
                ans = a * b;
                break;
            case '/':
                ans = a / b;
                break;
            case '^':
                ans = (int) Math.pow(a, b);
                break;
            case '%':
                ans = a % b;
                break;
            default:
                break;
        }
        // 将计算好的结果放入栈nums中
        nums.addLast(ans);
    }
}
