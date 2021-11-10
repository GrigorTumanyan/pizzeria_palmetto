package annotations.validate;

import annotations.Length;
import annotations.validate.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LengthValidator implements Validator {

    @Override
    public void fieldValidator(Class<?> className) {
        Field[] declaredFields = className.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                Length annotation = field.getAnnotation(Length.class);
                String fieldValue = null;
                try {
                    fieldValue = field.get(className.getDeclaredConstructor().newInstance()).toString();
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if (fieldValue == null || fieldValue.length() < annotation.min()| fieldValue.length() > annotation.max()) {
                    throw new RuntimeException("Field's " + field.getName() + " is not correct");
                }
            }
        }
    }
}
