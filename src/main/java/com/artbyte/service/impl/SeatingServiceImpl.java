package com.artbyte.service.impl;

import com.artbyte.exceptions.SeatingException;
import com.artbyte.model.Seating;
import com.artbyte.repository.SeatingRepository;
import com.artbyte.service.SeatingService;
import com.artbyte.utils.RandomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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
            seatingItem.setStatus(1);
            seatingItem.setSeatingCode(RandomCodeGenerator.generateSeatingCode());
            namesWithCodeGeneratedList.add(seatingItem);
        }
        seating.setSeatingNames(namesWithCodeGeneratedList);
        seatingRepository.save(seating);
    }

    /*
    * Obtenemos la coleccion de asientos y de esta
    * buscamos el asiendo que nos toca por su nombre
    * */
    @Override
    public Seating.SeatingName getSeatingNameByName(String id, String seatingName) {
        Seating seatingObj = getSeatingById(id);
        return seatingObj.getSeatingNames().stream()
                .filter(name -> name.getName().equals(seatingName))
                .findFirst()
                .orElseThrow(() -> new SeatingException("Asiento no encontrado por NAME"));
    }


    /*
    * Obtenemos primero la coleccion de asientos y de esta
    * buscamos en su lista de asientos el correspondiente para
    * editar su estatus
    * */
    @Override
    public void changeStatusToSeating(String seatingId, String nameSeating, Integer status) {
        Seating seatingObj = getSeatingById(seatingId);
        List<Seating.SeatingName> seatingNames = seatingObj.getSeatingNames();

        //Buscamos y actualizamos directamente sobre la lista
        boolean updated = false;
        for(Seating.SeatingName seatingItem: seatingNames){
            if(seatingItem.getName().equals(nameSeating)){
                seatingItem.setStatus(status);
                updated = true;
                break;
            }
        }

        if(!updated){
            throw new SeatingException("Asiento no encontrado: " + nameSeating);
        }
        seatingRepository.save(seatingObj);
    }

    @Override
    public void changeCheckedFromTicket(String idSeating, String nameSeating, boolean checked) {
        Seating seatingObj = getSeatingById(idSeating);
        List<Seating.SeatingName> seatinNames = seatingObj.getSeatingNames();

        boolean updated = false;
        for(Seating.SeatingName seatingItem: seatinNames){
            if(seatingItem.getName().equals(nameSeating)){
                seatingItem.setChecked(checked);
                updated = true;
                break;
            }
        }

        if(!updated){
            throw new SeatingException("Asiento no encontrado: " + nameSeating);
        }
        seatingRepository.save(seatingObj);
    }
}
