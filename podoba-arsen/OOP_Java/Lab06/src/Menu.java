import java.util.Scanner;

public class Menu
{
    private static       Scanner scanner = new Scanner(System.in);
    private static ParelelThread parelelThread = new ParelelThread();
    private static CurrentThread currentThread = new CurrentThread();

    public static void main(String[] args)
    {
        System.out.println("a. Make processing dictionary by one thread");
        System.out.println("b. Make processing dictionary by parallel streams");
        System.out.println("q Quit the program");

        while (true) {
            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    currentThread.startThread();
                    break;
                case "b":
                    System.out.println("Do you want to set limit? y/n");
                    String cho = scanner.nextLine();

                    if(cho.equals("y")) {
                        System.out.println("Enter time in milliseconds");
                        int limit = scanner.nextInt();
                        parelelThread.setmLimit(limit);
                    }
                    parelelThread.startThread();
                    break;
                case "q":
                    System.exit(0);
                    break;
            }
        }
    }
}
