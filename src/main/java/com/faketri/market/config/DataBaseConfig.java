package com.faketri.market.config;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class DataBaseConfig {

    //@Bean
    public NamedParameterJdbcTemplate template(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
