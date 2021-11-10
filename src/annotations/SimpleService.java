package annotations;

import java.time.LocalDate;

public class SimpleService {
    public SimpleService() {
    }

    @Length(max = 18)
    private String name = "gfdh";
    @Adulthood
    private LocalDate birthDay = LocalDate.of(2003, 11, 10);
    @Email
    private String email = "d@s";
    @Min(7)
    @Max(10)
    int age = 6;

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
