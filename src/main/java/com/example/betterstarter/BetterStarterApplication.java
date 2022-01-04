package com.example.betterstarter;

import com.example.betterstarter.connection.Author;
import com.example.betterstarter.connection.AuthorRepository;
import com.example.betterstarter.connection.DataStaxAstraProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProps.class)

public class BetterStarterApplication {



    public static void main(String[] args) {
        SpringApplication.run(BetterStarterApplication.class, args);
    }


    /**
     * This is necessary to have the Spring Boot app use the Astra secure bundle
     * to connect to the database
     */
    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProps astraProperties) {
        System.out.println(astraProperties.getSecureConnectBundle());
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }

}
