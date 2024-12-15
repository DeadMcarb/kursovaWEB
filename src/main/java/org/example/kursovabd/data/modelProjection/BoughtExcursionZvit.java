package org.example.kursovabd.data.modelProjection;

import java.time.Instant;

/**
 * Projection for {@link org.example.kursovabd.data.BuyExcursion}
 */
public interface BoughtExcursionZvit {

    String getExcursionName();
    Double getTotalPerExcursion();
    Integer getTotalNumberOfPeople();
    Double getTotalIncome();
    Integer getTotalGuests();

}