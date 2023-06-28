package main;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void generate() {
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
        assertEquals(true, PrimeNumber.isPrime(3));
        assertEquals(true, PrimeNumber.isPrime(5));
        assertEquals(true, PrimeNumber.isPrime(7));
        assertEquals(true, PrimeNumber.isPrime(11));
        assertEquals(true, PrimeNumber.isPrime(83));
        assertEquals(false, PrimeNumber.isPrime(4));
        assertEquals(false, PrimeNumber.isPrime(20));

    }

    @org.junit.jupiter.api.Test
    void getPrime() {
        assertEquals(2, PrimeNumber.getPrime(1));
        assertEquals(3, PrimeNumber.getPrime(2));
        assertEquals(5, PrimeNumber.getPrime(3));
        assertEquals(11, PrimeNumber.getPrime(5));
        assertEquals(13, PrimeNumber.getPrime(6));
        assertEquals(17, PrimeNumber.getPrime(7));

    }
}