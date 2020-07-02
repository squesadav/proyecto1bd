/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Sebas
 */
public class Record {
    private String numberr;
    private String description_crime;
    private Date date_crime;
    private String resolution;
    private Date crime_expiration_date;
    private String approved;
    private int id_type;
    private String id_veredict;
    private int id_person;
    private int id_district;
    private ArrayList<Pictures> pictures;

    public Record(String number, String description_crime, Date date_crime, String resolution, 
        Date crime_expiration_date, String approved, int id_type, int id_person, int id_district) {
        this.numberr = number;
        this.description_crime = description_crime;
        this.date_crime = date_crime;
        this.resolution = resolution;
        this.crime_expiration_date = crime_expiration_date;
        this.approved = approved;
        this.id_type = id_type;
        this.id_veredict = numberr;
        this.id_person = id_person;
        this.id_district = id_district;
        this.pictures = null;
    }

    public String getNumber() {
        return numberr;
    }

    public void setNumber(String number) {
        this.numberr = number;
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

    public String getId_veredict() {
        return id_veredict;
    }

    public void setId_veredict(String id_veredict) {
        this.id_veredict = id_veredict;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getId_district() {
        return id_district;
    }

    public void setId_district(int id_district) {
        this.id_district = id_district;
    }
    
    public ArrayList<Pictures> getPictures() {
        return pictures;
    }
    
    public void setPicture(ArrayList<Pictures> picture) {
        this.pictures = picture;
    }

    public void insertPicture(Pictures picture) {
        this.pictures.add(picture);
    }
    
    
}
