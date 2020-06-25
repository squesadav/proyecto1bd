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
public class UserType {
    private int id_usertype;
    private String description;

    public UserType(String description) {
        this.description = description;
    }

    public int getId_usertype() {
        return id_usertype;
    }

    public void setId_usertype(int id_usertype) {
        this.id_usertype = id_usertype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
