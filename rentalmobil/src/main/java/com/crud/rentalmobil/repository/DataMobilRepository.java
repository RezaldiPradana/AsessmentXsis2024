package com.crud.rentalmobil.repository;


import com.crud.rentalmobil.model.DataMobil;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface DataMobilRepository {
    List<DataMobil> getAllDataMobil();
    DataMobil findDataMobilBySeqId(Integer seqId);
    void insertDataMobil(DataMobil dataMobil);
    void updateDataMobil(DataMobil dataMobil);
    void deleteDataMobilBySeqId(Integer seqId);
}