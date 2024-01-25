package com.crud.rentalmobil.config.properties;


import lombok.Data;
@Data
public class AppProperties {

    /* App Config */
    private String APP_NAME = "rental-mobil";
    private String APP_VERSION = "v1";

    /* Query */
    private String QUERY_GET_ALL = "SELECT * FROM tb_mobil ORDER BY \"seqId\" ASC";
    private String QUERY_FIND_BY_SEQID = "SELECT * FROM tb_mobil WHERE \"seqId\" = ?";
    private String QUERY_INSERT_MOBIL = "INSERT INTO tb_mobil (\"mobil\", \"kapasitas\", \"status\") VALUES (:mobil, :kapasitas, :status)";
    private String QUERY_UPDATE_MOBIL = "UPDATE tb_mobil SET \"mobil\" = :mobil, \"kapasitas\" = :kapasitas, \"status\" = :status WHERE \"seqId\" = :seqId";
    private String QUERY_DELETE_MOBIL = "DELETE FROM tb_mobil WHERE \"seqId\" = ?";
    private String QUERY_GET_USER = "SELECT username, password, role FROM \"user_data\" WHERE \"username\" = :username";
}