package Tools;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int age;
    private int phone;
    private Gender gender;
    private LocalDate purchaseDate;

    public enum Gender {
        MALE, FEMALE
    }

    public Customer(String name, int age, int phone, Gender gender, LocalDate purchaseDate) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.purchaseDate = purchaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return String.format("Customer{name='%s', age=%d, phone=%d, gender=%s, purchaseDate=%s}",
                name, age, phone, gender, purchaseDate);
    }
}

