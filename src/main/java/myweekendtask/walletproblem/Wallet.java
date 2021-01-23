package myweekendtask.walletproblem;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> wallet = new ArrayList<>();

    public void add(Currency currency) {
        wallet.add(currency);
    }

}
