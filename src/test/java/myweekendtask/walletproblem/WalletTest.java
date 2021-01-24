package myweekendtask.walletproblem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    void shouldNotThrowExceptionForPuttingMoneyInWallet() {
        Currency currencyValue = new Currency(20);
        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.add(currencyValue));
    }

    @Test
    void shouldThrowExceptionIfValidAmountIsNotAdded() {
        Currency currencyValue = new Currency(-20);
        Wallet wallet = new Wallet();

        assertThrows(NotAValidAmountException.class, () -> wallet.add(currencyValue));
    }

    @Test
    void shouldNotThrowExceptionIfAmountIsRetreived() throws NotAValidAmountException {
        Currency currencyValue = new Currency(20);
        Wallet wallet = new Wallet();

        wallet.add(currencyValue);

        assertDoesNotThrow(() -> wallet.retreive(currencyValue));
    }

    @Test
    void shouldThrowExceptionIfAmountIsRetreivedFromEmptyWallet() throws NotAValidAmountException {
        Currency currency1 = new Currency(20);
        Currency currency2 = new Currency(10);
        Wallet wallet = new Wallet();

        wallet.add(currency2);

        assertThrows(AmountNotPresentInWallet.class, () -> wallet.retreive(currency1));
    }
}
