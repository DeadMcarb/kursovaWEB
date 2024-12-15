package org.example.kursovabd.repositories;



import org.example.kursovabd.data.BuyExcursion;
import org.example.kursovabd.data.modelProjection.BoughtExcursionInfo;
import org.example.kursovabd.data.modelProjection.BoughtExcursionMonthZvit;
import org.example.kursovabd.data.modelProjection.BoughtExcursionZvit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyExcursionRepository extends JpaRepository<BuyExcursion, Integer> {


    @Query(value = """ 
SELECT
    be.operation_id AS OperationID,
    e.name AS ExcursionName,
    u.name AS Login,
    be.date AS Date,
    be.`number of people to excursion` AS NumberOfPeopleToExcursion,
    be.`bank card details` AS BankCardDetails,
    be.total AS Total
FROM
    buy_excursion be
JOIN
    excursion e ON be.excursion_id = e.`excursion_id`
JOIN
    user u ON be.user_id = u.id;
""", nativeQuery = true)
    List<BoughtExcursionInfo> getBoughtExcursionInfo();




    @Query(value = """ 
SELECT
    e.name AS excursionName,
    SUM(be.total) AS totalPerExcursion,
    SUM(be.`number of people to excursion`) AS totalNumberOfPeople,
    (SELECT SUM(total) FROM buy_excursion) AS totalIncome,
    (SELECT SUM(`number of people to excursion`) FROM buy_excursion) AS totalGuests
FROM
    buy_excursion be
JOIN
    excursion e ON be.excursion_id = e.excursion_id
GROUP BY
    e.name;
""", nativeQuery = true)
    List<BoughtExcursionZvit> getBoughtExcursionZvit();

    @Query(value = """ 
SELECT
    MONTH(b.date) AS excursionName,
    SUM(b.total) AS totalPerExcursion,
    SUM(b.`number of people to excursion`) AS totalNumberOfPeople,
   (SELECT SUM(total) FROM buy_excursion) AS totalIncome,
   (SELECT SUM(`number of people to excursion`) FROM buy_excursion) AS totalGuests
FROM
    buy_excursion b
GROUP BY
    MONTH(b.date)
ORDER BY
    MONTH(b.date);
""", nativeQuery = true)
    List<BoughtExcursionMonthZvit> getBoughtExcursionMonthZvit();
}