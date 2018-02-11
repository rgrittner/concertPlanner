package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents the different types of instruments that may be encountered.
 * Percussionists utilize a wide range of instrumentation, and providing
 * categories will allow for better display and sorting.
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

    /**
     * Instantiates a new Instrument category.
     */
    public InstrumentCategory() {
    }

    /**
     * Instantiates a new Instrument category.
     *
     * @param id       the id
     * @param category the category
     */
    public InstrumentCategory(int id, String category) {
        this.id = id;
        this.category = category;
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

    @Override
    public String toString(){
        return "Instrument Category {id= " + id + " category= " + category;
    }
}
