package com.github.glomadrian.grav.util;

/**
 * Utility methods
 *
 * @author manolovn
 */
public class ClassUtil {

    public static <T> T getClassByName(String className, Class<T> classOfT) {
        try {
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.newInstance();
            if (classOfT.isInstance(instance)) {
                return classOfT.cast(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}