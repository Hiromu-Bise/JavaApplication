package main.java;

public class Menu {
    int price;
    String name;

    public Menu(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public int price() {
        return price;
    }
    public String name() {
        return name;
    }
}