package com.artbyte.constans;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SeatingStatus {
    AVAILABLE(1),
    RESERVED(2),
    SOLD(3);

    public final Integer status;
}
