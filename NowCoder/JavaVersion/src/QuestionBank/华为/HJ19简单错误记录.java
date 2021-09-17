package QuestionBank.华为;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ19简单错误记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> input_list = new ArrayList<>();
        while (sc.hasNext()) {
            input_list.add(sc.nextLine());
        }
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String input : input_list) {
            String[] arr = input.split(" ");
            String[] path = arr[0].split("\\\\");
            String real_path = path[path.length - 1].substring(path[path.length - 1].length() > 16 ? path[path.length - 1].length() - 16 : 0);
            int line_no = Integer.parseInt(arr[1]);
            linkedHashMap.put(real_path + " " + line_no, linkedHashMap.getOrDefault(real_path + " " + line_no, 0) + 1);
        }
        if (linkedHashMap.size() <= 8) {
            for (Map.Entry<String, Integer> item : linkedHashMap.entrySet()) {
                System.out.println(item.getKey() + " " + item.getValue());
            }
        } else {
            int count = 0;
            for (Map.Entry<String, Integer> item : linkedHashMap.entrySet()) {
                if (count >= linkedHashMap.size() - 8) {
                    System.out.println(item.getKey() + " " + item.getValue());
                }
                count++;
            }
        }
    }
}
