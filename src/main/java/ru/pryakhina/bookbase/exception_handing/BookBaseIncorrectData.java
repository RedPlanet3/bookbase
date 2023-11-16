package ru.pryakhina.bookbase.exception_handing;

public class BookBaseIncorrectData {

    private String info;

    public BookBaseIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
