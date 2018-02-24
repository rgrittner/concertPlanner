package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.sound.midi.Instrument;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type InstrumentCategory.
 * Only Instruments have a category option.
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
    private String categoryDescription;

    @OneToMany(mappedBy = "instrumentCategory", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Instrument> instruments = new HashSet<>();

    public InstrumentCategory() {
    }

    public InstrumentCategory(String category) {
        this.categoryDescription = category;

    }

    public int getId() { return id; }

    public void setId(int id) {this.id = id; }

    public String getCategoryDescription() {return categoryDescription; }

    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }

    public Set<Instrument> getInstruments() { return instruments; }

    public void setInstruments(Set<Instrument> instruments) { this.instruments = instruments; }


//        /**
//     * Add instrument.
//     *
//     * @param instrument the instrument
//     */
//    public void addInstrument(Instrument instrument) {
//        instruments.add(instrument);
//        instrument.setInstrumentCategory(this);
//    }
//
//    public void removeInstrument(Instrument instrument) {
//        instruments.remove( instrument );
//        instrument.setInstrumentCategory( null );
//    }


    @Override
    public String toString() {
        return "InstrumentCategory{" +
                "id=" + id +
                ", category='" + categoryDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentCategory that = (InstrumentCategory) o;
        return id == that.id &&
                Objects.equals(categoryDescription, that.categoryDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryDescription);
    }
}
