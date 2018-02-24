package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

//    @ManyToOne
//    private InstrumentCategory instrumentCategory;

    /**
     * Instantiates a new Instrument.
     */
    public Instrument() {
    }

    /**
     * Instantiates a new Instrument.
     *
     * @param id                 the id
     * @param name               the name
   //  * @param instrumentCategory the instrument category
     */
    public Instrument(int id, String name) {
        this.id = id;
        this.name = name;
        //this.instrumentCategory = instrumentCategory;
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
//    public InstrumentCategory getInstrumentCategory() {
//        return instrumentCategory;
//    }
//
//    /**
//     * Sets instrument category.
//     *
//     * @param instrumentCategory the instrument category
//     */
//    public void setInstrumentCategory(InstrumentCategory instrumentCategory) {
//        this.instrumentCategory = instrumentCategory;
//    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instrumentCategory=" +
                '}';
    }
}
