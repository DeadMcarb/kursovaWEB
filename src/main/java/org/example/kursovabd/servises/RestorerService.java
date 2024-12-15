package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Restorer;
import org.example.kursovabd.repositories.RestorerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RestorerService {
    private final RestorerRepository restorerRepository;

    public List<Restorer> getRestorers() {
        return restorerRepository.findAll();
    }

    public void addRestorer(String restorer_first_name, String restorer_second_name,
                            String restorer_phone_number, String restorer_email) {
        restorerRepository.save(new Restorer(restorer_first_name,restorer_second_name,
                restorer_phone_number, restorer_email));
    }

    public void deleteRestorer(int id) {
        restorerRepository.deleteById(id);
    }

    public Optional<Restorer> findById(int id) {
        return restorerRepository.findById(id);
    }

    public void updateRestorer(int RestorerId, String restorer_first_name,
                               String restorer_second_name,
                               String restorer_phone_number, String restorer_email) {
        Optional<Restorer> Restorer = restorerRepository.findById(RestorerId);
        Restorer.ifPresent(a->{
            a.setFirstName(restorer_first_name);
            a.setSecondName(restorer_second_name);
            a.setPhoneNumber(restorer_phone_number);
            a.setEmail(restorer_email);
            restorerRepository.save(a);
        });
    }
}