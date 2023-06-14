import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Vklad byl uspěšný. Zůstatek: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Malý zůstatek.");
        } else {
            balance -= amount;
            System.out.println("Výběr úspěšný. Nový zůstatek " + balance);
        }
    }
}

public class Banka {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account account1 = new Account(1, "Adam Suchý", 5000.0);
        Account account2 = new Account(2, "David Cibulka", 10000.0);

        bank.addAccount(account1);
        bank.addAccount(account2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Banka");
            System.out.println("1. Vklad");
            System.out.println("2. Výběr");
            System.out.println("3. Zůstatek");
            System.out.println("4. Exit");
            System.out.print("Výběr: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Zadejte číslo účtu: ");
                int accountNumber = scanner.nextInt();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    System.out.print("Zadejte kolik chcete vložit: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                } else {
                    System.out.println("Účet nebyl nalezen.");
                }
            } else if (choice == 2) {
                System.out.print("Zadejte číslo účtu: ");
                int accountNumber = scanner.nextInt();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    System.out.print("Vyberte kolik chcete vložit: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                } else {
                    System.out.println("Účet nebyl nalezen.");
                }
            } else if (choice == 3) {
                System.out.print("Zadejte číslo účtu: ");
                int accountNumber = scanner.nextInt();
                Account account = bank.findAccount(accountNumber);
                if (account != null) {
                    System.out.println("Majitel účtu: " + account.getAccountHolder());
                    System.out.println("Zůstatek: " + account.getBalance());
                } else {
                    System.out.println("Účet nebyl nalezen.");
                }
            } else if (choice == 4) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Neplatná volba. Prosím zkuste to znovu.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
