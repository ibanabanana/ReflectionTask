package by.epamlab.reftask.utils;

import java.lang.reflect.Field;
import by.epamlab.reftask.annotations.Equal;

/**
 * Created by Andrei Halauneu on 16.06.16.
 */

public final class VehicleComparator {
    private VehicleComparator() { }
    /**
     * Checks two objects for equality according to their annotations
     * If both objects have equal values in all equal fields, consider objects are equal.
     * If annotations on fields are different - objects are not equal
     *
     * @param object1 first object
     * @param object2 second object
     * @throws IllegalAccessException access failed
     * @return true - if equal, false - if not
     */
    public static boolean equalObjects(final Object object1, final Object object2) throws IllegalAccessException {
        Boolean isEqual = false;
        Class firstClass = object1.getClass();
        Class secondClass = object2.getClass();

        Field[] firstFields = firstClass.getDeclaredFields();
        Field[] secondFields = secondClass.getDeclaredFields();

        for (Field field1 : firstFields) {
            if (!(field1.isAccessible())) {
                field1.setAccessible(true);
            }
            for (Field field2 : secondFields) {
                if (!(field2.isAccessible())) {
                    field2.setAccessible(true);
                }
                if (field1.getName().equals(field2.getName())) {
                    Equal.CompareBy mark1 = field1.getAnnotation(Equal.class).compareBy();
                    Equal.CompareBy mark2 = field2.getAnnotation(Equal.class).compareBy();
                    if (!(mark1 == mark2)) {
                        isEqual = false;
                    }

                    if (mark1.equals(Equal.CompareBy.REFERENCE)) {
                        isEqual = ((field1.get(object1)) == (field2.get(object2)));
                    } else if (mark1.equals(Equal.CompareBy.VALUE)) {
                        isEqual = (field1.get(object1).equals(field2.get(object2)));
                    }
                }
            }
        }
        return isEqual;
    }
}


