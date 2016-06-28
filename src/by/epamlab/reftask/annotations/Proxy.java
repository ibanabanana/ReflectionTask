package by.epamlab.reftask.annotations;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Proxy {
    /**
     * Suitability for proxy creation
     * @return invocationHandler - suitable object of InvocationHandler type.
     */
    Class<? extends InvocationHandler> invocationHandler ();

}
