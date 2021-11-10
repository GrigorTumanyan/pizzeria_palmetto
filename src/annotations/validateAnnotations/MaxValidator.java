package annotations.validateAnnotations;

import annotations.Max;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MaxValidator<T> implements Validator {

    @Override
    public void fieldValidator(Object dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                Max annotation = field.getAnnotation(Max.class);
                int fieldValue = 0;
                try {
                    fieldValue = (int) field.get(dto);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (fieldValue > annotation.value()) {
                    Messages.messages.add(" Value of " + field.getName() + " is higher than defined");
                }
            }
        }
    }
}
