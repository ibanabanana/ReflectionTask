package by.epamlab.reftask.annotations;

import java.lang.annotation.*;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Equal {
    /**
     * Describe options for equality analizer.
     */
    enum CompareBy {
        REFERENCE, VALUE
    }

    /**
     * @Equal should be marked fields, that will be checked for equality
     * @return  Comparing options
     */
    CompareBy compareBy () default CompareBy.VALUE;
}
