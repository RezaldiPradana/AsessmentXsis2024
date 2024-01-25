package com.crud.rentalmobil.model;

import lombok.Data;

@Data
public class DataUser {
    private String userId;
    private String username;
    private String password;
    private String role;
}