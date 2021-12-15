package com.rkmgithubacc.booksrepomanagement.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_ID")
    private Long authorId;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @ManyToMany(mappedBy = "authorsSet")
    private Set<Book> booksSet = new HashSet<>();
    // Note: If booksSet is not included in the constructor, it needs to be initialized explicitly

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Book> booksSet) {
        this.booksSet = booksSet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return authorId != null ? authorId.equals(author.authorId) : author.authorId == null;
    }

    @Override
    public int hashCode() {
        return authorId != null ? authorId.hashCode() : 0;
    }
}
