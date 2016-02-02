package org.bongiorno.interviews.offerup.dto;

import lombok.Getter;

@Getter
public class OfferUp {
    private Integer status;
    private Content content;

    public OfferUp(Integer status, String item, Long count, Integer price_suggestion, String city) {
        this.status = status;
        this.content = new Content(item,count,price_suggestion,city);
    }

    @Getter
    public static class Content {
        private String item;
        private Long count;
        private Integer price_suggestion;
        private String city = "Not specified";

        public Content() {
        }

        public Content(String item, Long count, Integer price_suggestion, String city) {
            this.item = item;
            this.count = count;
            this.price_suggestion = price_suggestion;
            if(city != null)
                this.city = city;
        }

    }
}
