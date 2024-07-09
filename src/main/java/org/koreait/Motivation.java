package org.koreait;

public class Motivation {
    private int id;
    private String regDate;
    private String updateDate;
    private String author;
    private String body;

    Motivation(int id, String regDate, String updateDate, String author, String body) {
        this.id = id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.author = author;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
