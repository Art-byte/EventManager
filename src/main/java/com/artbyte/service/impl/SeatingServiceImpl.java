package com.artbyte.service.impl;

import com.artbyte.exceptions.SeatingException;
import com.artbyte.model.Seating;
import com.artbyte.repository.SeatingRepository;
import com.artbyte.service.SeatingService;
import com.artbyte.utils.RandomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatingServiceImpl implements SeatingService {

    private final SeatingRepository seatingRepository;

    @Override
    public Seating getSeatingById(String id) {
        return seatingRepository.findById(id)
                .orElseThrow(() -> new SeatingException("Coleccion de objetos no encontrado por ID"));
    }

    @Override
    public void createSeating(Seating seating) {
        List<Seating.SeatingName> namesWithCodeGeneratedList = new ArrayList<>();

        for(Seating.SeatingName seatingItem: seating.getSeatingNames()){
            seatingItem.setSeatingCode(RandomCodeGenerator.generateSeatingCode());
            namesWithCodeGeneratedList.add(seatingItem);
        }
        seating.setSeatingNames(namesWithCodeGeneratedList);
        seatingRepository.save(seating);
    }

    @Override
    public Seating.SeatingName getSeatingNameByName(String id, String seatingName) {
        Seating seatingObj = getSeatingById(id);
        return seatingObj.getSeatingNames().stream()
                .filter(name -> name.getName().equals(seatingName))
                .findFirst()
                .orElseThrow(() -> new SeatingException("Asiento no encontrado por NAME"));
    }


    @Override
    public void changeStatusToSeating(String status) {

    }

    @Override
    public void changeCheckedFromTicket(boolean checked) {

    }
}
