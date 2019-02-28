import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BitWallet b = new BitWallet();
        b.deposit(20);
        MoneySystem adapter = new BitcoinAdapter(b);

        while(true)
        {
            doAction(openMenu(), adapter, b);
        }
    }

    public static int openMenu() {
        boolean Done = false;
        int choice=0;
        while(!Done) {
            System.out.println("\n[Welcome to USD - Bitcoin Wallet]\n>>> Press 0 to CLOSE <<<\n\n " +
                    "\t1. Get Balance in USD\n" +
                    "\t2. Get Balance in Bitcoin\n" +
                    "\t3. Withdraw USD\n" +
                    "\t4. Withdraw Bitcoin\n" +
                    "\t5. Deposit USD\n" +
                    "\t6. Deposit Bitcoin\n" +
                    "\t7. Check Bitcoin Transactions");

            System.out.printf("\n>What do you want to do?: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice > 0 && choice <= 7) {
                Done = true;
            }
            else{
                System.out.println(" > [ Enter a valid number! ]");
            }
        }

        return (choice);
    }


    private static void doAction(int choice, MoneySystem adapter, BitWallet bitWallet ) {
        switch (choice){
            case 0:{
                System.exit(0);
            }
            case 1:{
                System.out.printf("%s %.2f", "Your balance is $", adapter.getBalance());
                break;
            }
            case 2:{
                System.out.printf("%s %.8f %s", "Your balance is ", bitWallet.getBalance()," BTC");
                break;
            }
            case 3:{
                System.out.printf(">You currently have: [$"+adapter.getBalance()+"]\n>>How much do you want to withdraw? $");
                Scanner input = new Scanner(System.in);
                double amount = input.nextDouble();
                boolean Done = false;
                while(!Done) {
                    if (amount > 0 && amount <= adapter.getBalance()) {
                        adapter.withdrawal(amount);
                        System.out.printf("%s %.2f","You withdrew $", amount);
                        Done = true;
                    } else {
                        System.out.println(" > [ Enter a valid number! ]");
                        break;
                    }
                }
                break;
            }
            case 4:{
                System.out.printf(">You currently have: ["+bitWallet.getBalance()+" BTC]\n>>How much do you want to withdraw? BTC:");
                Scanner input = new Scanner(System.in);
                double amount = input.nextDouble();
                boolean Done = false;
                while(!Done) {
                    if (amount > 0 && amount <= bitWallet.getBalance()) {
                        bitWallet.withdrawal(amount);
                        System.out.printf("%s %.8f %s" ,"You withdrew " , amount , " BTC");
                        Done = true;
                    } else {
                        System.out.println(" > [ Enter a valid number! ]");
                        break;
                    }
                }
                break;
            }
            case 5:{
                System.out.printf(">How much do you want to deposit?: $");
                Scanner input = new Scanner(System.in);
                double amount = input.nextDouble();
                boolean Done = false;
                while(!Done) {
                    if (amount > 0) {
                        adapter.deposit(amount);
                        System.out.printf("%s %.2f","You deposited $", amount);
                        Done = true;
                    } else {
                        System.out.println(" > [ Enter a valid number! ]");
                    }
                }
                break;
            }

            case 6:{
                System.out.printf(">How much do you want to deposit?: BTC:");
                Scanner input = new Scanner(System.in);
                double amount = input.nextDouble();
                boolean Done = false;
                while(!Done) {
                    if (amount > 0) {
                        bitWallet.deposit(amount);
                        System.out.printf("%s %.8f %s","You deposited ", amount, " BTC");
                        Done = true;
                    } else {
                        System.out.println(" > [ Enter a valid number! ]");
                    }
                }
                break;
            }

            case 7:{
                bitWallet.getTransactionRecord();
                break;
            }

        }
    }
}
