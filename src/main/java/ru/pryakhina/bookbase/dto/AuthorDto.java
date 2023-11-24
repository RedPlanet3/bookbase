package ru.pryakhina.bookbase.dto;

public class AuthorDto {
    int authorId;
    String authorFullName;
    private int booksCount;

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public AuthorDto(int authorId, String authorFullName) {
        this.authorId = authorId;
        this.authorFullName = authorFullName;
    }

    public AuthorDto() {}

    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }
    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}
