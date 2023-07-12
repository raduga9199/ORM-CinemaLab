package com.cydeo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class OrmCinemaLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmCinemaLabApplication.class, args);
    }

    @Bean // Bean has to be created before migration (Not used in real environment)
    public MigrateResult migrateResult(DataSource dataSource){
        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
