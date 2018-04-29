package com.reneegrittner.controllerLogic;

import com.reneegrittner.entity.Composer;
import com.reneegrittner.entity.Nationality;
import com.reneegrittner.persistence.GenericDao;

/**
 * The Composer Logic class handles the creation of new Composer Objects.
 * This method is accessed from AddComposer Servlet.
 */
public class ComposerLogic {
    private GenericDao<Composer> composerGenericDao = new GenericDao<>(Composer.class);
    private GenericDao<Nationality> nationalityGenericDao = new GenericDao<>(Nationality.class);

    /**
     * Create composer composer.
     *
     * @param firstName     the first name
     * @param lastName      the last name
     * @param birthYear     the birth year
     * @param deathYear     the death year
     * @param nationalityId the nationality id
     * @param userId        the user id
     * @return the composer
     */
    public Composer createComposer(String firstName, String lastName, String birthYear, String deathYear, String nationalityId, String composerIdString, int userId){
        Composer composerToAdd;

        // New composer or update existing?
        if(composerIdString == null){
            composerToAdd = new Composer();
        } else {
            composerToAdd = getComposerFromDB(composerIdString);
        }

        // Get Nationality object
        Nationality nationalityToAdd = getNationality(Integer.parseInt(nationalityId));

        // Convert birth & death years to Integer format. May be null
        Integer birthYearToAdd = getBirthOrDeathYearAsIntegerOrNull(birthYear);
        Integer deathYearToAdd = getBirthOrDeathYearAsIntegerOrNull(deathYear);

        // Set all values
        composerToAdd.setFirstName(firstName);
        composerToAdd.setLastName(lastName);
        composerToAdd.setBirthYear(birthYearToAdd);
        composerToAdd.setDeathYear(deathYearToAdd);
        composerToAdd.setNationality(nationalityToAdd);
        composerToAdd.setUserId(userId);

        // Send back completed Composer object
        return composerToAdd;
    }

    private Composer getComposerFromDB(String composerIdString) {
        Integer id = Integer.parseInt(composerIdString);
        Composer composer = composerGenericDao.getById(id);
        return composer;
    }


    /**
     * Uses the DAO to retrieve associated Nationality object.
     * Composers require this type for insertion.
     * @param nationalityId
     * @return nationality
     */
    private Nationality getNationality(int nationalityId) {

        Nationality nationality = nationalityGenericDao.getById(nationalityId);
        return nationality;

    }

    /**
     * Birth & Death year may be null,
     * this method converts input string to Integer or sets to null.
     * @param yearAsString
     * @return birthOrDeathYear
     */
    private Integer getBirthOrDeathYearAsIntegerOrNull(String yearAsString) {

        Integer birthOrDeathYear = null;

        if(yearAsString.length() > 0){
            birthOrDeathYear = Integer.parseInt(yearAsString);
        }

        return birthOrDeathYear;
    }


}
