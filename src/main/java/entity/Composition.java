package entity;

public class Composition {

    private int id;
    private String title;
    private String arranger;
    private Integer duration;
    private String yearComposed;
    private String notes;
    private boolean clocksCommission;

    private int composerId;


    public Composition() {
    }

    public Composition(String title, String arranger, Integer duration, String yearComposed, String notes, boolean clocksCommission, int composerId) {
        this.title = title;
        this.arranger = arranger;
        this.duration = duration;
        this.yearComposed = yearComposed;
        this.notes = notes;
        this.clocksCommission = clocksCommission;
        this.composerId = composerId;
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

    public int getComposerId() {
        return composerId;
    }

    public void setComposerId(int composerId) {
        this.composerId = composerId;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", arranger='" + arranger + '\'' +
                ", duration=" + duration +
                ", yearComposed='" + yearComposed + '\'' +
                ", notes='" + notes + '\'' +
                ", clocksCommission=" + clocksCommission +
                ", composerId=" + composerId +
                '}';
    }
}
