import java.util.HashMap;
import java.util.Map;

/**
 * @author Hang Xu
 */

public enum Currency {
    USD(1.0),
    EURO(1.2),
    CNY(7.0);

    public final double exchangeRate;
    private static final Map<Currency, Double> EXCHANGE_RATE = new HashMap<>();
    static {
        for (Currency c: values()) {
            EXCHANGE_RATE.put(c, c.exchangeRate);
        }
    }

    Currency(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
