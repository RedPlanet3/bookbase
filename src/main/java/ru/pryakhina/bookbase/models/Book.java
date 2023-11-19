package ru.pryakhina.bookbase.models;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookId;

    @Column(name = "bookname")
    private String bookName;

//    @OneToMany
//    private List<Autor> autors;

    @Column(name = "genre")
    private String genre;
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

//    public List<Autor> getAutors() {
//        return autors;
//    }

//    public void setAutors(List<Autor> autors) {
//        this.autors = autors;
//    }
}
