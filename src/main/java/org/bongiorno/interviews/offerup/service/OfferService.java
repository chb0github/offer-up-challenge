package org.bongiorno.interviews.offerup.service;

import org.bongiorno.interviews.offerup.domain.Offer;
import org.bongiorno.interviews.offerup.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.StreamSupport.stream;

@Service
public class OfferService {


    @Autowired
    private OfferRepository repository;

    public Suggestion getSuggestionFor(String city, String item) {
        System.out.format("Looking for %s, %s\r\n", city,item);
        Suggestion result = null;
        List<Offer> offers = null;
        if(city != null)
            offers = repository.find(city, item);
        else
            offers = repository.find(item);

        if (offers != null && offers.size() > 0) {
            Map<Integer, Long> byPrice = offers.stream().collect(groupingBy(Offer::getListPrice, HashMap::new, counting()));

            Map.Entry<Integer, Long> entry = byPrice.entrySet().stream().max(MODE).orElse(null);
            if (entry != null)
                result = new Suggestion(city, item, entry.getKey(), entry.getValue(), offers.size());
        }
        return result;
    }


    public static Comparator<Map.Entry<Integer, Long>> MODE = (o1, o2) -> {
        int result = o1.getValue().compareTo(o2.getValue());
        if (result == 0)
            result = o1.getKey().compareTo(o2.getKey());

        return result;
    };
}
