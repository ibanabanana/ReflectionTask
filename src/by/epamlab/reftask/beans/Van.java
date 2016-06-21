package by.epamlab.reftask.beans;

import by.epamlab.reftask.annotations.Equal;
import by.epamlab.reftask.ifaces.Reviewable;

/**
 * Created by Andrei Halauneu on 15.06.16.
 */

public class Van implements Reviewable {

    @Equal(compareBy = Equal.CompareBy.REFERENCE)
    private String model;
    @Equal(compareBy = Equal.CompareBy.REFERENCE)
    private String purpose;
    @Equal()
    private int capacity;
    @Equal()
    private int speed;

    /**
     * Default constructor
     */
    public Van() {
    }

    /**
     * Constructor from fields
     * @param model  Vehicle model
     * @param purpose Uses for
     * @param capacity Vehicle max capacity
     * @param speed Vehicle max speed
     */
    public Van(final String model, final String purpose, final int capacity, final int speed) {
        this.model = model;
        this.purpose = purpose;
        this.capacity = capacity;
        this.speed = speed;
    }

    /**
     *  Displays technical information
     */
    @Override
    public void overview() {
        System.out.printf("%s uses for %s, %d features %d.",
                model, purpose, capacity, speed);
    }
}
