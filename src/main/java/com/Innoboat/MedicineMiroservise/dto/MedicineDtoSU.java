package com.Innoboat.MedicineMiroservise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDtoSU {

    private String id;
    private String medicineName;
    private String supplier;
    private String expireDate;
    private Integer quantity;
    private Double unitPrice;
}
