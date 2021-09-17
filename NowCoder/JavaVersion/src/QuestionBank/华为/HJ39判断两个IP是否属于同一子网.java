package QuestionBank.华为;

import java.util.Scanner;

public class HJ39判断两个IP是否属于同一子网 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String netmask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            // 检查三个地址是否合法
            if (!checkNetmaskAddress(netmask) || !checkIPAddress(ip1) || !checkIPAddress(ip2)) {
                System.out.println(1);
                continue;
            }
            // 检查是否在同一子网
            String ip1_result = parseNetmask(netmask, ip1);
            String ip2_result = parseNetmask(netmask, ip2);
            System.out.println(ip1_result.equals(ip2_result) ? "0" : "2");
        }
    }

    static boolean checkNetmaskAddress(String addr) {
        String[] str_array = addr.split("\\.");
        int[] arr = new int[32];
        int pos = 0;
        for (int i = 3; i >= 0; i--) {
            int value = Integer.parseInt(str_array[i]);
            if (value < 0 || value > 255) {
                return false;
            }
            for (int j = 0; j < 8; j++) {
                arr[pos++] = ((value >> j) & 1) == 1 ? 1 : 0;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if (arr[i] == 1 && !flag) {
                flag = true;
            } else if (arr[i] == 0 && flag) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIPAddress(String addr) {
        String[] str_array = addr.split("\\.");
        for (String item : str_array) {
            int value = Integer.parseInt(item);
            if (value < 0 || value > 255) {
                return false;
            }
        }
        return true;
    }

    static String parseNetmask(String netmask, String ip_addr) {
        String[] netmask_array = netmask.split("\\.");
        String[] ip_array = ip_addr.split("\\.");
        String[] result = new String[4];
        for (int i = 0; i < 4; i++) {
            int net_value = Integer.parseInt(netmask_array[i]);
            int ip_value = Integer.parseInt(ip_array[i]);
            result[i] = String.valueOf(net_value & ip_value);
        }
        return String.join(".", result);
    }
}
