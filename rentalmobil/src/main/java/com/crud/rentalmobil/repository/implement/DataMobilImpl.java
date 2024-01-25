package com.crud.rentalmobil.repository.implement;


import com.crud.rentalmobil.config.properties.AppProperties;
import com.crud.rentalmobil.config.variable.AppConstant;
import com.crud.rentalmobil.model.DataMobil;
import com.crud.rentalmobil.repository.DataMobilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DataMobilImpl implements DataMobilRepository {
    private final AppProperties appProperties;
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DataMobilImpl(@Qualifier(AppConstant.BEAN_APP_CONF) AppProperties appProperties,
                         @Qualifier(AppConstant.BEAN_JDBC_MOBIL) JdbcTemplate jdbcTemplate) {
        this.appProperties = appProperties;
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public List<DataMobil> getAllDataMobil() {
        log.info("[----EXECQUERY {} :: {}]", "getAllDataMobil", appProperties.getQUERY_GET_ALL());
        return namedParameterJdbcTemplate.query(appProperties.getQUERY_GET_ALL(), new BeanPropertyRowMapper<>(DataMobil.class));
    }

    @Override
    public DataMobil findDataMobilBySeqId(Integer seqId) {
        log.info("[----EXECQUERY {} :: {} -> {}]", "findDataMobilBySeqId", appProperties.getQUERY_FIND_BY_SEQID(), seqId);
        return jdbcTemplate.query(appProperties.getQUERY_FIND_BY_SEQID(), new BeanPropertyRowMapper<>(DataMobil.class), seqId).stream().findFirst().orElse(null);
    }

    @Override
    public void insertDataMobil(DataMobil dataMobil) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("mobil", dataMobil.getMobil());
        mapSqlParameterSource.addValue("kapasitas", dataMobil.getKapasitas());
        mapSqlParameterSource.addValue("status", dataMobil.getStatus());
        namedParameterJdbcTemplate.update(appProperties.getQUERY_INSERT_MOBIL(), mapSqlParameterSource);
        log.info("[----EXECQUERY {} :: {} -> {} | {} | {}]", "insertDataMobil", appProperties.getQUERY_INSERT_MOBIL(), dataMobil.getMobil(), dataMobil.getKapasitas(), dataMobil.getStatus());
    }

    public void updateDataMobil(DataMobil dataMobil) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("seqId", dataMobil.getSeqId());
        mapSqlParameterSource.addValue("mobil", dataMobil.getMobil());
        mapSqlParameterSource.addValue("kapasitas", dataMobil.getKapasitas());
        mapSqlParameterSource.addValue("status", dataMobil.getStatus());
        namedParameterJdbcTemplate.update(appProperties.getQUERY_UPDATE_MOBIL(), mapSqlParameterSource);
        log.info("[----EXECQUERY {} :: {} -> {} | {} | {} | {}]", "updateDataMobil", appProperties.getQUERY_UPDATE_MOBIL(), dataMobil.getSeqId(), dataMobil.getMobil(), dataMobil.getKapasitas(), dataMobil.getStatus());
    }

    @Override
    public void deleteDataMobilBySeqId(Integer seqId) {
        jdbcTemplate.update(appProperties.getQUERY_DELETE_MOBIL(), seqId);
        log.info("[----EXECQUERY {} :: {} -> {}]", "deleteDataMobil", appProperties.getQUERY_DELETE_MOBIL(), seqId);
    }
}