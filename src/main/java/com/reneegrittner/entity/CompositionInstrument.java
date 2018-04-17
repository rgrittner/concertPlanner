package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Composition instrument.
 * @author Renee Grittner
 */
@Entity(name = "CompositionInstrument")
@Table(name = "Composition_Instrument")
public class CompositionInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "player")
    private int playerNumber;

    @Column(name = "qty")
    private int instrumentQuantity;

    @Column(name = "user_Id")
    private int userId;

    @ManyToOne
    private Instrument instrument;

    @ManyToOne
    private Composition composition;

    /**
     * Instantiates a new Composition instrument.
     */
    public CompositionInstrument() {
    }

    /**
     * Instantiates a new Composition instrument.
     *
     * @param playerNumber       the player number
     * @param instrumentQuantity the instrument quantity
     * @param instrument         the instrument
     * @param composition        the composition
     */
    public CompositionInstrument(int playerNumber, int instrumentQuantity, Instrument instrument, Composition composition) {
        this.playerNumber = playerNumber;
        this.instrumentQuantity = instrumentQuantity;
        this.instrument = instrument;
        this.composition = composition;
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
     * Gets player number.
     *
     * @return the player number
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Sets player number.
     *
     * @param playerNumber the player number
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     * Gets instrument quantity.
     *
     * @return the instrument quantity
     */
    public int getInstrumentQuantity() {
        return instrumentQuantity;
    }

    /**
     * Sets instrument quantity.
     *
     * @param instumentQuantity the instument quantity
     */
    public void setInstrumentQuantity(int instumentQuantity) {
        this.instrumentQuantity = instumentQuantity;
    }

    /**
     * Gets instrument.
     *
     * @return the instrument
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets instrument.
     *
     * @param instrument the instrument
     */
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    /**
     * Gets composition.
     *
     * @return the composition
     */
    public Composition getComposition() {
        return composition;
    }

    /**
     * Sets composition.
     *
     * @param composition the composition
     */
    public void setComposition(Composition composition) {
        this.composition = composition;
    }



    @Override
    public String toString() {
        return "CompositionInstrument{" +
                "id=" + id +
                ", playerNumber=" + playerNumber +
                ", instumentQuantity=" + instrumentQuantity +
                ", instrument=" + instrument +
                ", composition=" + composition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionInstrument that = (CompositionInstrument) o;
        return id == that.id &&
                playerNumber == that.playerNumber &&
                instrumentQuantity == that.instrumentQuantity &&
                Objects.equals(instrument, that.instrument) &&
                Objects.equals(composition, that.composition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, playerNumber, instrumentQuantity, instrument, composition);
    }
}
