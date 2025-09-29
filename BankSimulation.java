import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Task 5: Bank Account Simulation
 * * Objective: Simulate basic bank operations using Java OOP.
 * This class represents a single bank account, managing its balance and transaction history.
 */
class Account {
    // Private fields for encapsulation. Direct access is prevented, forcing interaction
    // through public methods (deposit, withdraw, getBalance).
    private double balance;
    private final String accountNumber;
    private final List<String> transactionHistory;

    // Decimal formatter for consistent currency display
    private static final DecimalFormat df = new DecimalFormat("0.00");
    // Date/Time formatter for transaction timestamps
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor to create a new Account.
     * @param accountNumber The unique identifier for the account.
     * @param initialDeposit The starting balance for the account.
     */
    public Account(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        // Immediately deposit the initial amount
        deposit(initialDeposit, "Initial Deposit"); 
        System.out.println("✅ New account created: " + accountNumber + " with initial balance: $" + df.format(this.balance));
    }

    /**
     * Helper method to record a transaction in the history list.
     * @param type The type of transaction (e.g., "DEPOSIT", "WITHDRAWAL").
     * @param amount The amount involved in the transaction.
     */
    private void recordTransaction(String type, double amount) {
        String timestamp = dtf.format(LocalDateTime.now());
        String entry = String.format("[%s] %-10s: $%-10s | New Balance: $%s", 
                                     timestamp, 
                                     type, 
                                     df.format(amount), 
                                     df.format(this.balance));
        transactionHistory.add(entry);
    }
    
    /**
     * Adds funds to the account balance.
     * @param amount The amount to deposit. Must be positive.
     */
    public void deposit(double amount) {
        deposit(amount, "Standard Deposit");
    }

    /**
     * Adds funds to the account balance, allowing for a custom description (used internally for the initial deposit).
     * @param amount The amount to deposit. Must be positive.
     * @param description The description for the transaction history.
     */
    private void deposit(double amount, String description) {
        if (amount <= 0) {
            System.err.println("❌ Deposit failed: Amount must be positive.");
            return;
        }
        
        this.balance += amount;
        recordTransaction("DEPOSIT", amount);
        System.out.println("💰 Successfully deposited $" + df.format(amount) + ". Current Balance: $" + df.format(this.balance));
    }

    /**
     * Subtracts funds from the account balance if sufficient funds are available.
     * @param amount The amount to withdraw. Must be positive.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.err.println("❌ Withdrawal failed: Amount must be positive.");
            return;
        }

        if (this.balance >= amount) {
            this.balance -= amount;
            recordTransaction("WITHDRAWAL", amount);
            System.out.println("💸 Successfully withdrew $" + df.format(amount) + ". Current Balance: $" + df.format(this.balance));
        } else {
            System.err.println("🛑 Withdrawal failed: Insufficient funds. Requested: $" + df.format(amount) + ", Available: $" + df.format(this.balance));
        }
    }

    /**
     * Gets the current balance of the account.
     * @return The current account balance.
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Prints the entire history of transactions for this account.
     */
    public void printHistory() {
        System.out.println("\n--- TRANSACTION HISTORY for Account " + this.accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("--- END OF HISTORY ---");
    }
}

/**
 * Main class to simulate the bank operations.
 * Demonstrates how to check balance, deposit, and withdraw.
 */
public class BankSimulation {
    public static void main(String[] args) {
        System.out.println("--- Starting Bank Account Simulation ---");

        // Create a new account with an initial deposit of $1000.00
        Account myAccount = new Account("S-987654321", 1000.00);

        // --- 1. CHECK BALANCE ---
        System.out.println("\n--- ACTION: Check Balance (Initial) ---");
        // We call the getBalance() method to retrieve the current balance
        System.out.println("Current Balance: $" + new DecimalFormat("0.00").format(myAccount.getBalance()));


        // --- 2. DEPOSIT ---
        double depositAmount = 250.50;
        System.out.println("\n--- ACTION: Deposit $" + depositAmount + " ---");
        // We call the deposit() method to add funds
        myAccount.deposit(depositAmount);
        
        // --- CHECK BALANCE after deposit ---
        System.out.println("\n--- CHECK: Balance after Deposit ---");
        System.out.println("Current Balance: $" + new DecimalFormat("0.00").format(myAccount.getBalance()));


        // --- 3. WITHDRAW ---
        double withdrawalAmount = 125.00;
        System.out.println("\n--- ACTION: Withdraw $" + withdrawalAmount + " ---");
        // We call the withdraw() method to remove funds
        myAccount.withdraw(withdrawalAmount);

        // --- CHECK BALANCE after withdrawal ---
        System.out.println("\n--- CHECK: Balance after Withdrawal ---");
        System.out.println("Current Balance: $" + new DecimalFormat("0.00").format(myAccount.getBalance()));
        
        
        // --- 4. TRANSACTION HISTORY (Optional, but useful for verification) ---
        myAccount.printHistory();
        
        System.out.println("\n--- Simulation Complete ---");
    }
}
