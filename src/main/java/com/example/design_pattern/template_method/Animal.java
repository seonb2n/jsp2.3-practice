package com.example.design_pattern.template_method;

public abstract class Animal {


    public void playWithOwner() {
        System.out.println("다가 온다..");
        play();
        runSomething();
        System.out.println("잘 했어");
    }

    abstract void play();

    void runSomething() {
        System.out.println("꼬리 살랑");
    }
}
