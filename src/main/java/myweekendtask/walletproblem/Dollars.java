package myweekendtask.walletproblem;

import java.util.List;

public class Dollars extends  Currency{

    private double totalAmount;

    public Dollars(Double dollarValue) {
        super(dollarValue);
    }
    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Rupee)
                totalAmount += currency.amount / 74.5;
            else
                totalAmount += currency.amount;
        }
        return totalAmount;
    }
}
