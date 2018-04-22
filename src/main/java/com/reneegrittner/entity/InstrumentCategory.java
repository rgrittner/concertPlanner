package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents the different types of instruments that may be encountered.
 * Percussionists utilize a wide range of instrumentation, and providing
 * categories will allow for better display and sorting.
 *
 * @author Renee Grittner
 */
@Entity(name = "InstrumentCategory")
@Table(name = "Instrument_Category")
public class InstrumentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "user_Id")
    private int userId;

    @OneToMany(mappedBy = "instrumentCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)

    private Set<Instrument> instruments = new HashSet<>();

    /**
     * Instantiates a new Instrument category.
     */
    public InstrumentCategory() {
    }

    /**
     * Instantiates a new Instrument category.
     *
     * @param category the category
     * @param userId   the user id
     */
    public InstrumentCategory(String category, int userId) {

        this.category = category;
        this.userId = userId;
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
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets instruments.
     *
     * @return the instruments
     */
    public Set<Instrument> getInstruments() {
        return instruments;
    }

    /**
     * Sets instruments.
     *
     * @param instruments the instruments
     */
    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    /**
     * Add Instrument.
     *
     * @param instrument the composer
     */
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
        instrument.setInstrumentCategory(this);
    }

    /**
     * Remove instrument.
     *
     * @param instrument the instrument
     */
    public void removeInstrument(Instrument instrument) {
        instruments.remove( instrument );
        instrument.setInstrumentCategory( null );
    }


    @Override
    public String toString() {
        return "InstrumentCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentCategory category1 = (InstrumentCategory) o;
        return id == category1.id &&
                userId == category1.userId &&
                Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, category, userId);
    }
}