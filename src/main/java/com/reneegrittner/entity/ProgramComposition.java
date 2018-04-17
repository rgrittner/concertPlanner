package com.reneegrittner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ProgramComposition")
@Table(name = "Composition_Program")
public class ProgramComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "player")
    private int playerNumber;

    @ManyToOne
    private Musician musician;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Composition composition;

    public ProgramComposition() {
    }

    public ProgramComposition(int playerNumber, Musician musician, Program program, Composition composition) {
        this.playerNumber = playerNumber;
        this.musician = musician;
        this.program = program;
        this.composition = composition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgramComposition)) return false;
        ProgramComposition that = (ProgramComposition) o;
        return id == that.id &&
                playerNumber == that.playerNumber &&
                Objects.equals(musician, that.musician) &&
                Objects.equals(program, that.program) &&
                Objects.equals(composition, that.composition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, playerNumber, musician, program, composition);
    }
}
