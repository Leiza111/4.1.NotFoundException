package ru.netology.domain;

public class Book extends Product {
    private String author;

    //конструкторы
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book(String author) {
        this.author = author;
    }


   //get/set
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
