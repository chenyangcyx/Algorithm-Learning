package Contest1;

import java.util.Scanner;

public class No1_8 {
    public void No1_8() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int result = 1;
            for (int i = 1; i <= B; i++) {
                result = (result * A) % C;
            }
            System.out.println(result);
        }
    }
}
