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
public class Veredict {
    private int id;
    private int years;
    private int id_place;
    private Date date_start;
    private Date date_end;

    public Veredict(int years, int id_place, Date date_start, Date ate_end) {
        this.years = years;
        this.id_place = id_place;
        this.date_start = date_start;
        this.date_end = date_end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return ate_end;
    }

    public void setDate_end(Date ate_end) {
        this.ate_end = ate_end;
    }
    
    
}
