package homework2.annotations.validateAnnotations;

import homework2.annotations.Adulthood;

import java.lang.reflect.Field;
import java.time.LocalDate;


public class AdulthoodValidator<T> implements Validator {
    @Override
    public void fieldValidator(Object dto) {
        Field[] declaredFields = dto.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Adulthood.class)) {
                field.setAccessible(true);
                LocalDate fieldValue = null;
                try {
                    fieldValue = (LocalDate) field.get(dto);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                assert fieldValue != null;
                if ((LocalDate.now().getYear() - fieldValue.getYear()) < 18 ) {
                    Messages.messages.add("You are under 18 years old");
                }else if((LocalDate.now().getYear() - fieldValue.getYear()) == 18 && (LocalDate.now().getDayOfYear() - fieldValue.getDayOfYear()) < 0 )
                            Messages.messages.add("You are under 18 years old");


            }
        }
    }
}
