package BL;

/**
 *
 * @author Sebas
 */
public class Community {
    private int id;
    private String name;
    private int id_district;

    public Community(String name, int id_district) {
        this.name = name;
        this.id_district = id_district;
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

    public int getId_district() {
        return id_district;
    }

    public void setId_district(int id_district) {
        this.id_district = id_district;
    }
    
    
    
}
