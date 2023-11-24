package ru.pryakhina.bookbase.dto;

import java.util.List;

public class BookDto {
    private int bookId;
    private String bookName;
    private String genre;
    private List<AuthorDto> authors;

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authorList) {
        this.authors = authorList;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public void addBookAuthor(AuthorDto author){
//        if (authors == null) {
//            authors = new ArrayList<>();
//        }
//        authors.add(author);
//    }

    public BookDto(String bookName, String genre) {
        this.bookName = bookName;
        this.genre = genre;
    }

    public BookDto() {

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


}
