package com.rkmgithubacc.booksrepomanagement.repositories;

import com.rkmgithubacc.booksrepomanagement.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}