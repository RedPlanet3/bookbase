package ru.pryakhina.bookbase.models;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    int authorId;

    @Column(name = "authorfullname")
    String authorFullName;

//    @Column
//    @ManyToMany
//    List<Book> booksList;

    public Author(int authorId, String authorFullName) {
        this.authorId = authorId;
        this.authorFullName = authorFullName;
    }

    public Author() {
    }

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

    @Override
    public int compareTo(Object o) {
        Author other = (Author)o;
        return this.authorId - other.authorId;
    }
}
