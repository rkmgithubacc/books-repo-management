package com.rkmgithubacc.booksrepomanagement.repositories;

import com.rkmgithubacc.booksrepomanagement.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}