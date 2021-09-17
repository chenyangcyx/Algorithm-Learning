package QuestionBank.华为;

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class HJ82将真分数分解为埃及分数 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String input = sc.nextLine();
//            String[] sp = input.split("/");
//            int a = Integer.parseInt(sp[0]);
//            int b = Integer.parseInt(sp[1]);
//            ArrayList<String> output = new ArrayList<>();
//            if (a == 1) {
//                System.out.println("1/" + b);
//            } else if (a > 1 && b % a == 0) {
//                System.out.println("1/" + b / a);
//            } else {
//                while (true) {
//                    int q = b / a;
//                    int r = b % a;
//                    output.add("1/" + (q + 1));
//                    a = a - r;
//                    b = b * (q + 1);
//                    if (a == 1) {
//                        output.add("1/" + b);
//                        break;
//                    }
//                }
//            }
//            System.out.println(String.join("+", output));
//        }
//    }
//}


/**
 数学家斐波那契提出的一种求解***分数的贪心算法，准确的算法表述应该是这样的：
 设某个真分数的分子为a，分母为b;
 把c=(b/a+1)作为分解式中第一个***分数的分母；
 将a-b%a作为新的a；
 将b*c作为新的b；
 如果a等于1，则最后一个***分数为1/b,算法结束；
 如果a大于1但是a能整除b，则最后一个***分数为1/(b/a),算法结束；
 否则重复上面的步骤。
 **/
import java.util.*;
public class HJ82将真分数分解为埃及分数{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String res = "";
            String[] arr = in.nextLine().split("/");
            String pre = "";
            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);
            while (true){
                int c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}