package com.example.design_pattern.template_method;

public class Cat extends Animal {

    @Override
    void play() {
        System.out.println("야옹 야옹");
    }

    @Override
    void runSomething() {
        System.out.println("야옹 살랑 살랑");
    }
}
