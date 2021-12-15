package com.rkmgithubacc.booksrepomanagement.repositories;

import com.rkmgithubacc.booksrepomanagement.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}