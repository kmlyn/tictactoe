import java.util.Scanner;

public class UserDialogs {
    public static Coords getCoords() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter coords:");
            String s = scanner.nextLine();
            try {
                int x = Integer.parseInt(s.substring(0, 1));
                int y = Integer.parseInt(s.substring(1, 2));
                if (x >= 0 && x <= 2 && y >= 0 && y <= 2)
                    return new Coords(x, y);
            } catch (Exception e) {

            }
            System.out.println("Wrong data. Try again");
        }
    }
}
