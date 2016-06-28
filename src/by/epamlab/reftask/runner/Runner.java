package by.epamlab.reftask.runner;


import by.epamlab.reftask.beans.Bus;
import by.epamlab.reftask.beans.Van;
import by.epamlab.reftask.factory.ProxyBuildFactory;
import by.epamlab.reftask.ifaces.Reviewable;
import by.epamlab.reftask.utils.VehicleComparator;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

public final class Runner {
    private Runner() { }
    /**
     * Main method
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        Reviewable van = new Van("FORD Galaxy", "for family", 8, 220);
        Reviewable bus = new Bus("FORD Galaxy", "for family", 10, 200);
        Reviewable vehicle = new Van("FORD Transit", "for business", 12, 240);

        try {
            Boolean isEqual = VehicleComparator.equalObjects(van, bus);
            System.out.println(isEqual);
            try {
                ProxyBuildFactory.getInstance(vehicle.getClass());
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
