package myweekendtask.walletproblem;

import java.util.List;

public class Rupee extends Currency {


    private double totalAmount;

    public Rupee(Double ruppeeValue) {
        super(ruppeeValue);
    }

    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Dollars)
                totalAmount += currency.amount * 74.5;
            else
                totalAmount += currency.amount;
        }
        return totalAmount;
    }
}
