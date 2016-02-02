package org.bongiorno.interviews.offerup.domain;

import javax.persistence.*;

@Entity
@Table(name = "\"itemPrices_itemsale\"")
public class Offer {


    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer list_price;

    @Column(nullable = false)
    private Integer sell_price;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean cashless;

    public Offer() {
    }

    public Offer(Long id, String title, Integer list_price, String city) {
        this.id = id;
        this.title = title;
        this.list_price = list_price;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getListPrice() {
        return list_price;
    }

    public Integer getSellPrice() {
        return sell_price;
    }

    public String getCity() {
        return city;
    }

    public Boolean getCashless() {
        return cashless;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setListPrice(Integer list_price) {
        this.list_price = list_price;
    }

    public void setSellPrice(Integer sell_price) {
        this.sell_price = sell_price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCashless(Boolean cashless) {
        this.cashless = cashless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (id != null ? !id.equals(offer.id) : offer.id != null) return false;
        if (title != null ? !title.equals(offer.title) : offer.title != null) return false;
        if (list_price != null ? !list_price.equals(offer.list_price) : offer.list_price != null) return false;
        if (sell_price != null ? !sell_price.equals(offer.sell_price) : offer.sell_price != null) return false;
        if (city != null ? !city.equals(offer.city) : offer.city != null) return false;
        return !(cashless != null ? !cashless.equals(offer.cashless) : offer.cashless != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (list_price != null ? list_price.hashCode() : 0);
        result = 31 * result + (sell_price != null ? sell_price.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (cashless != null ? cashless.hashCode() : 0);
        return result;
    }
}
