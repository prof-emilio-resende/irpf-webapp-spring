package fit.irpfCalculator.application.factories;

import fit.irpfCalculator.application.abstracts.RateTable;
import fit.irpfCalculator.application.impl.RateTable2021;

public abstract class RateTableFactory {
    public static RateTable build(int year) {
        if (year == 2021) return new RateTable2021();

        return null;
    }
}
