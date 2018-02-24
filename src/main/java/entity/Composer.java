package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Composer.
 */
@Entity(name = "Composer")
@Table(name = "Composer")
public class Composer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @ManyToOne
    private Nationality nationality;

    public Composer() {
    }

    /**
     * Instantiates a new Composer.
     *
     * @param firstName   the first name
     * @param lastName    the last name

     * @param nationality the nationality
     */
    public Composer(String firstName, String lastName, Nationality nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets birth year.
     *
     * @return the birth year
     */
    public Integer getBirthYear() {
        return birthYear;
    }

    /**
     * Sets birth year.
     *
     * @param birthYear the birth year
     */
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Gets death year.
     *
     * @return the death year
     */
    public Integer getDeathYear() {
        return deathYear;
    }

    /**
     * Sets death year.
     *
     * @param deathYear the death year
     */
    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public Nationality getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composer composer = (Composer) o;
        return id == composer.id &&
                Objects.equals(firstName, composer.firstName) &&
                Objects.equals(lastName, composer.lastName) &&
                Objects.equals(birthYear, composer.birthYear) &&
                Objects.equals(deathYear, composer.deathYear) &&
                Objects.equals(nationality, composer.nationality);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, birthYear, deathYear, nationality);
    }
}
