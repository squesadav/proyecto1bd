/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

/**
 *
 * @author Sebas
 */
public class User {
    private String username;
    private String password;
    private int id_userType;
    public Person person;

    public User(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_userType() {
        return id_userType;
    }

    public void setId_userType(int id_userType) {
        this.id_userType = id_userType;
    }

    public Person getId_person() {
        return person;
    }

    public void setId_person(Person person) {
        this.person = person;
    }
}
