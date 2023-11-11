package ru.pryakhina.bookbase.models;


//import org.hibernate.annotations.Table;

import javax.persistence.*;


@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    int authorId;

    @Column(name = "authorfullname")
    String authorFullName;

//    @Column
//    @ManyToMany
//    List<Book> booksList;

    public Autor(int authorId, String authorFullName) {
        this.authorId = authorId;
        this.authorFullName = authorFullName;
    }

    public Autor() {
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
