package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * A class to represent a musician.
 *
 * @author Renee Grittner
 */
@Entity(name = "Musician")
@Table(name = "Musician")
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

<<<<<<< HEAD
    @Column(name = "user_Id")
    private int userId;
=======
    @OneToMany(mappedBy = "musician", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProgramComposition> listOfProgramComposition;
>>>>>>> master

    /**
     * Instantiates a new Musician.
     */
    public Musician() {
    }

    /**
     * Instantiates a new Musician.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param phoneNumber the phone number
     * @param email       the email
     * @param status      the status
     */
    public Musician(String firstName, String lastName, String phoneNumber, String email, String status) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() { return email; }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() { return status; }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Gets list of program composition.
     *
     * @return the list of program composition
     */
    public List<ProgramComposition> getListOfProgramComposition() {
        return listOfProgramComposition;
    }

    /**
     * Sets list of program composition.
     *
     * @param listOfProgramComposition the list of program composition
     */
    public void setListOfProgramComposition(List<ProgramComposition> listOfProgramComposition) {
        this.listOfProgramComposition = listOfProgramComposition;
    }

    @Override
    public String toString(){
        return "Musician { " +
                "first name = " + firstName + '\'' +
                "last name = " + lastName + '\'' +
                "phone = " + phoneNumber + '\'' +
                "email = " + email + '\'' +
                "status = " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return id == musician.id &&
                Objects.equals(firstName, musician.firstName) &&
                Objects.equals(lastName, musician.lastName) &&
                Objects.equals(phoneNumber, musician.phoneNumber) &&
                Objects.equals(email, musician.email) &&
                Objects.equals(status, musician.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, phoneNumber, email, status);
    }
}
