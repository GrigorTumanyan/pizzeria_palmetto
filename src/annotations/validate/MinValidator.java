package annotations.validate;

import annotations.Max;
import annotations.Min;
import annotations.SimpleService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MinValidator implements Validator{
    public static void main(String[] args) {
        MinValidator m = new MinValidator();
        m.fieldValidator(SimpleService.class);
    }
    @Override
    public void fieldValidator(Class<?> className) {
        Field[] declaredFields = className.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Min.class)){
                field.setAccessible(true);
                Min annotation = field.getAnnotation(Min.class);
                try {
                    int fieldValue = (int) field.get(className.getDeclaredConstructor().newInstance());

                    if (fieldValue < annotation.value()){
                        throw new RuntimeException("Value of " + field.getName() + " is not correct");
                    }
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
