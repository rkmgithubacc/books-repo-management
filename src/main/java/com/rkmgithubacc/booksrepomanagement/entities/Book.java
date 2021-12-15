package com.rkmgithubacc.booksrepomanagement.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_ID")
    private Long bookId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "isbn", length = 100, nullable = false)
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookRef_ID"),
            inverseJoinColumns = @JoinColumn(name = "authorRef_ID"))
    private Set<Author> authorsSet = new HashSet<>();
    // Note: If authorsSet is not included in the constructor, it needs to be initialized explicitly

    @ManyToOne
    @JoinColumn(name = "publisherRef_id")
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthorsSet() {
        return authorsSet;
    }

    public void setAuthorsSet(Set<Author> authorsSet) {
        this.authorsSet = authorsSet;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId != null ? bookId.equals(book.bookId) : book.bookId == null;
    }

    @Override
    public int hashCode() {
        return bookId != null ? bookId.hashCode() : 0;
    }
}
