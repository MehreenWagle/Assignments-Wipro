
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LastThreeSearches {

    public static void main(String[] args) {
        Deque<String> searchTerms = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter search terms (type 'exit' to stop):");

        while (true) {
            String term = scanner.nextLine();
            if ("exit".equalsIgnoreCase(term)) {
                break;
            }

            if (searchTerms.size() == 3) {
                // Remove oldest term to keep only last 3
                searchTerms.removeFirst();
            }

            // Add the new search term
            searchTerms.addLast(term);

            // Print current last 3 searches
            System.out.println("Last 3 searches: " + searchTerms);
        }

        scanner.close();
    }
}
