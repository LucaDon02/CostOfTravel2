package nl.hhs.webapp.demo.model.vehicle;

import javax.persistence.Entity;

@Entity( name = "car" )
public class Car extends Vehicle {

    public final String MODEL;


    public Car( String model ) {
        MODEL = model;
    }

    public Car() { this( null );}

}
