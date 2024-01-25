package com.crud.rentalmobil.repository;

import com.crud.rentalmobil.model.DataUser;

public interface UserRepository {
    DataUser getDataUser(String username);
}
