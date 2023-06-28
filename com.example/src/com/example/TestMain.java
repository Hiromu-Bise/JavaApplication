package com.example;

public class TestMain {
    public static void main(String[] args) {
        DateData dd;
        dd = new DateData();
        dd.setDateData("20200920");
        if (dd.isToday(dd.getDateData())) {
            System.out.printf("%s は 今日です\n", dd.getDateData());
        } else {
            System.out.printf("%s は 今日ではありません\n", dd.getDateData());
        }
        if (dd.isLeapYear(dd.getDateData())) {
            System.out.printf("%s はうるう年です\n", dd.getDateData());
        } else {
            System.out.printf("%s はうるう年ではありません\n", dd.getDateData());
        }
        System.out.printf("今日は%sです\n", dd.getToday());
    }
}
