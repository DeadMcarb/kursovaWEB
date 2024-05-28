package org.example.kursovabd.Servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Painting;
import org.example.kursovabd.data.Restoration;
import org.example.kursovabd.data.Restorer;
import org.example.kursovabd.repositories.RestorationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RestorationService {
    private final RestorationRepository restorationRepository;


    public List<Restoration> getRestorations() {
        return restorationRepository.findAll();
    }

    public void deleteRestoration(int id) {
        restorationRepository.deleteById(id);
    }

    public Optional<Restoration> findById(int id) {
        return restorationRepository.findById(id);
    }

    public void addRestoration(Restorer restorerId, Painting paintingId, Instant startDate, Instant endDate, Integer status, Double price) {

        restorationRepository.save(new Restoration(restorerId, paintingId,
                startDate, endDate,
                status, price));
    }

    public void updateRestoration(int RestorationId, Restorer restorerId, Painting paintingId,
                                  Instant startDate, Instant endDate, Integer status, Double price) {

        Optional<Restoration> Restoration = restorationRepository.findById(RestorationId);
        Restoration.ifPresent(a->{
            a.setRestorer(restorerId);
            a.setPainting(paintingId);
            a.setStartDate(startDate);
            a.setEndDate(endDate);
            a.setStatus(status);
            a.setPrice(price);
            restorationRepository.save(a);
        });
    }
}