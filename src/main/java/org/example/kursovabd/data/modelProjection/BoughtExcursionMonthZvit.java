package org.example.kursovabd.data.modelProjection;

import java.time.Instant;

/**
 * Projection for {@link org.example.kursovabd.data.BuyExcursion}
 */
public interface BoughtExcursionMonthZvit {
    Integer getExcursionName();
    Double getTotalPerExcursion();
    Integer getTotalNumberOfPeople();
    Double getTotalIncome();
    Integer getTotalGuests();
}