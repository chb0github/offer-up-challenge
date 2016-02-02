/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bongiorno.interviews.offerup.web;


import org.bongiorno.interviews.offerup.dto.OfferUp;
import org.bongiorno.interviews.offerup.service.OfferService;
import org.bongiorno.interviews.offerup.service.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Cacheable("offers")
    @RequestMapping(value = "/item-price-service/", method = RequestMethod.GET, produces = "application/json")
    public OfferUp getOfferUp(@RequestParam(value = "city", required = false) String city,
                              @RequestParam(value = "item", required = false) String item) {
        if (item == null) {
            if (city == null) {
                throw new ResourceNotFoundException("Not found");
            }
            throw new BadRequestException("item can't be null");
        }

        Suggestion suggestion = offerService.getSuggestionFor(city, item);
        OfferUp result = null;
        if (suggestion != null)
            result = new OfferUp(200, item, suggestion.getCount(), suggestion.getListPrice(), city);

        return result;
    }


    @Autowired
    private OfferService offerService;
}
