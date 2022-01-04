package com.example.betterstarter.connection;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AuthorRepository extends CassandraRepository<Author, String> {

}
