package nl.hhs.webapp.demo.model.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public abstract class Vehicle {

    @Id
    @GeneratedValue( strategy = AUTO )
    private long Id;
    private double _costPerKM;

    public double getCostPerKM() {
        return _costPerKM;
    }

    public void setCostPerKM( double costPerKM ) {
        _costPerKM = costPerKM;
    }
}
