package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.*;

import org.example.kursovabd.data.modelProjection.BoughtExcursionInfo;
import org.example.kursovabd.data.modelProjection.BoughtExcursionMonthZvit;
import org.example.kursovabd.data.modelProjection.BoughtExcursionZvit;
import org.example.kursovabd.repositories.BuyExcursionRepository;
import org.example.kursovabd.data.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuyExcursionService {
    private final BuyExcursionRepository buyExcursionRepository;

    public List<BoughtExcursionInfo> getBoughtExcursionInfo() {return buyExcursionRepository.getBoughtExcursionInfo();};

    public List<BoughtExcursionZvit> getBoughtExcursionZvit(){return buyExcursionRepository.getBoughtExcursionZvit();}

    public List<BoughtExcursionMonthZvit> getBoughtExcursionMonthZvit(){return buyExcursionRepository.getBoughtExcursionMonthZvit();};
    public void addBoughtExcursion(Instant date, String bankCardDetails, Integer numberOfPeopleToExcursion, User user, Excursion excursion, Double total) {
        BuyExcursion b = new BuyExcursion(date, bankCardDetails, numberOfPeopleToExcursion, excursion, user, total);

        buyExcursionRepository.save(b);
    }


    public void deleteBoughtExcursion(int id) {
        buyExcursionRepository.deleteById(id);
    }

    public Optional<BuyExcursion> findById(int id) {
        return buyExcursionRepository.findById(id);
    }

//    public void updateBoughtExcursion(int BoughtExcursionId, Instant date, String bankCardDetails, Integer numberOfPeopleToExcursion, User user, Excursion excursion) {
//        Optional<BuyExcursion> excursion = boughtExcursionRepository.findById(BoughtExcursionId);
//
//        excursion.ifPresent(a->{
//            if (artist.isPresent()&&style.isPresent()&&genre.isPresent() ) {
//                a.setName(name);
//                a.setArtist(artist.get());
//                a.setStyle(style.get());
//                a.setGenre(genre.get());
//                a.setOriginaly(originaly);
//                a.setWorth(worth);
//                a.setRoomId(roomId);
//                a.setDescription(description);
//
//                boughtExcursionRepository.save(a);
//            }
//        });
//    }

}