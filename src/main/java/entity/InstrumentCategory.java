package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "InstrumentCategory")
@Table(name = "Instrument_Category")
public class InstrumentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int Id;

    private String category;

    public InstrumentCategory() {
    }

    public InstrumentCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "InstrumentCategory{" +
                "Id=" + Id +
                ", category='" + category + '\'' +
                '}';
    }
}
