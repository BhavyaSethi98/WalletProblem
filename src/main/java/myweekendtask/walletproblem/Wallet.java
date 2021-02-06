package myweekendtask.walletproblem;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> wallet = new ArrayList<>();
    private double totalMoney;


    public Wallet() {
        this.totalMoney = 0;
    }

    public void add(Currency currency) throws NotAValidAmountException {
        if (currency.amount < 0) throw new NotAValidAmountException();

        wallet.add(currency);
    }

    public Currency retreive(Currency currencyValue) throws AmountNotPresentInWallet {
        if (totalAmountInWallet() < currencyValue.amount) throw new AmountNotPresentInWallet();

        wallet.remove(currencyValue);
        return currencyValue;
    }

    private Double totalAmountInWallet() {
        for (Currency currency : wallet) {
            this.totalMoney += currency.amount;
        }
        return totalMoney;
    }

    public double sumIn(Currency currencyType) {
        return currencyType.convert(wallet);
    }

}
