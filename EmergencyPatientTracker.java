
import java.time.Instant;
import java.util.PriorityQueue;

class Patient {
    private String name;
    private int severity; // lower number = higher priority
    private long arrivalTime; // timestamp for FIFO ordering

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = Instant.now().toEpochMilli();
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + ", arrivalTime=" + arrivalTime + "}";
    }
}

public class EmergencyPatientTracker {

    private static final int MAX_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>(
            (p1, p2) -> {
                if (p1.getSeverity() != p2.getSeverity()) {
                    return Integer.compare(p1.getSeverity(), p2.getSeverity());
                } else {
                    return Long.compare(p1.getArrivalTime(), p2.getArrivalTime());
                }
            }
        );

        // Sample patients
        addPatient(patientQueue, new Patient("Alice", 3));
        Thread.sleep(10);  // Ensure different arrival times
        addPatient(patientQueue, new Patient("Bob", 1));
        Thread.sleep(10);
        addPatient(patientQueue, new Patient("Charlie", 2));
        Thread.sleep(10);
        addPatient(patientQueue, new Patient("Diana", 1));
        Thread.sleep(10);
        addPatient(patientQueue, new Patient("Eve", 4));
        Thread.sleep(10);

        // Try to add a sixth patient (should not add)
        addPatient(patientQueue, new Patient("Frank", 1));

        System.out.println("\nPatients in queue:");

        while (!patientQueue.isEmpty()) {
            System.out.println("Treating patient: " + patientQueue.poll());
        }
    }

    private static void addPatient(PriorityQueue<Patient> queue, Patient patient) {
        if (queue.size() < MAX_SIZE) {
            queue.offer(patient);
            System.out.println("Added patient: " + patient);
        } else {
            System.out.println("Queue full. Cannot add patient: " + patient.getName());
        }
    }
}
