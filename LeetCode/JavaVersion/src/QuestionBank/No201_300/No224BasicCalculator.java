package QuestionBank.No201_300;

import java.util.LinkedList;

public class No224BasicCalculator {
    public int calculate(String s) {
        // 创建队列以及栈
        // 队列用来存储后缀表达式，栈用来存储操作符
        LinkedList<Node> biaodashi = new LinkedList<>();
        LinkedList<Node> op_stack = new LinkedList<>();
        // 首部添加一个0，防止负数为首位
        biaodashi.addLast(new Node(0, ' ', true));
        // 开始遍历整个字符串
        char[] array = s.replace(" ", "").replace("(-", "(0-").toCharArray();
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; ) {
            char c = array[i];
//            System.out.println("当前的c："+c);
            // 如果该字符是数字
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < array.length && Character.isDigit(c)) {
                    c = array[i++];
                    num = num * 10 + (c - '0');
                    if (i < array.length) c = array[i];
                }
//                System.out.println("num的值："+num);
                biaodashi.addLast(new Node(num, ' ', true));
            }
            // 如果是符号
            else {
                if (c == '(') op_stack.addLast(new Node(0, c, false));
                else if (c == ')') {
                    while (!op_stack.isEmpty() && op_stack.peekLast().op != '(') {
                        biaodashi.addLast(op_stack.pollLast());
                    }
                    // 弹出前面的最近的一个'('
                    op_stack.pollLast();
                }
                // +符号，-符号
                else {
                    if (op_stack.size() == 0) op_stack.addLast(new Node(0, c, false));
                    else {
                        // 将前面的操作符全部插入到后缀表达式中
                        while (!op_stack.isEmpty() && op_stack.peekLast().op != '(')
                            biaodashi.addLast(op_stack.pollLast());
                        // 当前的操作符插入
                        op_stack.addLast(new Node(0, c, false));
                    }
                }
                i++;
            }
//            System.out.println("后缀表达式：");
//            StringBuilder sb=new StringBuilder();
//            for(Node n:biaodashi){
//                if(n.if_num) sb.append(n.value);
//                else sb.append(n.op);
//            }
//            System.out.println(sb.toString());
//            System.out.println("操作符栈：");
//            StringBuilder sb2=new StringBuilder();
//            for(Node n:op_stack){
//                if(n.if_num) sb2.append(n.value);
//                else sb2.append(n.op);
//            }
//            System.out.println(sb2.toString());
        }
        // 将栈中剩余的内容全部弹出
        while (!op_stack.isEmpty()) biaodashi.addLast(op_stack.pollLast());

//        // 输出最后得到的后缀表达式
//        StringBuilder sb=new StringBuilder();
//        for(Node n:biaodashi){
//            if(n.if_num) sb.append(n.value);
//            else sb.append(n.op);
//        }
//        System.out.println(sb.toString());

        // 开始计算后缀表达式
        for (int i = 0; i < biaodashi.size(); i++) {
            Node n = biaodashi.get(i);
            if (n.if_num) op_stack.addLast(n);
            else {
                int num2 = op_stack.pollLast().value;
                int num1 = op_stack.pollLast().value;
                int result = 0;
                switch (n.op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    default:
                        break;
                }
                op_stack.addLast(new Node(result, ' ', true));
            }
        }
        // 返回结果
        return op_stack.peekLast().value;
    }

    class Node {
        int value;
        char op;
        boolean if_num;

        public Node() {
            this.value = 0;
            this.op = ' ';
            if_num = true;
        }

        public Node(int value, char op, boolean if_num) {
            this.value = value;
            this.op = op;
            this.if_num = if_num;
        }
    }
}
