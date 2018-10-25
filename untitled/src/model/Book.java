package model;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private int price;
    private String intro;

    public String  getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }
    public Book(String bookId, String title,String author, int price, String intro) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.intro = intro;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
