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
public class Person {
    private int id;
    private String name;
    private String middle_name;
    private String last_name;
    private Date birthday;
    private int age;
    private int id_gender;
    private int id_institution;
    private int id_community;

    public Person(int id, String name, String middle_name, String last_name, Date birthday, int age, int id_gender, int id_institution, int id_community) {
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.age = age;
        this.id_gender = id_gender;
        this.id_institution = id_institution;
        this.id_community = id_community;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_gender() {
        return id_gender;
    }

    public void setId_gender(int id_gender) {
        this.id_gender = id_gender;
    }

    public int getId_institution() {
        return id_institution;
    }

    public void setId_institution(int id_institution) {
        this.id_institution = id_institution;
    }

    public int getId_community() {
        return id_community;
    }

    public void setId_community(int id_community) {
        this.id_community = id_community;
    }
    
    
    
    
    
}