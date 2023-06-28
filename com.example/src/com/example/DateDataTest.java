package com.example;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DateDataTest {
    DateData dd;

    DateDataTest() {
        dd = new DateData();
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setDateData() {
        dd.setDateData(null);
        assertNull(dd.getDateData());
    }

    @org.junit.jupiter.api.Test
    void getDateData() {
        dd.setDateData("20200916");
        assertEquals("20200916", dd.getDateData());

    }

    @org.junit.jupiter.api.Test
    void getToday() {
        Calendar cal = Calendar.getInstance();
        String toDay = String.format("%02d", cal.get(Calendar.YEAR)) +
                String.format("%02d", cal.get(Calendar.MONTH) + 1) +
                String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(toDay, dd.getToday());

    }

    @org.junit.jupiter.api.Test
    void isToday() {
        assertEquals(true, dd.isToday(dd.getToday()));
    }

    @org.junit.jupiter.api.Test
    void isLeapYear() {
        assertEquals(true, dd.isLeapYear("20200916"));
        assertEquals(false, dd.isLeapYear("20210916"));
        assertEquals(true, dd.isLeapYear("20000916"));
        assertEquals(true, dd.isLeapYear(2020));
        assertEquals(false, dd.isLeapYear(2021));
        assertEquals(true, dd.isLeapYear(20000));
    }

    @org.junit.jupiter.api.Test
    void testIsLeapYear() {
    }
}