package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Composition")
@Table(name = "Composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "arranger")
    private String arranger;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "year")
    private String yearComposed;

    @Column(name = "number_of_players")
    private Integer numberOfPlayers;

    @Column(name = "notes")
    private String notes;

    @Column(name = "clocks_commission")
    private boolean clocksCommission;




    public Composition() {
    }

    public Composition(String title, String arranger, Integer duration, String yearComposed, String notes, boolean clocksCommission) {
        this.title = title;
        this.arranger = arranger;
        this.duration = duration;
        this.yearComposed = yearComposed;
        this.notes = notes;
        this.clocksCommission = clocksCommission;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getYearComposed() {
        return yearComposed;
    }

    public void setYearComposed(String yearComposed) {
        this.yearComposed = yearComposed;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isClocksCommission() {
        return clocksCommission;
    }

    public void setClocksCommission(boolean clocksCommission) {
        this.clocksCommission = clocksCommission;
    }


    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", arranger='" + arranger + '\'' +
                ", duration=" + duration +
                ", yearComposed='" + yearComposed + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", notes='" + notes + '\'' +
                ", clocksCommission=" + clocksCommission +
                '}';
    }
}
