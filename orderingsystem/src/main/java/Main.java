package main.java;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu coffee = new Menu(400, "coffee");
        Menu cafe_au_lait = new Menu(500, "cafe_au_lait");
        Menu muffin = new Menu(700, "muffin");

        List<Menu> menuList1 = List.of(coffee, cafe_au_lait, muffin);
        List<Menu> menuList2 = List.of(coffee, cafe_au_lait);
        List<Menu> menuList3 = List.of(coffee);


    }
}