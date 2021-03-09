import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long P = sc.nextLong();
            long n;
            for (n = 1; ; n++) {
                long result = n * (n + 1) * (2 * n + 1) / 6;
                if (result > P) break;
            }
            System.out.println(n - 1);
        }
    }
}
