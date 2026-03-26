import java.util.Random;

public class Bai2 {
    public static void main(String[] args) {
        int N = 1000000;
        int count = 0;

        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            double x = -1 + 2 * rand.nextDouble(); // [-1, 1]
            double y = -1 + 2 * rand.nextDouble();

            if (x * x + y * y <= 1) {
                count++;
            }
        }

        double pi = (double) count / N * 4;

        System.out.println("Gia tri pi xap xi: " + pi);
    }
}