package main.java;

public class Table {
    int number;
    boolean isUsing;

    public Table(int number, boolean isUsing) {
        this.number = number;
        this.isUsing = isUsing;                     //先生は(this.isUisng = false;)と書いていた。
    }
    public int number() {
        return number;
    }
}