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
public class BannedReason {
    private int id_bannedreason;
    private String description;

    public BannedReason(String description) {
        this.description = description;
    }

    public int getId_bannedreason() {
        return id_bannedreason;
    }

    public void setId_bannedreason(int id_bannedreason) {
        this.id_bannedreason = id_bannedreason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
