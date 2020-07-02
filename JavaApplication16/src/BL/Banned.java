/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.Date;

/**
 *
 * @author Sebas
 */
public class Banned {
    private int id_banned;
    private String isPermanent;
    private Date date_start;
    private Date date_finish;
    private String username;
    private int id_bannedreason;

    public Banned(String isPermanent, Date date_start, Date date_finish, String username, int id_bannedreason) {
        this.isPermanent = isPermanent;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.username = username;
        this.id_bannedreason = id_bannedreason;
    }
    
    public Banned(String isPermanent, Date date_start, String username, int id_bannedreason) {
        this.isPermanent = isPermanent;
        this.date_start = date_start;
        this.username = username;
        this.id_bannedreason = id_bannedreason;
    }

    public int getId_banned() {
        return id_banned;
    }

    public void setId_banned(int id_banned) {
        this.id_banned = id_banned;
    }

    public String getIsPermanent() {
        return isPermanent;
    }

    public void setIsPermanent(String isPermanent) {
        this.isPermanent = isPermanent;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(Date date_finish) {
        this.date_finish = date_finish;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_bannedreason() {
        return id_bannedreason;
    }

    public void setId_bannedreason(int id_bannedreason) {
        this.id_bannedreason = id_bannedreason;
    }
    
    
}
