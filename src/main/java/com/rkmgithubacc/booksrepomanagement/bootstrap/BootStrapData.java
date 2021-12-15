package com.rkmgithubacc.booksrepomanagement.bootstrap;

import com.rkmgithubacc.booksrepomanagement.entities.Author;
import com.rkmgithubacc.booksrepomanagement.entities.Book;
import com.rkmgithubacc.booksrepomanagement.entities.Publisher;
import com.rkmgithubacc.booksrepomanagement.repositories.AuthorRepository;
import com.rkmgithubacc.booksrepomanagement.repositories.BookRepository;
import com.rkmgithubacc.booksrepomanagement.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started through bootstrap");

        Publisher publisher = new Publisher("SNS Publications",
                "Flat#104, Inner Circle Road, Whitefield",
                "Bengaluru", "Karnataka", "560068");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author author1 = new Author("Roshan", "Mahapatra");
        Book book1 = new Book("Domain Driven Design", "12456");
        author1.getBooksSet().add(book1);
        book1.getAuthorsSet().add(author1);
        book1.setPublisher(publisher);
        publisher.getPublisherBooksSet().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author author2 = new Author("Rahul", "Malhotra");
        Book book2 = new Book("Spring Framework 5", "142365");
        author2.getBooksSet().add(book2);
        book2.getAuthorsSet().add(author2);
        book2.setPublisher(publisher);
        book1.getAuthorsSet().add(author2);
        publisher.getPublisherBooksSet().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book1);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Number of books stored: " + bookRepository.count());
        System.out.println("Published number of books: " + publisher.getPublisherBooksSet().size());
    }
}
