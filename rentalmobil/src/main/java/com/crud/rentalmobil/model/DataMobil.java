package com.crud.rentalmobil.model;

import lombok.Data;

@Data
public class DataMobil {
    private Integer seqId;
    private String mobil;
    private Integer kapasitas;
    private String status;
}