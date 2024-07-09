package org.koreait;

public class Main {
    public static void main(String[] args) {

        Contaniner.init();

        new App().run();

        Contaniner.close();
    }
}