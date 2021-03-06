package by.epamlab.reftask.handlers;

import by.epamlab.reftask.ifaces.Reviewable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

public class ProxyHandler implements InvocationHandler {
    private Reviewable vehicle;

    /**
     * Constructor from fields
     * @param vehicle - required object
     */
    public ProxyHandler(final Reviewable vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

        return method.invoke(vehicle, args);
    }
}
