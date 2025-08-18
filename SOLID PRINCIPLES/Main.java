
// ---------- Single Responsibility Principle ----------
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
}

class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Welcome email sent to: " + user.getEmail());
    }
}

// ---------- Open-Closed Principle ----------
abstract class Payment {
    public abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}

class PayPalPayment extends Payment {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

// ---------- Liskov Substitution Principle ----------
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich {
    public void walk() {
        System.out.println("Ostrich is walking");
    }
}

// ---------- Interface Segregation Principle ----------
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() { System.out.println("Printing..."); }
    public void scan() { System.out.println("Scanning..."); }
    public void fax() { System.out.println("Faxing..."); }
}

class SimplePrinter implements Printer {
    public void print() { System.out.println("Simple printing only."); }
}

// ---------- Dependency Inversion Principle ----------
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to PostgreSQL");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
        System.out.println("App is running");
    }
}

// ---------- Main Class (only one public allowed) ----------
public class Main {
    public static void main(String[] args) {

        // ✅ Test SRP
        System.out.println("\n--- Single Responsibility Principle ---");
        User user = new User("John", "john@example.com");
        new EmailService().sendWelcomeEmail(user);

        // ✅ Test OCP
        System.out.println("\n--- Open-Closed Principle ---");
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(new CreditCardPayment(), 100);
        processor.processPayment(new PayPalPayment(), 200);

        // ✅ Test LSP
        System.out.println("\n--- Liskov Substitution Principle ---");
        Flyable bird = new Sparrow();
        bird.fly();
        new Ostrich().walk();

        // ✅ Test ISP
        System.out.println("\n--- Interface Segregation Principle ---");
        Printer multi = new MultiFunctionPrinter();
        multi.print();
        Printer simple = new SimplePrinter();
        simple.print();

        // ✅ Test DIP
        System.out.println("\n--- Dependency Inversion Principle ---");
        Application app1 = new Application(new MySQLDatabase());
        app1.start();
        Application app2 = new Application(new PostgreSQLDatabase());
        app2.start();
    }
}
