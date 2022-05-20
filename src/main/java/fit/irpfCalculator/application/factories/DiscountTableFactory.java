package fit.irpfCalculator.application.factories;

import fit.irpfCalculator.application.abstracts.DiscountTable;
import fit.irpfCalculator.application.impl.DiscountTable2021;

public abstract class DiscountTableFactory {
    public static DiscountTable build(int year) {
        if (year == 2021) return new DiscountTable2021();

        return null;
    }
}
