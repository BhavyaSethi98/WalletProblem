package myweekendtask.walletproblem;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> wallet = new ArrayList<>();
    private double totalAmount;


    public Wallet() {
        this.totalAmount = 0;
    }

    public void add(Currency currency) throws NotAValidAmountException {
        if (currency.amount <= 0) throw new NotAValidAmountException("Not A Valid Amount");

        wallet.add(currency);
    }

    public void retreive(Currency currencyValue) throws AmountNotPresentInWallet {
        if (totalAmountInWallet() < currencyValue.amount) throw new AmountNotPresentInWallet("Amount not in wallet");

        wallet.remove(currencyValue);
    }

    private Double totalAmountInWallet() {
        for (Currency currency : wallet) {
            this.totalAmount += currency.amount;
        }
        return totalAmount;
    }

    public double sumIn(Currency currencyType) {
        return currencyType.convert(wallet);
    }

}
