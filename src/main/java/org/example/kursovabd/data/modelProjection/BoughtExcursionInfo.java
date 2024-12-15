package org.example.kursovabd.data.modelProjection;

import java.time.Instant;

public interface BoughtExcursionInfo {
    Integer getOperationID();

    String getExcursionName();
    String getLogin();


    Instant getDate();
    Integer getNumberOfPeopleToExcursion();

    String getBankCardDetails();
    String getTotal();
}


