package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private String name;
    private int price;
    private Date depare;
    public TripResultModel(String name, Date depare, int price) {
        this.name = name;
        this.depare = depare;
        this.price = price;
    }

    public Date getDepare() {
        return depare;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
