public class USWallet implements MoneySystem{
    double money;

    public double getBalance() {
        return money;
    }

    public void withdrawal(double amount) {
        if(amount < money){
            money -= amount;
            System.out.println("You withdrew: " + amount);
        }
        else{
            System.out.println("You don't have enough funds");
        }
    }

    public void deposit(double amount) {
        money+=amount;
    }
}
