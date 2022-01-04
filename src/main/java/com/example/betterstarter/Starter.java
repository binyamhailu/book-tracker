package com.example.betterstarter;

import com.example.betterstarter.connection.Author;
import com.example.betterstarter.connection.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Starter implements CommandLineRunner {
    private final AuthorRepository authorRepository ;

    public Starter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------------------STARTING APPLICATION------------------");
        Author author = new Author() ;

        author.setId("thisisid");
        author.setName("name");
        author.setPersonalName("pname");
        authorRepository.save(author) ;
    }
}
