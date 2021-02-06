package myweekendtask.walletproblem;

public class AmountNotPresentInWallet extends Exception {
    public AmountNotPresentInWallet() {
        super("Amount not in wallet");
    }
}
