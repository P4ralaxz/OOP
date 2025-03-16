import java.util.*;
/**
 *
 * @author Paral
 */
public class Item {
    private int Id;
    private String name;
    private double price;
    private Date created_on;

    public Item(int Id, String name, double price, Date created_on) {
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.created_on = created_on;
    }

    public Item() {
        this(0, "", 0, null);
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
    
    
}
