package com.example.pract5.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Directors")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 15, message = "Имя должно быть больше 3 и меньше 15 ")
    @NotNull(message = "Имя не должно быть пустым")
    private String name;//имя
    @Size(min = 5, max = 20, message = "Фамилия должно быть больше 5 и меньше 20 ")
    @NotNull(message = "Фамилия не должна быть пустым")
    private String lastname;//фамилия
    @Size(min = 5, max = 25, message = "Отчество должно быть больше 5 и меньше 25 ")
    private String midelname;//Отчество
    @Min(value = 25, message = "Возраст директора должен быть не меньше 25")
    @Max(value = 50, message = "Возраст директора должен быть не больше 50")
    @NotNull(message = "Возраст не должнен быть пустым")
    private int age;//Возраст
    @Min(value = 10000, message = "зарплата директора должна быть не меньше 100000 тыс.")
    @Max(value = 50000, message = "Возраст ученика должен быть не больше 500000 тыс.")
    private int salary;//зарплата

    public Director(Long id, String name, String lastname, String midelname, int age, int salary) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.midelname = midelname;
        this.age = age;
        this.salary = salary;
    }

    public Director() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMidelname() {
        return midelname;
    }

    public void setMidelname(String midelname) {
        this.midelname = midelname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
