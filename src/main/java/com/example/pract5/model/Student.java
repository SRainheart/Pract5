package com.example.pract5.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 15, message = "Имя должно быть больше 3 и меньше 15 ")
    private String name;//имя
    @NotNull(message = "Фамилия не должна быть пустым")
    @Size(min = 5, max = 20, message = "Фамилия должно быть больше 5 и меньше 20 ")
    private String lastname;//фамилия
    @Size(min = 5, max = 25, message = "Отчество должно быть больше 5 и меньше 25 ")
    private String midelname;//Отчество
    @Min(value = 6, message = "Возраст ученика должен быть не меньше 6")
    @Max(value = 20, message = "Возраст ученика должен быть не больше 20")
    @NotNull(message = "Возраст не должен быть пустым")
    private int age;//Возраст
    @JsonBackReference
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private School school;

    public Student(Long id, String name, String lastname, String midelname, int age, School school) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.midelname = midelname;
        this.age = age;
        this.school = school;
    }

    public Student() {
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}