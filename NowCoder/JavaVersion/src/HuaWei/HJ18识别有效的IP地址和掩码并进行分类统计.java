package HuaWei;

import java.util.LinkedList;
import java.util.Scanner;

public class HJ18识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> input = new LinkedList<>();
        while (sc.hasNext()) {
            input.addLast(sc.nextLine());
        }
        int num_A = 0, num_B = 0, num_C = 0, num_D = 0, num_E = 0, num_error = 0, num_pri = 0;
        long As = 1000000000L, Ae = 126255255255L, Bs = 128000000000L, Be = 191255255255L;
        long Cs = 192000000000L, Ce = 223255255255L, Ds = 224000000000L, De = 239255255255L;
        long Es = 240000000000L, Ee = 255255255255L;
        long pri1s = 10000000000L, pri1e = 10255255255L, pri2s = 172160000000L, pri2e = 172310255255L, pri3s = 192168000000L, pri3e = 192168255255L;

        for (String item : input) {
            String[] arr = item.split("~");
            String ip = arr[0];
            String netmask = arr[1];
            if (!checkIpAddr(ip) || !checkNetmask(netmask)) {
                num_error++;
                continue;
            }
            // 将ip地址转换为long表达的数字
            String[] ip_arr = ip.split("\\.");
            long ip_num = Long.parseLong(ip_arr[0]) * 1000000000 +
                    Long.parseLong(ip_arr[1]) * 1000000 +
                    Long.parseLong(ip_arr[2]) * 1000 +
                    Long.parseLong(ip_arr[3]);
            if (ip_num >= As && ip_num <= Ae) {
                num_A++;
            } else if (ip_num >= Bs && ip_num <= Be) {
                num_B++;
            } else if (ip_num >= Cs && ip_num <= Ce) {
                num_C++;
            } else if (ip_num >= Ds && ip_num <= De) {
                num_D++;
            } else if (ip_num >= Es && ip_num <= Ee) {
                num_E++;
            }
            if ((ip_num >= pri1s && ip_num <= pri1e) || (ip_num >= pri2s && ip_num <= pri2e) || (ip_num >= pri3s && ip_num <= pri3e)) {
                num_pri++;
            }
        }
        System.out.printf("%s %s %s %s %s %s %s\n", num_A, num_B, num_C, num_D, num_E, num_error, num_pri);
    }

    static boolean checkIpAddr(String ipaddr) {
        String[] arr = ipaddr.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (String s : arr) {
            if (s.equals("")) {
                return false;
            }
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }

    static boolean checkNetmask(String netmask) {
        String[] arr = netmask.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (String s : arr) {
            if (s.equals("")) {
                return false;
            }
        }
        int[] result = new int[32];
        int pos = 0;
        for (int i = 3; i >= 0; i--) {
            int value = Integer.parseInt(arr[i]);
            if (value < 0 || value > 255) {
                return false;
            }
            for (int j = 0; j < 8; j++) {
                result[pos++] = ((value >> j) & 1) == 1 ? 1 : 0;
            }
        }
        boolean flag = false;
        int sum = 0;
        for (int bit : result) {
            sum += bit;
            if (bit == 1 && !flag) {
                flag = true;
            } else if (bit == 0 && flag) {
                return false;
            }
        }
        return sum != 0 && sum != 32;
    }
}
