
import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {

    private static final LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {

        // Producer thread - adds messages
        Thread producer = new Thread(() -> {
            int messageCount = 1;
            try {
                while (true) {
                    String message = "Message " + messageCount++;

                    // Put message into queue, blocks if queue is full (capacity 5)
                    messageQueue.put(message);
                    System.out.println("Produced: " + message);

                    Thread.sleep(500); // simulate delay between messages
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread - reads messages
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // Take message from queue, blocks if queue is empty
                    String message = messageQueue.take();
                    System.out.println("Consumed: " + message);

                    Thread.sleep(1000); // simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
