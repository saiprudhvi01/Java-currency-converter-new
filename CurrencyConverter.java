import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Define a map to hold conversion rates
    private static final Map<String, Double> conversionRates = new HashMap<>();
    
    static {
        // Populate the conversion rates
        conversionRates.put("USD_EUR", 0.93);
        conversionRates.put("EUR_USD", 1.08);
        conversionRates.put("USD_GBP", 0.75);
        conversionRates.put("GBP_USD", 1.33);
        conversionRates.put("EUR_GBP", 0.81);
        conversionRates.put("GBP_EUR", 1.23);
        // Add more currencies and their rates as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("Available currencies: USD, EUR, GBP");
        System.out.println("Convert from which currency? (USD, EUR, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.println("Convert to which currency? (USD, EUR, GBP): ");
        String toCurrency = scanner.next().toUpperCase();

        String key = fromCurrency + "_" + toCurrency;
        Double conversionRate = conversionRates.get(key);

        if (conversionRate == null) {
            System.out.println("Conversion rate not available.");
            return;
        }

        System.out.print("Enter amount in " + fromCurrency + ": ");
        double amount = scanner.nextDouble();

        double convertedAmount = amount * conversionRate;

        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, toCurrency);
    }
}
