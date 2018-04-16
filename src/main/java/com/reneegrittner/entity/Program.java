package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "Program")
@Table(name = "Program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String concertTitle;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "program", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ProgramComposition> listOfProgramComposition;

    public Program() {
    }

    public Program(LocalDate date, String concertTitle, String location, String address, String city, String state, Integer zipcode, String status) {
        this.date = date;
        this.concertTitle = concertTitle;
        this.location = location;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProgramComposition> getListOfProgramComposition() {
        return listOfProgramComposition;
    }

    public void setListOfProgramComposition(List<ProgramComposition> listOfProgramComposition) {
        this.listOfProgramComposition = listOfProgramComposition;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", date=" + date +
                ", concertTitle='" + concertTitle + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id &&
                Objects.equals(date, program.date) &&
                Objects.equals(concertTitle, program.concertTitle) &&
                Objects.equals(location, program.location) &&
                Objects.equals(address, program.address) &&
                Objects.equals(city, program.city) &&
                Objects.equals(state, program.state) &&
                Objects.equals(zipcode, program.zipcode) &&
                Objects.equals(status, program.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, concertTitle, location, address, city, state, zipcode, status);
    }
}
