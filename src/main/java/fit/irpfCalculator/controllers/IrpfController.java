package fit.irpfCalculator.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.irpfCalculator.core.IrpfCalculator;
import fit.irpfCalculator.domain.Person;
import fit.irpfCalculator.view.PersonViewModel;

@RestController
@RequestMapping("/irpf")
public class IrpfController { 
    // curl -X POST -H 'Content-Type: application/json' -d '{"totalSalary": 5000, "dependentsNumber": 1}' http://localhost:5000/irpf/person
    // curl -X POST -H 'Content-Type: application/json' -d '{"totalSalary": 5000, "dependentsNumber": 1}' https://vast-castle-69333.herokuapp.com/irpf/person
    @PostMapping("/person")
    public Person createPerson(@RequestBody PersonViewModel p) {
        return new Person(p.getTotalSalary(), p.getDependentsNumber());
    }

    // curl -X POST -H 'Content-Type: application/json' -d '{"totalSalary": 5000, "dependentsNumber": 1}' http://localhost:5000/irpf/calculate
    @PostMapping("/calculate")
    public double calculate(@RequestBody PersonViewModel person) {
        var year = Calendar.getInstance().get(Calendar.YEAR) - 1;
        var irpfCalculator = new IrpfCalculator(year, person.getTotalSalary(), person.getDependentsNumber());

        var decimal = BigDecimal.valueOf(irpfCalculator.calculate());
        decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }
}
