
import java.util.PriorityQueue;
import java.util.Scanner;

class Job {
    String name;
    int urgency;  // 1 (most urgent) to 5 (least urgent)

    public Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "Job{name='" + name + "', urgency=" + urgency + "}";
    }
}

public class SmartJobPicker {

    public static void main(String[] args) {
        // Comparator: first by urgency ascending, then by name length ascending
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((j1, j2) -> {
            if (j1.urgency != j2.urgency) {
                return Integer.compare(j1.urgency, j2.urgency);
            } else {
                return Integer.compare(j1.name.length(), j2.name.length());
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of jobs to add:");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter job name:");
            String name = scanner.nextLine();

            System.out.println("Enter urgency (1 to 5):");
            int urgency = scanner.nextInt();
            scanner.nextLine();  // consume newline

            jobQueue.offer(new Job(name, urgency));
        }

        scanner.close();

        System.out.println("\nJobs in order of picking:");
        while (!jobQueue.isEmpty()) {
            System.out.println(jobQueue.poll());
        }
    }
}
