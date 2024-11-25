import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
    String name;
    ArrayList<TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class StudentListManager {
    private static TreeNode root = new TreeNode("Students");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student List Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addStudent(scanner);
            } else if (choice == 2) {
                viewStudents(root, 0);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter year (e.g., 1st Year): ");
        String year = scanner.nextLine();
        System.out.print("Enter section (e.g., Section A): ");
        String section = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        TreeNode yearNode = findOrCreateNode(root, year);
        TreeNode sectionNode = findOrCreateNode(yearNode, section);
        sectionNode.children.add(new TreeNode(studentName));

        System.out.println("Student added successfully!");
    }

    private static void viewStudents(TreeNode node, int level) {
        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println("- " + node.name);
        for (TreeNode child : node.children) {
            viewStudents(child, level + 1);
        }
    }

    private static TreeNode findOrCreateNode(TreeNode parent, String name) {
        for (TreeNode child : parent.children) {
            if (child.name.equals(name)) return child;
        }
        TreeNode newNode = new TreeNode(name);
        parent.children.add(newNode);
        return newNode;
    }
}
