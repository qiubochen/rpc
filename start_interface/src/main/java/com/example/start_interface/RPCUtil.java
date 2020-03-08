package com.example.start_interface;

public class RPCUtil {
    public static Class<?> changeToBasicClass(Object o) {
        Class<?> clazz = o.getClass();
        if (clazz == Integer.class) {
            clazz = Integer.TYPE;
        } else if (clazz == Long.class) {
            clazz = Long.TYPE;
        } else if (clazz == Float.class) {
            clazz = Float.TYPE;
        } else if (clazz == Double.class) {
            clazz = Double.TYPE;
        } else if (clazz == Short.class) {
            clazz = Short.TYPE;
        } else if (clazz == Boolean.class) {
            clazz = Boolean.TYPE;
        } else if (clazz == Character.class) {
            clazz = Character.TYPE;
        } else if (clazz == Byte.class) {
            clazz = Byte.TYPE;
        }
        return clazz;
    }
}
