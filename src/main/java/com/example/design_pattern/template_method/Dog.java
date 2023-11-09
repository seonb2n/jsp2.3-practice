package com.example.design_pattern.template_method;

public class Dog extends Animal {

    @Override
    void play() {
        System.out.println("멍! 멍!");
    }

    @Override
    void runSomething() {
        System.out.println("멍 멍 살랑 살랑");
    }
}
