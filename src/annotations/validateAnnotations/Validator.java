package annotations.validateAnnotations;

public interface Validator<T> {
     void fieldValidator(T dto);
}
