
import java.util.LinkedList;
import java.util.Scanner;

public class ReversedTaskQueue {

    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 4 task names:");

        for (int i = 0; i < 4; i++) {
            String task = scanner.nextLine();

            if (task.endsWith("I") || task.endsWith("i")) {
                // Add to the front if ends with 'I' or 'i'
                tasks.addFirst(task);
            } else {
                // Otherwise add to the end
                tasks.addLast(task);
            }
        }

        scanner.close();

        System.out.println("\nTasks in reverse order:");

        // Print the list in reverse order
        for (int i = tasks.size() - 1; i >= 0; i--) {
            System.out.println(tasks.get(i));
        }
    }
}
