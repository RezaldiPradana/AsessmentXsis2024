package com.crud.rentalmobil.repository.implement;

import com.crud.rentalmobil.config.properties.AppProperties;
import com.crud.rentalmobil.config.variable.AppConstant;
import com.crud.rentalmobil.model.DataUser;
import com.crud.rentalmobil.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserImpl implements UserRepository {

    private final AppProperties appProperties;
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserImpl(@Qualifier(AppConstant.BEAN_APP_CONF) AppProperties appProperties,
                    @Qualifier(AppConstant.BEAN_JDBC_MOBIL) JdbcTemplate jdbcTemplate) {
        this.appProperties = appProperties;
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public DataUser getDataUser(String username) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("username", username);
        log.info("[----EXECQUERY {} :: {} -> {}]", "getDataUser", appProperties.getQUERY_GET_USER(), username);
        return namedParameterJdbcTemplate.query(appProperties.getQUERY_GET_USER(), mapSqlParameterSource, new BeanPropertyRowMapper<>(DataUser.class)).stream().findFirst().orElse(null);
    }
}