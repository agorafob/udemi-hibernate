package com.alik.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private int passport_number;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;




    public Passport() {
    }

    public Passport( int passport_number) {
        this.passport_number = passport_number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(int passport_number) {
        this.passport_number = passport_number;

    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passport_number=" + passport_number +
                ", person=" + person +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
