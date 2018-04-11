package com.reneegrittner.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Composition.
 * @author Renee Grittner
 */
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


    /**
     * Instantiates a new Composition.
     */
    public Composition() {
    }

    /**
     * Instantiates a new Composition.
     *
     * @param title            the title
     * @param arranger         the arranger (nullable)
     * @param duration         the duration
     * @param yearComposed     the year composed
     * @param numberOfPlayers  the number of players
     * @param notes            the notes
     * @param clocksCommission the clocks commission (was this piece commissioned by the ensemble)
     * @param composer         the composer
     */
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets arranger.
     *
     * @return the arranger
     */
    public String getArranger() {
        return arranger;
    }

    /**
     * Sets arranger.
     *
     * @param arranger the arranger
     */
    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Gets year composed.
     *
     * @return the year composed
     */
    public Integer getYearComposed() {
        return yearComposed;
    }

    /**
     * Sets year composed.
     *
     * @param yearComposed the year composed
     */
    public void setYearComposed(Integer yearComposed) {
        this.yearComposed = yearComposed;
    }

    /**
     * Gets number of players.
     *
     * @return the number of players
     */
    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * Sets number of players.
     *
     * @param numberOfPlayers the number of players
     */
    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Is clocks commission boolean.
     *
     * @return the boolean
     */
    public boolean isClocksCommission() {
        return clocksCommission;
    }

    /**
     * Sets clocks commission.
     *
     * @param clocksCommission the clocks commission
     */
    public void setClocksCommission(boolean clocksCommission) {
        this.clocksCommission = clocksCommission;
    }

    /**
     * Gets composer.
     *
     * @return the composer
     */
    public Composer getComposer() {
        return composer;
    }

    /**
     * Sets composer.
     *
     * @param composer the composer
     */
    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    /**
     * Gets list of instruments.
     *
     * @return the list of instruments
     */
    public List<CompositionInstrument> getListOfInstruments() {
        return listOfInstruments;
    }

    /**
     * Sets list of instruments.
     *
     * @param listOfInstruments the list of instruments
     */
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
