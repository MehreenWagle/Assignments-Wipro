
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> printQueue = new ArrayBlockingQueue<>(3);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter print job names (type 'done' to finish):");

        while (true) {
            String job = scanner.nextLine();
            if ("done".equalsIgnoreCase(job)) {
                break;
            }

            // Try to add job; if queue full, skip it
            boolean added = printQueue.offer(job);
            if (added) {
                System.out.println("Added print job: " + job);
            } else {
                System.out.println("Queue full. Skipping job: " + job);
            }
        }

        scanner.close();

        System.out.println("\nPrinting jobs one by one:");

        while (!printQueue.isEmpty()) {
            String job = printQueue.take();  // take blocks, but here queue is not empty so fine
            System.out.println("Printing: " + job);

            // Simulate printing time (optional)
            Thread.sleep(500);
        }

        System.out.println("All print jobs completed.");
    }
}
