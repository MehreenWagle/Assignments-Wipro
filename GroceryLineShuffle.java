
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GroceryLineShuffle {

    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter names of customers (type 'done' to finish):");
            
            while (true) {
                String name = sc.nextLine();
                if ("done".equalsIgnoreCase(name)) {
                    break;
                }
                
                if (name.length() % 2 == 0) {
                    // Even length: add to front
                    queue.addFirst(name);
                } else {
                    // Odd length: add to end
                    queue.addLast(name);
                }
            }
        }

        System.out.println("\nServing customers in order:");

        while (!queue.isEmpty()) {
            System.out.println(queue.pollFirst());
        }
    }
}
