package com.kosoban.aquacultureexpanded.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {
    public static void updateFieldRecursive(Object obj, String propertyName, Object newValue) {
        try {
            Class<?> type = obj.getClass();
            boolean hasProp = objectHasProperty(type, propertyName);
            while(!hasProp) {
                type = type.getSuperclass();
                if (type == null) {
                    break;
                }
                hasProp = objectHasProperty(type, propertyName);
            }
            if (!hasProp) {
                return;
            }
            Field field = type.getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(obj, newValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Boolean objectHasProperty(Class<?> type, String propertyName) {
        List<Field> properties = getAllFields(type);
        for(Field field : properties){
            if(field.getName().equalsIgnoreCase(propertyName)){
                return true;
            }
        }
        return false;
    }

    private static List<Field> getAllFields(Class<?> type){
        List<Field> fields = new ArrayList<Field>();
        for (Field field: type.getDeclaredFields()) {
            fields.add(field);
        }
        return fields;
    }
}
