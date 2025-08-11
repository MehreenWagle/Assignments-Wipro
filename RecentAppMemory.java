
import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {

    public static void main(String[] args) {
        LinkedList<String> openApps = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 app names as they are opened:");

        for (int i = 0; i < 5; i++) {
            String app = scanner.nextLine();

            // If app is already open, remove it first
            if (openApps.contains(app)) {
                openApps.remove(app);
            }
            // Add the app to the top (front) of the list
            openApps.addFirst(app);
        }

        scanner.close();

        System.out.println("\nFinal list of open apps (most recent first):");
        for (String app : openApps) {
            System.out.println(app);
        }
    }
}

