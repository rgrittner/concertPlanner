package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private int birthYear;

    @Column(name = "death_year")
    private int deathYear;

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
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Sets birth year.
     *
     * @param birthYear the birth year
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Gets death year.
     *
     * @return the death year
     */
    public int getDeathYear() {
        return deathYear;
    }

    /**
     * Sets death year.
     *
     * @param deathYear the death year
     */
    public void setDeathYear(int deathYear) {
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


}
