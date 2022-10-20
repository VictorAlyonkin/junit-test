package tax.type;

public class ProgressiveTaxType extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        return amount * ((amount < 100_000) ? 0.1 : 0.15);
    }
}