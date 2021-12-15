package com.rkmgithubacc.booksrepomanagement.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_ID")
    private Long publisherId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String addressLine;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 20, nullable = false)
    private String state;

    @Column(length = 10, nullable = false)
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> publisherBooksSet = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String addressLine, String city, String state, String zip) {
        this.name = name;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Set<Book> getPublisherBooksSet() {
        return publisherBooksSet;
    }

    public void setPublisherBooksSet(Set<Book> publisherBooksSet) {
        this.publisherBooksSet = publisherBooksSet;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", publisherBooksSet=" + publisherBooksSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return publisherId != null ? publisherId.equals(publisher.publisherId) : publisher.publisherId == null;
    }

    @Override
    public int hashCode() {
        return publisherId != null ? publisherId.hashCode() : 0;
    }
}
