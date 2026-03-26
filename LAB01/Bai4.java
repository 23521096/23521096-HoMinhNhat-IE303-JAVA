import java.util.*;

public class Bai4 {
    static int n, k;
    static int[] a;
    static List<Integer> best = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc dòng: "7, 8"
        String line1 = sc.nextLine();
        String[] parts1 = line1.split(",");

        n = Integer.parseInt(parts1[0].trim());
        k = Integer.parseInt(parts1[1].trim());

        // Đọc dòng: "1, 2, 7, 4, 3, 3, 10"
        String line2 = sc.nextLine();
        String[] parts2 = line2.split(",");

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts2[i].trim());
        }

        backtrack(0, 0, new ArrayList<>());

        if (best.isEmpty()) {
            System.out.println("Khong ton tai");
        } else {
            for (int i = 0; i < best.size(); i++) {
                System.out.print(best.get(i));
                if (i < best.size() - 1) System.out.print(",");
            }
        }
    }

    static void backtrack(int index, int sum, List<Integer> current) {
        if (sum == k) {
            if (current.size() > best.size()) {
                best = new ArrayList<>(current);
            }
            return;
        }

        if (index >= n || sum > k) return;

        // Chọn
        current.add(a[index]);
        backtrack(index + 1, sum + a[index], current);

        // Bỏ
        current.remove(current.size() - 1);
        backtrack(index + 1, sum, current);
    }
}