package annotation;

public @interface Size {
    int min() default 4;

    int max() default 10;
}
