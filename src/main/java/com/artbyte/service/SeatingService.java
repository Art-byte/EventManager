package com.artbyte.service;

import com.artbyte.model.Seating;

import java.util.Optional;

public interface SeatingService {
    Seating getSeatingById(String id);
    void createSeating(Seating seating);

    Seating.SeatingName getSeatingNameByName(String seatingId, String SeatingName);
    void changeStatusToSeating(String status);
    void changeCheckedFromTicket(boolean checked);
}
