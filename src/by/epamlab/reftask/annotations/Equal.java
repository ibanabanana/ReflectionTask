package by.epamlab.reftask.annotations;

import java.lang.annotation.*;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Equal {
    /**
     * Equality analyzer description
     */
    enum CompareBy {
        REFERENCE, VALUE
    }

    /**
     * @Equal fields to check for equality
     * @return  comparing options
     */
    CompareBy compareBy () default CompareBy.VALUE;
}
