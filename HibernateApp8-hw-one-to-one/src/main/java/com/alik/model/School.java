package com.alik.model;

import jakarta.persistence.*;

@Entity
@Table(name = "School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "school_number")
    private int school_number;

    @OneToOne
    @JoinColumn(name = "principal_id",referencedColumnName = "id")
    private Principal principal;


    public School() {
    }

    public School(int school_number) {
        this.school_number = school_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchool_number() {
        return school_number;
    }

    public void setSchool_number(int school_number) {
        this.school_number = school_number;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", school_number=" + school_number +
                ", principal=" + principal +
                '}';
    }
}
