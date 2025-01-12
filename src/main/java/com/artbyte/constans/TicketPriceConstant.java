package com.artbyte.constans;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum TicketPriceConstant {

    GENERAL("GENERAL"),
    FLOOR("PISTA"),
    PREFERRED("PREFERENTE"),
    VIP("VIP"),

    ADD_QUANTITY("ADD"),
    REMOVE_QUANTITY("REMOVE"),

    ACTIVE("ACTIVE" ),
    INACTIVE("INACTIVE");

    public String name;

}
