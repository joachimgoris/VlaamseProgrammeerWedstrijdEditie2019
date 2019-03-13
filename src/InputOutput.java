import java.util.Scanner;

public class InputOutput {

    public void Read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            String woord = sc.next();

            System.out.println(woord.substring(k - 1, k));
        }
    }
}

