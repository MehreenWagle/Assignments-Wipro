
import java.util.concurrent.LinkedBlockingQueue;

public class StageBasedTaskRunner {

    static class Task {
        private int id;
        private String description;

        public Task(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Task{id=" + id + ", description='" + description + "'}";
        }
    }

    private static final LinkedBlockingQueue<Task> stage1Queue = new LinkedBlockingQueue<>();
    private static final LinkedBlockingQueue<Task> stage2Queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        // Add sample tasks to Stage 1 queue
        for (int i = 1; i <= 6; i++) {
            stage1Queue.put(new Task(i, "Task number " + i));
        }

        System.out.println("Initial Stage 1 tasks: " + stage1Queue);
        System.out.println("Initial Stage 2 tasks: " + stage2Queue);

        // Process tasks: move only even ID tasks from Stage 1 to Stage 2
        while (!stage1Queue.isEmpty()) {
            Task task = stage1Queue.take();
            System.out.println("Processing " + task);

            if (task.getId() % 2 == 0) {
                stage2Queue.put(task);
                System.out.println("Moved to Stage 2: " + task);
            } else {
                System.out.println("Discarded (odd ID): " + task);
            }
        }

        System.out.println("\nFinal Stage 1 tasks: " + stage1Queue);
        System.out.println("Final Stage 2 tasks: " + stage2Queue);
    }
}
