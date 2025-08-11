
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LimitedChatHistory {

    public static void main(String[] args) {
        Deque<String> chatHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter chat messages (type 'exit' to stop):");

        while (true) {
            String message = scanner.nextLine();
            if ("exit".equalsIgnoreCase(message)) {
                break;
            }

            // If chat history is full, remove oldest message
            if (chatHistory.size() == 4) {
                chatHistory.removeFirst();
            }

            // Add new message
            chatHistory.addLast(message);

            // Show current chat history
            System.out.println("Current chat history: " + chatHistory);
        }

        scanner.close();
    }
}
