package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.Style;
import org.example.kursovabd.repositories.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StyleService {
    private final StyleRepository styleRepository;

    public List<Style> getStyles() {
        return styleRepository.findAll();
    }

    public Optional<Style> findById(int id) {
        return styleRepository.findById(id);
    }

}