package homework2.annotations.validateAnnotations;

import homework2.annotations.Email;

import java.lang.reflect.Field;

public class EmailValidator<T> implements Validator {

    @Override
    public void fieldValidator(Object dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                Email annotation = field.getAnnotation(Email.class);
                String fieldValue = null;
                try {
                    fieldValue = field.get(dto).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (fieldValue != null && fieldValue.matches(annotation.regex())){
                    return;
                }else{
                    Messages.messages.add( "Field's " + field.getName() + " is not correct");
                }

            }
        }

    }
}
