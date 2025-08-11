
import java.util.Stack;

public class UndoStack {

    public static void main(String[] args) {
        Stack<String> commands = new Stack<>();

        // Add three commands
        commands.push("Open File");
        commands.push("Edit Text");
        commands.push("Save File");

        System.out.println("Commands stack: " + commands);

        // Undo one command (pop from stack)
        String undoneCommand = commands.pop();
        System.out.println("Undone command: " + undoneCommand);

        // Reverse the undone command string
        String reversed = new StringBuilder(undoneCommand).reverse().toString();
        System.out.println("Reversed undone command: " + reversed);

        // Re-add reversed command to stack
        commands.push(reversed);
        System.out.println("Commands stack after re-adding reversed command: " + commands);
    }
}


