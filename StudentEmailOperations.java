import java.util.Scanner;

public class StudentEmailOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.print("Enter student's email address: ");
        String rawEmail = scanner.nextLine();

        String trimmedEmail = rawEmail.trim();
        System.out.println("\n--- String Operations Results ---");
        System.out.println("9. Trimmed Email: \"" + trimmedEmail + "\"");

        int length = trimmedEmail.length();
        System.out.println("1. Length of Email Address: " + length);

        int atIndex = trimmedEmail.indexOf('@');
        if (atIndex > 0 && atIndex < trimmedEmail.length() - 1) {
        
            String username = trimmedEmail.substring(0, atIndex);
            System.out.println("2. Extracted Username: " + username);
            String domain = trimmedEmail.substring(atIndex + 1);
            System.out.println("3. Extracted Domain: " + domain);
            if (domain.equalsIgnoreCase("bmsce.ac.in")) {
                System.out.println("   -> Verification: Valid BMSCE institutional email.");
            } else {
                System.out.println("   -> Verification: Does NOT belong to bmsce.ac.in.");
            }
        } else {
            System.out.println("2 & 3. Invalid email format (missing or misplaced '@').");
        }

        String lowerEmail = trimmedEmail.toLowerCase();
        System.out.println("4. Lowercase Email: " + lowerEmail);

        System.out.print("\nEnter prefix to check (e.g., registration number like 1bm23cs): ");
        String prefix = scanner.nextLine().trim();
        if (lowerEmail.startsWith(prefix.toLowerCase())) {
            System.out.println("5. Prefix Check: Email starts with \"" + prefix + "\".");
        } else {
            System.out.println("5. Prefix Check: Email does NOT start with \"" + prefix + "\".");
        }

        boolean endsWithDomain = lowerEmail.endsWith("bmsce.ac.in");
        System.out.println("6. Ends with \"bmsce.ac.in\": " + endsWithDomain);

     
        String updatedEmail = lowerEmail.replace("bmsce.ac.in", "cse.bmsce.ac.in");
        System.out.println("7. Updated Department Email: " + updatedEmail);

        System.out.print("\nEnter sequence/character to search (e.g., cse or 2025): ");
        String searchSeq = scanner.nextLine().trim();
        boolean containsSeq = lowerEmail.contains(searchSeq.toLowerCase());
        System.out.println("8. Contains \"" + searchSeq + "\": " + containsSeq);

        System.out.print("\nEnter a second email address to compare: ");
        String secondEmail = scanner.nextLine().trim();
        if (trimmedEmail.equalsIgnoreCase(secondEmail)) {
            System.out.println("10. Comparison Result: Both email addresses are identical (ignoring case).");
        } else {
            System.out.println("10. Comparison Result: The email addresses are different.");
        }

        scanner.close();
    }
}
