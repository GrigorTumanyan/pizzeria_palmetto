package homework2.annotations.validateAnnotations;

import homework2.annotations.Min;

import java.lang.reflect.Field;

public class MinValidator<T> implements Validator {

    @Override
    public void fieldValidator(Object dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Min.class)) {
                field.setAccessible(true);
                Min annotation = field.getAnnotation(Min.class);
                int fieldValue = 0;
                try {
                    fieldValue = (int) field.get(dto);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (fieldValue < annotation.value()) {
                    Messages.messages.add("Value of " + field.getName() + " is lower than defined");
                }
            }
        }
    }
}
