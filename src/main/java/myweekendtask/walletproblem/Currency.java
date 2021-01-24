package myweekendtask.walletproblem;

import java.util.List;

public abstract class Currency {

    public final double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    abstract double convert(List<Currency> wallet);
}
