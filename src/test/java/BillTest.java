import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tax.TaxService;
import tax.type.IncomeTaxType;
import tax.type.TaxType;

public class BillTest {
    private Bill sut;
    private TaxService taxService = new TaxService();

    @AfterEach
    public void after() {
        sut = null;
    }

    @Test
    public void billWithValues() {
        double expectedAmount = 1_000;
        sut = new Bill(1_000, new TaxType(), taxService);
        Assertions.assertEquals(expectedAmount, sut.getAmount());
    }

    @Test
    public void billWithTaxType() {
        double expected = 0;
        sut = new Bill(1000, new TaxType(), taxService);
        double result = sut.payTaxes();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void billWithIncomeTaxType() {
        double expected = 130;
        sut = new Bill(1000, new IncomeTaxType(), taxService);
        double result = sut.payTaxes();
        Assertions.assertEquals(expected, result);
    }
}
