package com.drl.demo.mybatis.dto;

import java.io.Serializable;

public class TBook implements Serializable {
    private long id;

    private String bookName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
