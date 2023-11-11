package ru.pryakhina.bookbase.models;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookId;

    @Column(name = "bookname")
    private String bookName;

//    @OneToMany
//    private List<Autor> autors;

    @Column(name = "genre")
    private Genre genre;
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }



    public Book(int bookId, String bookName, Genre genre) {
        this.bookId = bookId;
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

//    public List<Autor> getAutors() {
//        return autors;
//    }

//    public void setAutors(List<Autor> autors) {
//        this.autors = autors;
//    }
}
