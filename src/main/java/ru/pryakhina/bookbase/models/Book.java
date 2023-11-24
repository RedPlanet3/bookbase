package ru.pryakhina.bookbase.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookId;

    @Column(name = "bookname")
    private String bookName;
    @Column(name = "genre")
    private String genre;

    @ManyToMany(cascade =  CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authorList) {
        this.authors = authorList;
    }

    public void addBookAuthor(Author author){
        if (authors == null) {
            authors = new ArrayList<>();
        }
        authors.add(author);
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    public Book(String bookName, String genre) {
        this.bookName = bookName;
        this.genre = genre;
    }

    public Book() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int compareTo(Object o) {
        Book other = (Book)o;
        return this.bookId - other.bookId;
    }

}
