/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.Date;

/**
 *
 * @author Sebas
 */
public class Record {
    private String number;
    private String description_crime;
    private Date date_crime;
    private String resolution;
    private Date crime_expiration_date;
    private String picture;
    private String approved;
    private int id_type;
    private int id_veredict;
    private int id_person;

    public Record(String number, String description_crime, Date date_crime, String resolution, Date crime_expiration_date, String picture, String approved, int id_type, int id_veredict, int id_person) {
        this.number = number;
        this.description_crime = description_crime;
        this.date_crime = date_crime;
        this.resolution = resolution;
        this.crime_expiration_date = crime_expiration_date;
        this.picture = picture;
        this.approved = approved;
        this.id_type = id_type;
        this.id_veredict = id_veredict;
        this.id_person = id_person;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription_crime() {
        return description_crime;
    }

    public void setDescription_crime(String description_crime) {
        this.description_crime = description_crime;
    }

    public Date getDate_crime() {
        return date_crime;
    }

    public void setDate_crime(Date date_crime) {
        this.date_crime = date_crime;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getCrime_expiration_date() {
        return crime_expiration_date;
    }

    public void setCrime_expiration_date(Date crime_expiration_date) {
        this.crime_expiration_date = crime_expiration_date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String isApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getId_veredict() {
        return id_veredict;
    }

    public void setId_veredict(int id_veredict) {
        this.id_veredict = id_veredict;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
    
    
}
