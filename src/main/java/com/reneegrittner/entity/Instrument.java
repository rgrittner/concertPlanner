package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Represents an Instrument.
 *
 * @author Renee Grittner
 */
@Entity(name = "Instrument")
@Table(name = "Instrument")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_Id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "Instrument_Category_id", foreignKey = @ForeignKey(name = "Instrument_Instrument_Category"))
    private InstrumentCategory instrumentCategory;

    @OneToMany(mappedBy = "instrument", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CompositionInstrument> listOfCompositions;

    /**
     * Instantiates a new Instrument.
     */
    public Instrument() {
    }

    /**
     * Instantiates a new Instrument.
     *
     * @param name               the name
     * @param instrumentCategory the instrument category
     * @param userId             the user id
     */
    public Instrument(String name, InstrumentCategory instrumentCategory, int userId) {

        this.name = name;
        this.instrumentCategory = instrumentCategory;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets instrument category.
     *
     * @return the instrument category
     */
    public InstrumentCategory getInstrumentCategory() {
        return instrumentCategory;
    }

    /**
     * Sets instrument category.
     *
     * @param instrumentCategory the instrument category
     */
    public void setInstrumentCategory(InstrumentCategory instrumentCategory) {
        this.instrumentCategory = instrumentCategory;
    }

    /**
     * Gets list of compositions.
     *
     * @return the list of compositions
     */
    public List<CompositionInstrument> getListOfCompositions() {
        return listOfCompositions;
    }

    /**
     * Sets list of compositions.
     *
     * @param listOfCompositions the list of compositions
     */
    public void setListOfCompositions(List<CompositionInstrument> listOfCompositions) {
        this.listOfCompositions = listOfCompositions;
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

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(instrumentCategory, that.instrumentCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, userId);
    }
}