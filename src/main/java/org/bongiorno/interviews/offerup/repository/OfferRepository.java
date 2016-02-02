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

package org.bongiorno.interviews.offerup.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.bongiorno.interviews.offerup.domain.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends CrudRepository<Offer,Long>{

    @Query("select o from Offer o where o.title = :title and o.city = :city")
    List<Offer> find(@Param("city") String city,@Param("title") String title);

    @Query("select o from Offer o where o.title = :title")
    List<Offer> find(@Param("title") String title);

    @Query("select min(o.id) from Offer o")
    Long getMinId();

    @Query("select max(o.id) from Offer o")
    Long getMaxId();
}
