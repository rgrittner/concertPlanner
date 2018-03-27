package com.reneegrittner.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Composition")
@Table(name = "Composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "arranger")
    private String arranger;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "year")
    private Integer yearComposed;

    @Column(name = "number_of_players")
    private Integer numberOfPlayers;

    @Column(name = "notes")
    private String notes;

    @Column(name = "clocks_commission")
    private boolean clocksCommission;


    @ManyToOne
    private Composer composer;

    @OneToMany(mappedBy = "composition", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CompositionInstrument> listOfInstruments;



    public Composition() {
    }

    public Composition(String title, String arranger, Integer duration, Integer yearComposed, Integer numberOfPlayers, String notes, boolean clocksCommission, Composer composer) {
        this.title = title;
        this.arranger = arranger;
        this.duration = duration;
        this.yearComposed = yearComposed;
        this.numberOfPlayers = numberOfPlayers;
        this.notes = notes;
        this.clocksCommission = clocksCommission;
        this.composer = composer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYearComposed() {
        return yearComposed;
    }

    public void setYearComposed(Integer yearComposed) {
        this.yearComposed = yearComposed;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isClocksCommission() {
        return clocksCommission;
    }

    public void setClocksCommission(boolean clocksCommission) {
        this.clocksCommission = clocksCommission;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public List<CompositionInstrument> getListOfInstruments() {
        return listOfInstruments;
    }

    public void setListOfInstruments(List<CompositionInstrument> listOfInstruments) {
        this.listOfInstruments = listOfInstruments;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", arranger='" + arranger + '\'' +
                ", duration=" + duration +
                ", yearComposed='" + yearComposed + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", notes='" + notes + '\'' +
                ", clocksCommission=" + clocksCommission +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition that = (Composition) o;
        return id == that.id &&
                clocksCommission == that.clocksCommission &&
                Objects.equals(title, that.title) &&
                Objects.equals(arranger, that.arranger) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(yearComposed, that.yearComposed) &&
                Objects.equals(numberOfPlayers, that.numberOfPlayers) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(composer, that.composer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, arranger, duration, yearComposed, numberOfPlayers, notes, clocksCommission, composer);
    }
}
