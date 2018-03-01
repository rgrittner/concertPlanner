package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "InstrumentCategory_id", foreignKey = @ForeignKey(name = "Instrument_InstrumentCategory"))
    private InstrumentCategory instrumentCategory;

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
     */
    public Instrument(String name, InstrumentCategory instrumentCategory) {

        this.name = name;
        this.instrumentCategory = instrumentCategory;
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

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instrumentCategory=" + instrumentCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(instrumentCategory, that.instrumentCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, instrumentCategory);
    }
}