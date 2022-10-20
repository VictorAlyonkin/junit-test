import tax.TaxService;
import tax.type.TaxType;

public class Bill {
    private double amount;
    private TaxType taxType;
    private TaxService taxService;

    public Bill(double amount, TaxType taxType, TaxService taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public double payTaxes() {
        // посчитать размер налога
        double taxAmount = taxType.calculateTaxFor(amount);
        //Вывод полученного налога
        taxService.payOut(taxAmount);
        return taxAmount;
    }

    public double getAmount() {
        return amount;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public TaxService getTaxService() {
        return taxService;
    }
}
