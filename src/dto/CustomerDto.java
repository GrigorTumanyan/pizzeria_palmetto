package dto;

import annotations.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto {
    @Length(min = 2, max = 30)
    private String name;
    @Email
    private String email;
    @Adulthood
    private LocalDate birthDay;
    @Min(0)
    @Max(100)
    private int discountRate;

    public CustomerDto(String name, String email, LocalDate birthDay, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.discountRate = discountRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
