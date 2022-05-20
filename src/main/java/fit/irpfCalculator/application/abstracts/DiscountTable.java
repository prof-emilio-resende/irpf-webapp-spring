package fit.irpfCalculator.application.abstracts;

public interface DiscountTable {
    double getExemptionValue();
    double getDependentsValue(int number);
}
