package myweekendtask.walletproblem;

public class NotAValidAmountException extends Exception {
    public NotAValidAmountException() {
        super("Not A Valid Amount");
    }
}
