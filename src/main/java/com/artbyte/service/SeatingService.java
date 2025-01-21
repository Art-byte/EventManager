package com.artbyte.service;

import com.artbyte.model.Seating;

import java.util.Optional;

public interface SeatingService {
    Seating getSeatingById(String id);
    void createSeating(Seating seating);

    Seating.SeatingName getSeatingNameByName(String seatingId, String seatingName);
    void changeStatusToSeating(String idSeating, String nameSeating, Integer status);
    void changeCheckedFromTicket(String idSeating, String nameSeating, boolean checked);
}
