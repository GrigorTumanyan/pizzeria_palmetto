package annotations.validateAnnotations;

import annotations.Length;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LengthValidator<T> implements Validator {

    @Override
    public void fieldValidator(Object dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                Length annotation = field.getAnnotation(Length.class);
                String fieldValue = null;
                try {
                    fieldValue = field.get(dto).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (fieldValue == null || fieldValue.length() < annotation.min()| fieldValue.length() > annotation.max()) {
                    Messages.messages.add("Field's " + field.getName() + " is not correct");
                }
            }
        }
    }
}
