package com.bookapi.bootrest.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Books {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "book_id")
    private int bookid;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Books() {
    }
    public Books(int bookid, String title, Author author) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
    }
    
}
