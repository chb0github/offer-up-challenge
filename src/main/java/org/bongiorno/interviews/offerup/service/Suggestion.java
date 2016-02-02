package org.bongiorno.interviews.offerup.service;

/**
 * Created by cbongiorno on 1/29/16.
 */
public class Suggestion {

    private final String city;
    private final String item;
    private final Integer listPrice;
    private final Long count;
    private final Integer totalFound;

    public Suggestion(String city, String item, Integer listPrice, Long count, Integer totalFound) {

        this.city = city;
        this.item = item;
        this.listPrice = listPrice;
        this.count = count;
        this.totalFound = totalFound;
    }

    public String getCity() {
        return city;
    }

    public String getItem() {
        return item;
    }

    public Integer getListPrice() {
        return listPrice;
    }

    public Long getCount() {
        return count;
    }

    public Integer getTotalFound() {
        return totalFound;
    }
}
