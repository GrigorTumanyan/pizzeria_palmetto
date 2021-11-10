package annotations.validate;

import annotations.Adulthood;
import annotations.SimpleService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;


public class AdulthoodValidator implements Validator {

    @Override
    public void fieldValidator(Class<?> className) {
        Field[] declaredFields = className.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                try {
                    LocalDate fieldValue = (LocalDate) field.get(className.getDeclaredConstructor().newInstance());
                    if ((LocalDate.now().getYear() - fieldValue.getYear()) <= 18){
                        if ((LocalDate.now().getDayOfYear() - fieldValue.getDayOfYear()) < 0){
                            throw new RuntimeException("You are under 18 years old");
                        }
                    }
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
