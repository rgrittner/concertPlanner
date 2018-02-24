package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Nationality.
 * Only Composers have a nationality option.
 *
 * @author Renee Grittner
 */
@Entity(name = "Nationality")
@Table(name = "Nationality")
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "nationality", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Composer> composers = new HashSet<>();

    /**
     * Instantiates a new Nationality.
     */
    public Nationality() {
    }


    /**
     * Instantiates a new Nationality.
     *
     * @param nationality the nationality
     */
    public Nationality(String nationality) {
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
     * Gets nationality.
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets composers.
     *
     * @return the composers
     */
    public Set<Composer> getComposers() {
        return composers;
    }

    /**
     * Sets composers.
     *
     * @param composers the composers
     */
    public void setComposers(Set<Composer> composers) {
        this.composers = composers;
    }

    /**
     * Add composer.
     *
     * @param composer the composer
     */
    public void addComposer(Composer composer) {
        composers.add(composer);
        composer.setNationality(this);
    }

    public void removeComposer(Composer composer) {
        composers.remove( composer );
        composer.setNationality( null );
    }


    @Override
    public String toString(){
        return "Nationality{ " + nationality + " }";
    }



}
