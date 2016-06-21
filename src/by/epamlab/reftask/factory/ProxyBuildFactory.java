package by.epamlab.reftask.factory;

import by.epamlab.reftask.annotations.*;
import by.epamlab.reftask.ifaces.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;


/**
 * Created by Andrei Halauneu on 16.06.2016.
 */
public final class ProxyBuildFactory {

    private ProxyBuildFactory() {
    }

    /**
     * Checks required class for @Proxy annotation, define either Proxy object or instance should be created,
     * makes it and return.
     *
     * @param clazz - reference for what the method should returned the instance
     * @return returned Proxy object (if annotation @Proxy presents) or simple instance of suited class
     * @throws IllegalAccessException IllegalAccessException
     * @throws InstantiationException   InstantiationException
     * @throws NoSuchMethodException    NoSuchMethodException
     * @throws InvocationTargetException    InvocationTargetException
     */
    public static Reviewable getInstance(final Class<? extends Reviewable> clazz) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        Reviewable newInstance = clazz.getConstructor().newInstance();

        if (clazz.isAnnotationPresent(Proxy.class)) {
            Proxy mark = clazz.getAnnotation(Proxy.class);
            InvocationHandler handler;
            handler = mark.invocationHandler().getDeclaredConstructor(Reviewable.class).newInstance(newInstance);
            newInstance = (Reviewable) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),
                    new Class[]{Reviewable.class}, handler);
        }
        System.out.println("Proxy set");
        return newInstance;
    }
}