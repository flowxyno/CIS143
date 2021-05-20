package com.olympic.cis143.m05.student.homework.annotations1;

public class Main {

    public static void main(String[] a) {
        Main main = new Main();
        main.callSayHello();
        main.callSayGoodBye();
    }

    @SuppressWarnings("deprecation")
    private void callSayHello() {
        new HomeworkAnnotations().sayHello();
    }

    @SuppressWarnings("deprecation")
    private void callSayGoodBye() {
        new HomeworkAnnotations().sayGoodBye();
    }
}
