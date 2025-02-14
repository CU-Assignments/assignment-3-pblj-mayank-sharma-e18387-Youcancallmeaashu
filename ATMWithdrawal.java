import java.util.Scanner;
public class ATMWithdrawal {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter PIN: ");
            int pin = Integer.parseInt(scanner.nextLine());
            if (pin != CORRECT_PIN) {
                throw new SecurityException("Error: Invalid PIN.");
            }            
            System.out.print("Withdraw Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount > balance) {
                throw new IllegalArgumentException("Error: Insufficient balance.");
            }            
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
