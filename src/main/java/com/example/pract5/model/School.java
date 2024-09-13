package com.example.pract5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 5, max = 30, message = "Имя должно быть больше 5 и меньше 30")
    private String name;
    @NotNull(message = "Адресс не должен быть пустым")
    private String adress;
    @NotNull(message = "Дата создания не должно быть пустым")
    private int date_create;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_FK", referencedColumnName = "id")
    private Director director_FK;
    @JsonManagedReference
    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private Collection<Student> students_FK;

    public School(Long id, String name, String adress, int date_create, Director director_FK, List<Student> students_FK) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.date_create = date_create;
        this.director_FK = director_FK;
        this.students_FK = students_FK;
    }

    public School() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getDate_create() {
        return date_create;
    }

    public void setDate_create(int date_create) {
        this.date_create = date_create;
    }

    public Director getDirector_FK() {
        return director_FK;
    }

    public void setDirector_FK(Director director_FK) {
        this.director_FK = director_FK;
    }

    public Collection<Student> getStudents_FK() {
        return students_FK;
    }

    public void setStudents_FK(Collection<Student> students_FK) {
        this.students_FK = students_FK;
    }
}
