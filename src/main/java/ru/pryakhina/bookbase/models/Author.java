package ru.pryakhina.bookbase.models;


//import org.hibernate.annotations.Table;

import javax.persistence.*;


@Entity
@Table(name = "author")
public class Author {

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
}
