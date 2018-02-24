package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Instrument.
 */
@Entity(name = "Instrument")
@Table(name = "Instrument")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String instrumentName;

    @ManyToOne
    private InstrumentCategory instrumentCategory;

    public Instrument() {
    }

    public Instrument(String instrumentName, InstrumentCategory instrumentCategory) {
        this.instrumentName = instrumentName;
        this.instrumentCategory = instrumentCategory;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getInstrumentName() { return instrumentName; }

    public void setInstrumentName(String instrumentName) { this.instrumentName = instrumentName; }

    public InstrumentCategory getInstrumentCategory() { return instrumentCategory; }

    public void setInstrumentCategory(InstrumentCategory instrumentCategory) { this.instrumentCategory = instrumentCategory; }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", instrumentName='" + instrumentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id == that.id &&
                Objects.equals(instrumentName, that.instrumentName) &&
                Objects.equals(instrumentCategory, that.instrumentCategory);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, instrumentName, instrumentCategory);
    }
}
