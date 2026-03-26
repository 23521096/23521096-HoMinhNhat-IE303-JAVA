import java.util.Random;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ban kinh r: ");
        double r = sc.nextDouble();

        int N = 1000000;
        int count = 0;

        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            double x = -r + 2 * r * rand.nextDouble(); // [-r, r]
            double y = -r + 2 * r * rand.nextDouble();

            if (x * x + y * y <= r * r) {
                count++;
            }
        }

        double dienTich = (double) count / N * (2 * r) * (2 * r);

        System.out.println("Dien tich xap xi: " + dienTich);
    }
}