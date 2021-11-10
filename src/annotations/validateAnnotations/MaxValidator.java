package annotations.validateAnnotations;

import annotations.Max;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MaxValidator implements Validator{

    @Override
    public void fieldValidator(Class<?> className) {
        Field[] declaredFields = className.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Max.class)){
                field.setAccessible(true);
                Max annotation = field.getAnnotation(Max.class);
                try {
                    int fieldValue = (int) field.get(className.getDeclaredConstructor().newInstance());

                    if (fieldValue > annotation.value()){
                        throw new RuntimeException("Value of " + field.getName() + " is not correct");
                    }
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
