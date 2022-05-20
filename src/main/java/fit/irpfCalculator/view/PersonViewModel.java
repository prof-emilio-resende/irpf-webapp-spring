package fit.irpfCalculator.view;

import fit.irpfCalculator.domain.Person;

public class PersonViewModel extends Person {
    public PersonViewModel() {
        super(0, 0);
    }

    public PersonViewModel(double salary, int dependents) {
        super(salary, dependents);
    }
}
