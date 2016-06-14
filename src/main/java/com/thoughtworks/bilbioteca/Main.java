package com.thoughtworks.bilbioteca;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        new Application(new PrintStream(System.out)).start();
    }
}
