package annotations.validate;

import annotations.Email;
import annotations.SimpleService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class EmailValidator implements Validator {

    @Override
    public void fieldValidator(Class<?> className) {
        Field[] declaredFields = className.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                Email annotation = field.getAnnotation(Email.class);
                String fieldValue = null;
                try {
                    fieldValue = field.get(className.getDeclaredConstructor().newInstance()).toString();
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                if (fieldValue != null && fieldValue.matches(annotation.regex())){
                    return;
                }else{
                    throw new RuntimeException( "Field's " + field.getName() + " is not correct");
                }

            }
        }

    }
}
